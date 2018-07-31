package com.example.demo.utility;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

public interface UtilityDao {

	public boolean isWeekend();
	public Map<String, Long> timeDifference(Date startDate,Date endDate);
	public boolean sessionExpired(HttpSession session);
	public boolean isAdmin(HttpSession session);
	public Date uiDateStringInDate(String date);
	public String javaDateToUiDate(Date jDate);
}
