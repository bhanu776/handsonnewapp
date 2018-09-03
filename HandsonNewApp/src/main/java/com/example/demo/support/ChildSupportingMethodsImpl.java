package com.example.demo.support;

import org.springframework.stereotype.Component;

import com.example.demo.model.ChildInfo;

@Component
public class ChildSupportingMethodsImpl implements ChildSupportMethods{

	@Override
	public void prepareSiblingPojo(ChildInfo siblingInfo, ChildInfo childInfo) {
				
		siblingInfo.setMother_name(childInfo.getMother_name());
		siblingInfo.setMother_phone(childInfo.getMother_phone());
		siblingInfo.setMother_email(childInfo.getMother_email());
		siblingInfo.setMother_phone2(childInfo.getMother_phone2());
		siblingInfo.setMother_dob(childInfo.getMother_dob());
		siblingInfo.setMother_aadhar(childInfo.getMother_aadhar());
		siblingInfo.setMother_profession(childInfo.getMother_profession());
		siblingInfo.setMother_aadhar_no(childInfo.getMother_aadhar_no());
		siblingInfo.setMother_image_name(childInfo.getMother_image_name());

		siblingInfo.setFather_name(childInfo.getFather_name());
		siblingInfo.setFather_email(childInfo.getFather_email());
		siblingInfo.setFather_aadhar(childInfo.getFather_aadhar());
		siblingInfo.setFather_aadhar_no(childInfo.getFather_aadhar());
		siblingInfo.setFather_dob(childInfo.getFather_dob());
		siblingInfo.setFather_image_name(childInfo.getFather_image_name());
		siblingInfo.setFather_phone(childInfo.getFather_phone());
		siblingInfo.setFather_phone2(childInfo.getFather_phone2());
		siblingInfo.setFather_profession(childInfo.getFather_profession());
		
		siblingInfo.setGurdian_aadhar(childInfo.getGurdian_aadhar());
		siblingInfo.setFather_aadhar_no(childInfo.getGurdian_aadhar_no());
		siblingInfo.setFather_dob(childInfo.getGurdian_dob());
		siblingInfo.setGurdian_email(childInfo.getGurdian_email());
		siblingInfo.setGurdian_image_name(childInfo.getGurdian_image_name());
		siblingInfo.setGurdian_name(childInfo.getGurdian_name());
		siblingInfo.setGurdian_phone(childInfo.getGurdian_phone());
		siblingInfo.setFather_phone2(childInfo.getGurdian_phone2());
		siblingInfo.setGurdian_profession(childInfo.getGurdian_profession());
		
	}

	
}
