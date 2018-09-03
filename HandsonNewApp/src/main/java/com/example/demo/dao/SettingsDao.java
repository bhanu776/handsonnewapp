package com.example.demo.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.example.demo.model.SetHolidayCalendar;
import com.example.demo.model.Settings;
import com.example.demo.repository.CalendarHolidayRepository;
import com.example.demo.repository.SettingsRepository;
import com.example.demo.utility.UtilityDao;

@Service
public class SettingsDao {
	
	@Autowired
	SettingsRepository settingsRepository;
	
	@Autowired
	CalendarHolidayRepository calendarHolidayRepository;
	
	@Autowired
	UtilityDao utilityDao;
	
	public Settings saveSettings(Settings settings){
		return settingsRepository.save(settings);
	}
	
	public Settings getSettings(int id) {
		Optional<Settings> settings = settingsRepository.findById(id);
		if(settings.isPresent())
			return settings.get();
		else
			return new Settings();
	}
	
	
	/*============================Calendar=================================*/
	
	public SetHolidayCalendar saveHoliday(SetHolidayCalendar setHolidayCalendar){
		return calendarHolidayRepository.save(setHolidayCalendar);
	}
	
	public List<SetHolidayCalendar> getHolidayList(){
		return (List<SetHolidayCalendar>) calendarHolidayRepository.findAll();
	}
	
	public int isDateExist(int day, int month){
		List<SetHolidayCalendar> setHolidayCalendarList = calendarHolidayRepository.getHolidayAccDate(day, month);
		if(CollectionUtils.isEmpty(setHolidayCalendarList))
			return 0;
		else
			return setHolidayCalendarList.get(0).getId();
	}
	
	public void deleteHoliday(int id){
		calendarHolidayRepository.deleteById(id);
	}
	
	public boolean isHoliday(){
		Map<String, Integer> dateMap = utilityDao.getDayMonthYear();
		List<SetHolidayCalendar> setHolidayCalendars = calendarHolidayRepository.getHolidayAccDate(dateMap.get("day"), dateMap.get("month"));
		
		if(!setHolidayCalendars.isEmpty())
			return true;
		else
			return false;
	}
	
}
