package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.ChildVisitTransaction;

public interface ChildVisitTransactionRepository extends CrudRepository<ChildVisitTransaction, Integer> {

	@Query("select cvt from ChildVisitTransaction cvt where update_date between ?1 and ?2")
	public List<ChildVisitTransaction> filterdChildTransactionDetails(Date fromDate, Date toDate);
}
