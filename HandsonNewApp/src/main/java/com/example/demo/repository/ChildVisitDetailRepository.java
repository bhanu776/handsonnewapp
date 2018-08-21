package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.ChildVisitDetails;

public interface ChildVisitDetailRepository extends CrudRepository<ChildVisitDetails, Integer>{

	@Query("select cvd from ChildVisitDetails cvd where card_id=?1 and status = 0")
	public List<ChildVisitDetails> getVisitDetailthroughCardId(String cardId);
	
	@Query("select cvd from ChildVisitDetails cvd where status = 1 and admin_id = 1")
	public List<ChildVisitDetails> currentCheckedinChildren();
	
	
}
