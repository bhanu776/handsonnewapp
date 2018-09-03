package com.example.demo.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

@Component
public class UtilityDaoImpl implements UtilityDao{

	@Override
	public boolean isWeekend() {
		boolean isWeekend = false;
		int day;
		 Calendar calendar = Calendar.getInstance();
	        calendar.setTime(new Date());
	        day = calendar.get(Calendar.DAY_OF_WEEK);
	        if(day==6|| day==7 || day==1)
	        	isWeekend = true;
		return isWeekend;
	}

	@Override
	public Map<String, Long> timeDifference(Date startDate, Date endDate) {
		Map<String, Long> timeDetails = new HashMap<>();
		long diff = endDate.getTime() - startDate.getTime();
	    long diffSeconds = diff / 1000 % 60;
	    long diffMinutes = diff / (60 * 1000) % 60;
	    long diffHours = diff / (60 * 60 * 1000);
	    timeDetails.put("diffSeconds", diffSeconds);
	    timeDetails.put("diffMinutes", diffMinutes);
	    timeDetails.put("diffHours", diffHours);
		return timeDetails;
	}

	@Override
	public boolean sessionExpired(HttpSession session) {
		if(session.isNew())
			return true;
			else{
				String user = (String) session.getAttribute("user");
				if(user!=null && (user.equalsIgnoreCase("admin") || user.equalsIgnoreCase("user"))){
					return false;
				}else
					return true;
			}
	}

	@Override
	public boolean isAdmin(HttpSession session) {
		if(session!=null)
		{
			String user = (String) session.getAttribute("user");
			if(user.equalsIgnoreCase("admin"))
				return true;
		}
		return false;
	}

	@Override
	public Date uiDateStringInDate(String date) {
		Date javaDate = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
			javaDate =  sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return javaDate;
	}

	@Override
	public String javaDateToUiDate(Date jDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		return sdf.format(jDate);
	}

	@Override
	public int currentYear(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy");
		return Integer.parseInt(df.format(date));
	}

	@Override
	public Map<String, Integer> getDayMonthYear() {
		Map<String, Integer> dateMap = new HashMap<>();
		
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		dateMap.put("year", localDate.getYear());
		dateMap.put("month", localDate.getMonthValue());
		dateMap.put("day", localDate.getDayOfMonth());
		
		return dateMap;
	}
	
	

	
}
