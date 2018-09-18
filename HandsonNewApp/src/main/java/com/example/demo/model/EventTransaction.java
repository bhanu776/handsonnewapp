package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class EventTransaction {
	
	@Id
	@GeneratedValue
	int id;
	int event_id=0;
	float total_food_charge_child=0.0f;
	float total_food_charge_adult=0.0f;
	float total_entry_charge_child=0.0f;
	float total_entry_charge_adult=0.0f;
	float playcost=0.0f;
	float miscellaneous=0.0f;
	float catering=0.0f;
	float cafe=0.0f;
	float deposit=0.0f;
	float total_charge=0.0f;
	float gst=0.0f;
	float sub_total=0.0f;
	float pay_amount=0.0f;
	float return_amount=0.0f;
	String date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEvent_id() {
		return event_id;
	}
	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}
	public float getTotal_food_charge_child() {
		return total_food_charge_child;
	}
	public void setTotal_food_charge_child(float total_food_charge_child) {
		this.total_food_charge_child = total_food_charge_child;
	}
	public float getTotal_food_charge_adult() {
		return total_food_charge_adult;
	}
	public void setTotal_food_charge_adult(float total_food_charge_adult) {
		this.total_food_charge_adult = total_food_charge_adult;
	}
	public float getTotal_entry_charge_child() {
		return total_entry_charge_child;
	}
	public void setTotal_entry_charge_child(float total_entry_charge_child) {
		this.total_entry_charge_child = total_entry_charge_child;
	}
	public float getTotal_entry_charge_adult() {
		return total_entry_charge_adult;
	}
	public void setTotal_entry_charge_adult(float total_entry_charge_adult) {
		this.total_entry_charge_adult = total_entry_charge_adult;
	}
	public float getPlaycost() {
		return playcost;
	}
	public void setPlaycost(float playcost) {
		this.playcost = playcost;
	}
	public float getMiscellaneous() {
		return miscellaneous;
	}
	public void setMiscellaneous(float miscellaneous) {
		this.miscellaneous = miscellaneous;
	}
	public float getCatering() {
		return catering;
	}
	public void setCatering(float catering) {
		this.catering = catering;
	}
	public float getCafe() {
		return cafe;
	}
	public void setCafe(float cafe) {
		this.cafe = cafe;
	}
	public float getDeposit() {
		return deposit;
	}
	public void setDeposit(float deposit) {
		this.deposit = deposit;
	}
	public float getTotal_charge() {
		return total_charge;
	}
	public void setTotal_charge(float total_charge) {
		this.total_charge = total_charge;
	}
	public float getGst() {
		return gst;
	}
	public void setGst(float gst) {
		this.gst = gst;
	}
	public float getSub_total() {
		return sub_total;
	}
	public void setSub_total(float sub_total) {
		this.sub_total = sub_total;
	}
	public float getPay_amount() {
		return pay_amount;
	}
	public void setPay_amount(float pay_amount) {
		this.pay_amount = pay_amount;
	}
	public float getReturn_amount() {
		return return_amount;
	}
	public void setReturn_amount(float return_amount) {
		this.return_amount = return_amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
