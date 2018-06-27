package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.ChildInfo;

public interface ChildRepository extends CrudRepository<ChildInfo, Integer>{
	
	@Query("select cf from ChildInfo cf where cf.firstname like %?1%")
	public List<ChildInfo> searchChildByName(String keyword);

}
