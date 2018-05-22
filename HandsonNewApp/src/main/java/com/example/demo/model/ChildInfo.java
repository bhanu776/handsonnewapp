package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class ChildInfo {
	@Id
	@GeneratedValue
	Integer id;
	Integer class_id;
	Integer admin_id;
	@NotEmpty
	String firstname;
	String middlename;
	@NotEmpty
	String lastname;
	String email;
	@NotEmpty
	String phone;
	@NotEmpty
	String dob;
	String allergies = "none";
	String image_name;
	String aadhar;
	String aadhar_no;
	String school;
	String address;
	String blood_group;
	String remarks;
	String mother_name;
	String mother_phone;
	String mother_email;
	String mother_phone2;
	String mother_dob;
	String mother_profession;
	String mother_aadhar;
	String mother_aadhar_no;
	String mother_image_name;
	String father_name;
	String father_phone;
	String father_phone2;
	String father_email;
	String father_dob;
	String father_profession;
	String father_aadhar;
	String father_aadhar_no;
	String father_image_name;
	String gurdian_name;
	String gurdian_phone;
	String gurdian_phone2;
	String gurdian_email;
	String gurdian_dob;
	String gurdian_profession;
	String gurdian_aadhar;
	String gurdian_aadhar_no;
	String gurdian_image_name;
	Integer sibling=0;
	Integer status=0;
	
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
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getMiddlename() {
		return middlename;
	}
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
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
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAllergies() {
		return allergies;
	}
	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}
	public String getImage_name() {
		return image_name;
	}
	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMother_name() {
		return mother_name;
	}
	public void setMother_name(String mother_name) {
		this.mother_name = mother_name;
	}
	public String getMother_phone() {
		return mother_phone;
	}
	public void setMother_phone(String mother_phone) {
		this.mother_phone = mother_phone;
	}
	public String getMother_email() {
		return mother_email;
	}
	public void setMother_email(String mother_email) {
		this.mother_email = mother_email;
	}
	public String getMother_image_name() {
		return mother_image_name;
	}
	public void setMother_image_name(String mother_image_name) {
		this.mother_image_name = mother_image_name;
	}
	public String getFather_name() {
		return father_name;
	}
	public void setFather_name(String father_name) {
		this.father_name = father_name;
	}
	public String getFather_phone() {
		return father_phone;
	}
	public void setFather_phone(String father_phone) {
		this.father_phone = father_phone;
	}
	public String getFather_email() {
		return father_email;
	}
	public void setFather_email(String father_email) {
		this.father_email = father_email;
	}
	public String getFather_image_name() {
		return father_image_name;
	}
	public void setFather_image_name(String father_image_name) {
		this.father_image_name = father_image_name;
	}
	public Integer getSibling() {
		return sibling;
	}
	public void setSibling(Integer sibling) {
		this.sibling = sibling;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getClass_id() {
		return class_id;
	}
	public void setClass_id(Integer class_id) {
		this.class_id = class_id;
	}
	public String getMother_phone2() {
		return mother_phone2;
	}
	public void setMother_phone2(String mother_phone2) {
		this.mother_phone2 = mother_phone2;
	}
	public String getFather_phone2() {
		return father_phone2;
	}
	public void setFather_phone2(String father_phone2) {
		this.father_phone2 = father_phone2;
	}
	public String getGurdian_name() {
		return gurdian_name;
	}
	public void setGurdian_name(String gurdian_name) {
		this.gurdian_name = gurdian_name;
	}
	public String getGurdian_phone() {
		return gurdian_phone;
	}
	public void setGurdian_phone(String gurdian_phone) {
		this.gurdian_phone = gurdian_phone;
	}
	public String getGurdian_phone2() {
		return gurdian_phone2;
	}
	public void setGurdian_phone2(String gurdian_phone2) {
		this.gurdian_phone2 = gurdian_phone2;
	}
	public String getGurdian_email() {
		return gurdian_email;
	}
	public void setGurdian_email(String gurdian_email) {
		this.gurdian_email = gurdian_email;
	}
	public String getGurdian_image_name() {
		return gurdian_image_name;
	}
	public void setGurdian_image_name(String gurdian_image_name) {
		this.gurdian_image_name = gurdian_image_name;
	}
	public String getMother_aadhar() {
		return mother_aadhar;
	}
	public void setMother_aadhar(String mother_aadhar) {
		this.mother_aadhar = mother_aadhar;
	}
	public String getFather_aadhar() {
		return father_aadhar;
	}
	public void setFather_aadhar(String father_aadhar) {
		this.father_aadhar = father_aadhar;
	}
	public String getGurdian_aadhar() {
		return gurdian_aadhar;
	}
	public void setGurdian_aadhar(String gurdian_aadhar) {
		this.gurdian_aadhar = gurdian_aadhar;
	}
	public String getBlood_group() {
		return blood_group;
	}
	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getMother_dob() {
		return mother_dob;
	}
	public void setMother_dob(String mother_dob) {
		this.mother_dob = mother_dob;
	}
	public String getMother_profession() {
		return mother_profession;
	}
	public void setMother_profession(String mother_profession) {
		this.mother_profession = mother_profession;
	}
	public String getFather_dob() {
		return father_dob;
	}
	public void setFather_dob(String father_dob) {
		this.father_dob = father_dob;
	}
	public String getFather_profession() {
		return father_profession;
	}
	public void setFather_profession(String father_profession) {
		this.father_profession = father_profession;
	}
	public String getGurdian_dob() {
		return gurdian_dob;
	}
	public void setGurdian_dob(String gurdian_dob) {
		this.gurdian_dob = gurdian_dob;
	}
	public String getGurdian_profession() {
		return gurdian_profession;
	}
	public void setGurdian_profession(String gurdian_profession) {
		this.gurdian_profession = gurdian_profession;
	}	
	public String getAadhar_no() {
		return aadhar_no;
	}
	public void setAadhar_no(String aadhar_no) {
		this.aadhar_no = aadhar_no;
	}
	public String getMother_aadhar_no() {
		return mother_aadhar_no;
	}
	public void setMother_aadhar_no(String mother_aadhar_no) {
		this.mother_aadhar_no = mother_aadhar_no;
	}
	public String getFather_aadhar_no() {
		return father_aadhar_no;
	}
	public void setFather_aadhar_no(String father_aadhar_no) {
		this.father_aadhar_no = father_aadhar_no;
	}
	public String getGurdian_aadhar_no() {
		return gurdian_aadhar_no;
	}
	public void setGurdian_aadhar_no(String gurdian_aadhar_no) {
		this.gurdian_aadhar_no = gurdian_aadhar_no;
	}
	public ChildInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "ChildInfo [id=" + id + ", class_id=" + class_id + ", admin_id=" + admin_id + ", firstname=" + firstname
				+ ", middlename=" + middlename + ", lastname=" + lastname + ", email=" + email + ", phone=" + phone
				+ ", dob=" + dob + ", allergies=" + allergies + ", image_name=" + image_name + ", aadhar=" + aadhar
				+ ", aadhar_no=" + aadhar_no + ", school=" + school + ", address=" + address + ", blood_group="
				+ blood_group + ", remarks=" + remarks + ", mother_name=" + mother_name + ", mother_phone="
				+ mother_phone + ", mother_email=" + mother_email + ", mother_phone2=" + mother_phone2 + ", mother_dob="
				+ mother_dob + ", mother_profession=" + mother_profession + ", mother_aadhar=" + mother_aadhar
				+ ", mother_aadhar_no=" + mother_aadhar_no + ", mother_image_name=" + mother_image_name
				+ ", father_name=" + father_name + ", father_phone=" + father_phone + ", father_phone2=" + father_phone2
				+ ", father_email=" + father_email + ", father_dob=" + father_dob + ", father_profession="
				+ father_profession + ", father_aadhar=" + father_aadhar + ", father_aadhar_no=" + father_aadhar_no
				+ ", father_image_name=" + father_image_name + ", gurdian_name=" + gurdian_name + ", gurdian_phone="
				+ gurdian_phone + ", gurdian_phone2=" + gurdian_phone2 + ", gurdian_email=" + gurdian_email
				+ ", gurdian_dob=" + gurdian_dob + ", gurdian_profession=" + gurdian_profession + ", gurdian_aadhar="
				+ gurdian_aadhar + ", gurdian_aadhar_no=" + gurdian_aadhar_no + ", gurdian_image_name="
				+ gurdian_image_name + ", sibling=" + sibling + ", status=" + status + "]";
	}
	
	
	
}
