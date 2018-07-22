package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Settings {

	@Id
	private Integer id=1;
	private Integer admin_id;
	private Float library_cost;
	private Float playzone_cost;
	private Float library_cost_weekend;
	private Float playzone_cost_weekend;
	private Float weekday_secondhr_cost;
	private Float weekend_secondhr_cost;
	private Float membership_cost_playzone;
	private Float membership_cost_library;
	private Float special_cost;
	private Float cgst;
	private Float sgst;
	private Float discount;
	private Integer grace_time;
	private String phone;
	private Integer socks;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(Integer admin_id) {
		this.admin_id = admin_id;
	}
	public Float getLibrary_cost() {
		return library_cost;
	}
	public void setLibrary_cost(Float library_cost) {
		this.library_cost = library_cost;
	}
	public Float getPlayzone_cost() {
		return playzone_cost;
	}
	public void setPlayzone_cost(Float playzone_cost) {
		this.playzone_cost = playzone_cost;
	}
	public Integer getGrace_time() {
		return grace_time;
	}
	public void setGrace_time(Integer grace_time) {
		this.grace_time = grace_time;
	}
	public Float getLibrary_cost_weekend() {
		return library_cost_weekend;
	}
	public void setLibrary_cost_weekend(Float library_cost_weekend) {
		this.library_cost_weekend = library_cost_weekend;
	}
	public Float getPlayzone_cost_weekend() {
		return playzone_cost_weekend;
	}
	public void setPlayzone_cost_weekend(Float playzone_cost_weekend) {
		this.playzone_cost_weekend = playzone_cost_weekend;
	}
	public Float getCgst() {
		return cgst;
	}
	public void setCgst(Float cgst) {
		this.cgst = cgst;
	}
	public Float getSgst() {
		return sgst;
	}
	public void setSgst(Float sgst) {
		this.sgst = sgst;
	}
	public Float getDiscount() {
		return discount;
	}
	public void setDiscount(Float discount) {
		this.discount = discount;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Float getWeekday_secondhr_cost() {
		return weekday_secondhr_cost;
	}
	public void setWeekday_secondhr_cost(Float weekday_secondhr_cost) {
		this.weekday_secondhr_cost = weekday_secondhr_cost;
	}
	public Float getWeekend_secondhr_cost() {
		return weekend_secondhr_cost;
	}
	public void setWeekend_secondhr_cost(Float weekend_secondhr_cost) {
		this.weekend_secondhr_cost = weekend_secondhr_cost;
	}
	public Float getSpecial_cost() {
		return special_cost;
	}
	public void setSpecial_cost(Float special_cost) {
		this.special_cost = special_cost;
	}
	public Float getMembership_cost_playzone() {
		return membership_cost_playzone;
	}
	public void setMembership_cost_playzone(Float membership_cost_playzone) {
		this.membership_cost_playzone = membership_cost_playzone;
	}
	public Float getMembership_cost_library() {
		return membership_cost_library;
	}
	public void setMembership_cost_library(Float membership_cost_library) {
		this.membership_cost_library = membership_cost_library;
	}
	public Integer getSocks() {
		return socks;
	}
	public void setSocks(Integer socks) {
		this.socks = socks;
	}
	@Override
	public String toString() {
		return "Settings [id=" + id + ", admin_id=" + admin_id + ", library_cost=" + library_cost + ", playzone_cost="
				+ playzone_cost + ", library_cost_weekend=" + library_cost_weekend + ", playzone_cost_weekend="
				+ playzone_cost_weekend + ", weekday_secondhr_cost=" + weekday_secondhr_cost
				+ ", weekend_secondhr_cost=" + weekend_secondhr_cost + ", membership_cost_playzone="
				+ membership_cost_playzone + ", membership_cost_library=" + membership_cost_library + ", special_cost="
				+ special_cost + ", cgst=" + cgst + ", sgst=" + sgst + ", discount=" + discount + ", grace_time="
				+ grace_time + ", phone=" + phone + ", socks=" + socks + "]";
	}
	
}
