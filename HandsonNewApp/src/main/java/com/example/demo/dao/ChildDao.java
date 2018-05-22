package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ChildInfo;
import com.example.demo.repository.ChildRepository;

@Service
public class ChildDao {

	@Autowired
	ChildRepository childRepository;
	
	
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
}
