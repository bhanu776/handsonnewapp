package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ChildInfo;
import com.example.demo.model.ChildVisitDetails;
import com.example.demo.model.ChildVisitTransaction;
import com.example.demo.repository.ChildRepository;
import com.example.demo.repository.ChildVisitDetailRepository;
import com.example.demo.repository.ChildVisitTransactionRepository;

@Service
public class ChildDao {

	@Autowired
	ChildRepository childRepository;
	
	@Autowired
	ChildVisitDetailRepository childVisitDetailRepository;
	
	@Autowired
	ChildVisitTransactionRepository chTransactionRepository;
	
	
	public ChildInfo addChild(ChildInfo childInfo){
		return childRepository.save(childInfo);
	}
	
	public List<ChildInfo> childInfosList(){
		return (List<ChildInfo>) childRepository.findAll();
	}
	
	public Optional<ChildInfo> getChildInfo(Integer id) {
		return childRepository.findById(id);
	}
	
	public void deleteChild(Integer id) {
		childRepository.deleteById(id);
	}
	
	
	
	/*==================child visit details=============================== */
	
	public ChildVisitDetails saveChildVisitDetail(ChildVisitDetails childVisitDetails){
		return childVisitDetailRepository.save(childVisitDetails);
	}
	
	public ChildVisitDetails getChildVisitDetailsById(int childVisitId){
		Optional<ChildVisitDetails> chOptional = childVisitDetailRepository.findById(childVisitId);
		return chOptional.get();
	}
	
	public ChildVisitDetails getChildVisitDetails(String cardId){
		List<ChildVisitDetails> childVisitDetails = childVisitDetailRepository.getVisitDetailthroughCardId(cardId);
		if(!childVisitDetails.isEmpty())
			return childVisitDetails.get(0);
		return null;
	}
	
	/*===================Check in Check out Transaction Details===========================*/
	
	public ChildVisitTransaction saveTransactionDetail(ChildVisitTransaction childVisitTransaction) {
		return chTransactionRepository.save(childVisitTransaction);
	}
	
	public List<ChildVisitTransaction> getAllTransactionDetails(){
		return (List<ChildVisitTransaction>) chTransactionRepository.findAll();
	}
	
	
}
