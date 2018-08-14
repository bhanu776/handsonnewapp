package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Events {

	@Id
	@GeneratedValue
	Integer id;
	Integer admin_id;
	String date;
	String time;
	String event_type;
	String theme;
	String child_name;
	String parent_name;
	String email;
	String phone;
	String phone2;
	String address;
	String location;
	String organiser;
	String organiser_contact;
	Float deposit=0.0f;
	Float ground_rent=0.0f;
	Integer no_of_children=0;
	Integer no_of_adults=0;
	Float food_par_head=0.0f;
	Float entry_charge_child=0.0f;
	Float entry_charge_adults=0.0f;
	String remarks;
	Integer payment_status = 0;
	
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getEvent_type() {
		return event_type;
	}
	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getChild_name() {
		return child_name;
	}
	public void setChild_name(String child_name) {
		this.child_name = child_name;
	}
	public String getParent_name() {
		return parent_name;
	}
	public void setParent_name(String parent_name) {
		this.parent_name = parent_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getOrganiser() {
		return organiser;
	}
	public void setOrganiser(String organiser) {
		this.organiser = organiser;
	}
	public String getOrganiser_contact() {
		return organiser_contact;
	}
	public void setOrganiser_contact(String organiser_contact) {
		this.organiser_contact = organiser_contact;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Float getDeposit() {
		return deposit;
	}
	public void setDeposit(Float deposit) {
		this.deposit = deposit;
	}
	public Float getGround_rent() {
		return ground_rent;
	}
	public void setGround_rent(Float ground_rent) {
		this.ground_rent = ground_rent;
	}
	public Integer getNo_of_children() {
		return no_of_children;
	}
	public void setNo_of_children(Integer no_of_children) {
		this.no_of_children = no_of_children;
	}
	public Integer getNo_of_adults() {
		return no_of_adults;
	}
	public void setNo_of_adults(Integer no_of_adults) {
		this.no_of_adults = no_of_adults;
	}
	public Float getFood_par_head() {
		return food_par_head;
	}
	public void setFood_par_head(Float food_par_head) {
		this.food_par_head = food_par_head;
	}
	public Integer getPayment_status() {
		return payment_status;
	}
	public void setPayment_status(Integer payment_status) {
		this.payment_status = payment_status;
	}
	public Float getEntry_charge_child() {
		return entry_charge_child;
	}
	public void setEntry_charge_child(Float entry_charge_child) {
		this.entry_charge_child = entry_charge_child;
	}
	public Float getEntry_charge_adults() {
		return entry_charge_adults;
	}
	public void setEntry_charge_adults(Float entry_charge_adults) {
		this.entry_charge_adults = entry_charge_adults;
	}
	
	@Override
	public String toString() {
		return "Events [id=" + id + ", admin_id=" + admin_id + ", date=" + date + ", time=" + time + ", event_type="
				+ event_type + ", theme=" + theme + ", child_name=" + child_name + ", parent_name=" + parent_name
				+ ", email=" + email + ", phone=" + phone + ", phone2=" + phone2 + ", address=" + address
				+ ", location=" + location + ", organiser=" + organiser + ", organiser_contact=" + organiser_contact
				+ ", deposit=" + deposit + ", ground_rent=" + ground_rent + ", no_of_children=" + no_of_children
				+ ", no_of_adults=" + no_of_adults + ", food_par_head=" + food_par_head + ", entry_charge_child="
				+ entry_charge_child + ", entry_charge_adults=" + entry_charge_adults + ", remarks=" + remarks
				+ ", payment_status=" + payment_status + "]";
	}
	
}
