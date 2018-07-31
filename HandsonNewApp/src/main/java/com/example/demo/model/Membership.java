package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Membership {

	@Id
	@GeneratedValue
	private Integer id;
	private Integer child_id;
	private String child_name;
	private String startDateStr;
	private String endDateStr;
	private Date start_date;
	private Date end_date;
	private Integer hours;
	private Integer rest_time=0;
	private Integer status=0;
	private Date updatedDate;
	
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
	
	public String getStartDateStr() {
		return startDateStr;
	}
	public void setStartDateStr(String startDateStr) {
		this.startDateStr = startDateStr;
	}
	public String getEndDateStr() {
		return endDateStr;
	}
	public void setEndDateStr(String endDateStr) {
		this.endDateStr = endDateStr;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
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
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	@Override
	public String toString() {
		return "Membership [id=" + id + ", child_id=" + child_id + ", child_name=" + child_name + ", startDateStr="
				+ startDateStr + ", endDateStr=" + endDateStr + ", start_date=" + start_date + ", end_date=" + end_date
				+ ", hours=" + hours + ", rest_time=" + rest_time + ", status=" + status + ", updatedDate="
				+ updatedDate + "]";
	}
	
	
	
}
