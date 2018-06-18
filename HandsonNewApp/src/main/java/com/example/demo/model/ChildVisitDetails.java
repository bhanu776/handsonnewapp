package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ChildVisitDetails {

	@Id
	@GeneratedValue
	private Integer id;
	private Integer admin_id;
	private Integer child_id;
	private String child_name;
	private Date start_date;
	private String start_time;
	private Date end_date;
	private String end_time;
	private String card_id;
	private Float advance_amount=0.0f;
	private Float library_cost=0.0f;
	private Float playzone_cost=0.0f;
	private Integer payment_status = 0;
	private Integer payment_status_class = 0;
	private Integer discount=0;
	private Integer status=0;   //0 for checked_in and 1 for checked_out
	
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
	
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Float getAdvance_amount() {
		return advance_amount;
	}
	public void setAdvance_amount(Float advance_amount) {
		this.advance_amount = advance_amount;
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
	
	public Integer getPayment_status() {
		return payment_status;
	}
	public void setPayment_status(Integer payment_status) {
		this.payment_status = payment_status;
	}
	public Integer getPayment_status_class() {
		return payment_status_class;
	}
	public void setPayment_status_class(Integer payment_status_class) {
		this.payment_status_class = payment_status_class;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	@Override
	public String toString() {
		return "ChildVisitDetails [id=" + id + ", admin_id=" + admin_id + ", child_id=" + child_id + ", child_name="
				+ child_name + ", start_date=" + start_date + ", start_time=" + start_time + ", end_date=" + end_date
				+ ", end_time=" + end_time + ", card_id=" + card_id + ", advance_amount=" + advance_amount
				+ ", library_cost=" + library_cost + ", playzone_cost=" + playzone_cost + ", payment_status="
				+ payment_status + ", payment_status_class=" + payment_status_class + ", discount=" + discount
				+ ", status=" + status + "]";
	}
	
}
