package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Membership;
import com.example.demo.repository.MembershipRepository;

@Service
public class MembershipDao {

	@Autowired
	MembershipRepository membershipRepository;
	
	public Membership addMember(Membership membership){
		return membershipRepository.save(membership);
	}
	
	public List<Membership> listMembers(){
		return (List<Membership>) membershipRepository.findAll();
	}
	
	public Membership getMembertDetail(int memberId){
		Optional<Membership> membership = membershipRepository.findById(memberId);
		
		if(membership.isPresent())
			return membership.get();
		else
			return null;
	}
	
	public boolean deleteMembership(int memberId){
		membershipRepository.deleteById(memberId);
		return true;
	}
	
	public boolean isExist(Integer child_id) {
		List<Membership> member = membershipRepository.isMember(child_id);
		if(member.size()>0){
			return true;
		}else{
			return false;
		}
	}
}
