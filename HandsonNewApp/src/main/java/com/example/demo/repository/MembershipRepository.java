package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Membership;

public interface MembershipRepository extends CrudRepository<Membership, Integer>{

}
