package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ChildVisitDetails;
import com.example.demo.model.ChildVisitTransaction;
import com.example.demo.repository.ChildVisitDetailRepository;
import com.example.demo.repository.ChildVisitTransactionRepository;

@Service
public class ReportDao {

	@Autowired
	private ChildVisitTransactionRepository chTransactionRepository;
	
	@Autowired
	private ChildVisitDetailRepository chDetailRepository;
	
	public List<ChildVisitTransaction> getClildVisitTransactionReport(){
		return (List<ChildVisitTransaction>) chTransactionRepository.findAll();
	}
	
	public List<ChildVisitDetails> getChildVisitReport(){
		return (List<ChildVisitDetails>) chDetailRepository.findAll();
	}
}
