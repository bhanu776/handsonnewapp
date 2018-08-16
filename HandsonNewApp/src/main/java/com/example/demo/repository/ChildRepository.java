package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.ChildInfo;

public interface ChildRepository extends CrudRepository<ChildInfo, Integer>{
	
	@Query(value = "select * from child_info cf where cf.firstname like %?1% limit 15", nativeQuery = true)
	public List<ChildInfo> searchChildByName(String keyword);
	
	@Query(value = "select * from child_info cf ORDER BY cf.id DESC LIMIT 12", nativeQuery = true)
	public List<ChildInfo> childList();
	
	@Query(value = "select count(id) from child_info",nativeQuery = true)
	public Long getCount();

}
