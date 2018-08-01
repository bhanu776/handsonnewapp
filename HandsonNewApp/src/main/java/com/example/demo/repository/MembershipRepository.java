package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Membership;

public interface MembershipRepository extends CrudRepository<Membership, Integer>{

	@Query("Select m from Membership m where child_id=?1")
	public List<Membership> isMember(Integer child_id);
}
