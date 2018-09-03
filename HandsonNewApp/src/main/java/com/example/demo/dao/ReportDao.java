package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ChildVisitDetails;
import com.example.demo.model.ChildVisitTransaction;
import com.example.demo.repository.ChildVisitDetailRepository;
import com.example.demo.repository.ChildVisitTransactionRepository;
import com.example.pojo.ReportFilter;

@Service
public class ReportDao {

	@Autowired
	private ChildVisitTransactionRepository chTransactionRepository;
	
	@Autowired
	private ChildVisitDetailRepository chDetailRepository;
	
	public List<ChildVisitTransaction> getClildVisitTransactionReport(){
		return (List<ChildVisitTransaction>) chTransactionRepository.findAll();
	}
	
	public List<ChildVisitDetails> getChildVisitReport(ReportFilter reportFilter){
		
		return chDetailRepository.filterdChildVisitDetails(reportFilter.getFromDate(), reportFilter.getToDate());
	}
	
	public List<ChildVisitTransaction> getChildVisitTransactionReport(ReportFilter reportFilter){
		
		return chTransactionRepository.filterdChildTransactionDetails(reportFilter.getFromDate(), reportFilter.getToDate());
	}
}
