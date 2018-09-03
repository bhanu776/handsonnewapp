package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SetHolidayCalendar {
	
	@Id
	@GeneratedValue
	Integer id;
	Integer day;
	Integer month;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDay() {
		return day;
	}
	public void setDay(Integer day) {
		this.day = day;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public SetHolidayCalendar() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SetHolidayCalendar(Integer day, Integer month) {
		super();
		this.day = day;
		this.month = month;
	}
	

}
