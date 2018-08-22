package com.example.demo.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ChildInfo;
import com.example.demo.model.ChildVisitDetails;
import com.example.demo.model.ChildVisitTransaction;
import com.example.demo.repository.ChildRepository;
import com.example.demo.repository.ChildVisitDetailRepository;
import com.example.demo.repository.ChildVisitTransactionRepository;
import com.example.demo.utility.UtilityDao;
import com.example.demo.utility.UtilityDaoImpl;
import com.example.pojo.ListFilter;

@Service
public class ChildDao {

	@Autowired
	ChildRepository childRepository;
	
	@Autowired
	ChildVisitDetailRepository childVisitDetailRepository;
	
	@Autowired
	ChildVisitTransactionRepository chTransactionRepository;
	
	@Autowired
	UtilityDaoImpl utilityDao;
	
	public ChildInfo addChild(ChildInfo childInfo){
		return childRepository.save(childInfo);
	}
	
	
	public List<ChildInfo> childInfosList(ListFilter listFilter){
		return childRepository.childList(listFilter.getStart(), listFilter.getLimit());
	}
	
	public Optional<ChildInfo> getChildInfo(Integer id) {
		return childRepository.findById(id);
	}
	
	public void deleteChild(Integer id) {
		childRepository.deleteById(id);
	}
	
	public List<ChildInfo> searchChild(String keyword){
		return childRepository.searchChildByName(keyword);
	}
	
	public Long getChildListCount(){
		return childRepository.getCount();
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
	
	public List<ChildVisitDetails> getCheckedInChildren(){
		List<ChildVisitDetails> childVisitDetails = childVisitDetailRepository.currentCheckedinChildren();
		childVisitDetails.forEach(visitDetails ->{
			Map<String, Long> timeDiff = utilityDao.timeDifference(visitDetails.getStart_date(), new Date());
			visitDetails.setStart_time(timeDiff.get("diffHours")+":"+timeDiff.get("diffMinutes")+":"+timeDiff.get("diffSeconds"));
		});
		return childVisitDetails;
	}
	
	/*===================Check in Check out Transaction Details===========================*/
	
	public ChildVisitTransaction saveTransactionDetail(ChildVisitTransaction childVisitTransaction) {
		return chTransactionRepository.save(childVisitTransaction);
	}
	
	public List<ChildVisitTransaction> getAllTransactionDetails(){
		return (List<ChildVisitTransaction>) chTransactionRepository.findAll();
	}
	
	
}
