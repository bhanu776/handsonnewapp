package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.ChildInfo;

public interface ChildRepository extends CrudRepository<ChildInfo, Integer>{

}
