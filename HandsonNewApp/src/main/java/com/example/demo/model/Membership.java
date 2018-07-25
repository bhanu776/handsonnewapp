package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Membership {

	@Id
	@GeneratedValue
	Integer id;
	Integer child_id;
	String child_name;
	String start_date;
	String end_date;
	Integer hours;
	Integer rest_time=0;
	Integer status=0;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getChild_id() {
		return child_id;
	}
	public void setChild_id(Integer child_id) {
		this.child_id = child_id;
	}
	public String getChild_name() {
		return child_name;
	}
	public void setChild_name(String child_name) {
		this.child_name = child_name;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public Integer getHours() {
		return hours;
	}
	public void setHours(Integer hours) {
		this.hours = hours;
	}
	
	public Integer getRest_time() {
		return rest_time;
	}
	public void setRest_time(Integer rest_time) {
		this.rest_time = rest_time;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Membership [id=" + id + ", child_id=" + child_id + ", child_name=" + child_name + ", start_date="
				+ start_date + ", end_date=" + end_date + ", hours=" + hours + ", rest_time=" + rest_time + ", status="
				+ status + "]";
	}
	
}
