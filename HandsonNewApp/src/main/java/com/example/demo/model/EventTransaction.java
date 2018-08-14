package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class EventTransaction {
	
	@Id
	@GeneratedValue
	Integer id;
	Integer event_id;
	Float total_food_charge_child=0.0f;
	Float total_food_charge_adult=0.0f;
	Float total_entry_charge_child=0.0f;
	Float total_entry_charge_adult=0.0f;
	Float playcost;
	Float miscellaneous;
	Float catering;
	Float cafe;
	Float deposit=0.0f;
	Float total_charge=0.0f;
	Float gst;
	Float sub_total;
	Float pay_amount;
	Float return_amount;
	String date;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getEvent_id() {
		return event_id;
	}
	public void setEvent_id(Integer event_id) {
		this.event_id = event_id;
	}
	public Float getTotal_food_charge_child() {
		return total_food_charge_child;
	}
	public void setTotal_food_charge_child(Float total_food_charge_child) {
		this.total_food_charge_child = total_food_charge_child;
	}
	public Float getTotal_food_charge_adult() {
		return total_food_charge_adult;
	}
	public void setTotal_food_charge_adult(Float total_food_charge_adult) {
		this.total_food_charge_adult = total_food_charge_adult;
	}
	public Float getTotal_entry_charge_child() {
		return total_entry_charge_child;
	}
	public void setTotal_entry_charge_child(Float total_entry_charge_child) {
		this.total_entry_charge_child = total_entry_charge_child;
	}
	public Float getTotal_entry_charge_adult() {
		return total_entry_charge_adult;
	}
	public void setTotal_entry_charge_adult(Float total_entry_charge_adult) {
		this.total_entry_charge_adult = total_entry_charge_adult;
	}
	public Float getDeposit() {
		return deposit;
	}
	public void setDeposit(Float deposit) {
		this.deposit = deposit;
	}
	public Float getTotal_charge() {
		return total_charge;
	}
	public void setTotal_charge(Float total_charge) {
		this.total_charge = total_charge;
	}
	public Float getGst() {
		return gst;
	}
	public void setGst(Float gst) {
		this.gst = gst;
	}
	public Float getSub_total() {
		return sub_total;
	}
	public void setSub_total(Float sub_total) {
		this.sub_total = sub_total;
	}
	public Float getPay_amount() {
		return pay_amount;
	}
	public void setPay_amount(Float pay_amount) {
		this.pay_amount = pay_amount;
	}
	public Float getReturn_amount() {
		return return_amount;
	}
	public void setReturn_amount(Float return_amount) {
		this.return_amount = return_amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Float getPlaycost() {
		return playcost;
	}
	public void setPlaycost(Float playcost) {
		this.playcost = playcost;
	}
	public Float getMiscellaneous() {
		return miscellaneous;
	}
	public void setMiscellaneous(Float miscellaneous) {
		this.miscellaneous = miscellaneous;
	}
	public Float getCatering() {
		return catering;
	}
	public void setCatering(Float catering) {
		this.catering = catering;
	}
	public Float getCafe() {
		return cafe;
	}
	public void setCafe(Float cafe) {
		this.cafe = cafe;
	}
	
}
