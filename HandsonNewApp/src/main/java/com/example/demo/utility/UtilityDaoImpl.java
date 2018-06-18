package com.example.demo.utility;

import java.util.Calendar;
import java.util.Date;

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

}
