package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Events;

public interface EventRepository extends CrudRepository<Events, Integer>{

	@Query("select e from Events e where payment_status = ?1")
	public List<Events> listOfUpcommingEvents(int id);
	
	@Query("select e from Events e where cast(e.date as date) = ADDDATE(?1,0)")
	public List<Events> todaysEvents(String currentDate);
}
