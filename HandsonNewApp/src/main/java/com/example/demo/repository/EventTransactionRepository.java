package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.EventTransaction;

public interface EventTransactionRepository extends CrudRepository<EventTransaction, Integer>{

	
	@Query("select et from EventTransaction et order by date desc")
	public List<EventTransaction> getEventTransactionList();
}
