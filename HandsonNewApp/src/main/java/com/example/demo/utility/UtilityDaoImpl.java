package com.example.demo.utility;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
	        if(day==6|| day==7 || day==1);
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

	
}
