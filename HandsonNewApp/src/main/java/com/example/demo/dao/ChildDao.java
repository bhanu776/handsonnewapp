package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ChildInfo;
import com.example.demo.model.ChildVisitDetails;
import com.example.demo.repository.ChildRepository;
import com.example.demo.repository.ChildVisitDetailRepository;

@Service
public class ChildDao {

	@Autowired
	ChildRepository childRepository;
	
	@Autowired
	ChildVisitDetailRepository childVisitDetailRepository;
	
	
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
	
	public ChildVisitDetails getChildVisitDetails(String cardId){
		List<ChildVisitDetails> childVisitDetails = childVisitDetailRepository.getVisitDetailthroughCardId(cardId);
		if(!childVisitDetails.isEmpty())
			return childVisitDetails.get(0);
		return null;
	}
}
