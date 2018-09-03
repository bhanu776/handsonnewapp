package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.ChildVisitDetails;

public interface ChildVisitDetailRepository extends CrudRepository<ChildVisitDetails, Integer>{

	@Query("select cvd from ChildVisitDetails cvd where card_id=?1 and status = 0")
	public List<ChildVisitDetails> getVisitDetailthroughCardId(String cardId);

	@Query("select cvd from ChildVisitDetails cvd where status = 0 and admin_id = 1")
	public List<ChildVisitDetails> currentCheckedinChildren();

	@Query("select cvd from ChildVisitDetails cvd where start_date between ?1 and ?2")
	public List<ChildVisitDetails> filterdChildVisitDetails(Date fromDate, Date toDate);


}
