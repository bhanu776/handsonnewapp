package com.example.demo.utility;

import java.util.Date;
import java.util.Map;

public interface UtilityDao {

	public boolean isWeekend();
	public Map<String, Long> timeDifference(Date startDate,Date endDate);
}
