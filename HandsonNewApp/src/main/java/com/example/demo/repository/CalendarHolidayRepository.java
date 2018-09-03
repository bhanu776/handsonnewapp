package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.SetHolidayCalendar;

public interface CalendarHolidayRepository extends CrudRepository<SetHolidayCalendar, Integer>{
	
	@Query("select h from SetHolidayCalendar h where day=?1 and month=?2")
	public List<SetHolidayCalendar> getHolidayAccDate(int day, int month);

}
