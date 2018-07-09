package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ChildVisitTransaction {

	@Id
	@GeneratedValue
	private Integer id;
	private Integer child_visit_id;
	private Integer child_id;
	private String child_name;
	private Integer total_time;
	@Column(nullable=false,columnDefinition="float default 0.0f")
	private Float playzone_cost = 0.0f;
	@Column(nullable=false,columnDefinition="float default 0.0f")
	private Float library_cost = 0.0f;
	@Column(nullable=false,columnDefinition="float default 0.0f")
	private Float advanceAmount = 0.0f;
	@Column(nullable=false,columnDefinition="float default 0.0f")
	private Float paid_amount = 0.0f;
	@Column(nullable=false,columnDefinition="float default 0.0f")
	private Float total_amount = 0.0f;
	@Column(nullable=false,columnDefinition="float default 0.0f")
	private Float extra_amount = 0.0f;
	@Column(nullable=false,columnDefinition="float default 0.0f")
	private Float extra_socks = 0.0f;
	@Column(nullable=false,columnDefinition="float default 0.0f")
	private Float refund_amount = 0.0f;
	@Column(nullable=false,columnDefinition="float default 0.0f")
	private Float miscellaneous_cost = 0.0f;
	private String comment;
	private String date;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getChild_visit_id() {
		return child_visit_id;
	}
	public void setChild_visit_id(Integer child_visit_id) {
		this.child_visit_id = child_visit_id;
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
	public Float getPlayzone_cost() {
		return playzone_cost;
	}
	public void setPlayzone_cost(Float playzone_cost) {
		this.playzone_cost = playzone_cost;
	}
	public Float getLibrary_cost() {
		return library_cost;
	}
	public void setLibrary_cost(Float library_cost) {
		this.library_cost = library_cost;
	}
	public Float getPaid_amount() {
		return paid_amount;
	}
	public void setPaid_amount(Float paid_amount) {
		this.paid_amount = paid_amount;
	}
	public Float getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(Float total_amount) {
		this.total_amount = total_amount;
	}
	public Float getExtra_amount() {
		return extra_amount;
	}
	public void setExtra_amount(Float extra_amount) {
		this.extra_amount = extra_amount;
	}
	public Float getRefund_amount() {
		return refund_amount;
	}
	public void setRefund_amount(Float refund_amount) {
		this.refund_amount = refund_amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getTotal_time() {
		return total_time;
	}
	public void setTotal_time(Integer total_time) {
		this.total_time = total_time;
	}
	public Float getMiscellaneous_cost() {
		return miscellaneous_cost;
	}
	public void setMiscellaneous_cost(Float miscellaneous_cost) {
		this.miscellaneous_cost = miscellaneous_cost;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	} 
	public Float getAdvanceAmount() {
		return advanceAmount;
	}
	public void setAdvanceAmount(Float advanceAmount) {
		this.advanceAmount = advanceAmount;
	}
	public Float getExtra_socks() {
		return extra_socks;
	}
	public void setExtra_socks(Float extra_socks) {
		this.extra_socks = extra_socks;
	}
	@Override
	public String toString() {
		return "ChildVisitTransaction [id=" + id + ", child_visit_id=" + child_visit_id + ", child_id=" + child_id
				+ ", child_name=" + child_name + ", total_time=" + total_time + ", playzone_cost=" + playzone_cost
				+ ", library_cost=" + library_cost + ", advanceAmount=" + advanceAmount + ", paid_amount=" + paid_amount
				+ ", total_amount=" + total_amount + ", extra_amount=" + extra_amount + ", extra_socks=" + extra_socks
				+ ", refund_amount=" + refund_amount + ", miscellaneous_cost=" + miscellaneous_cost + ", comment="
				+ comment + ", date=" + date + "]";
	}
	
}
