package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.ChildDao;
import com.example.demo.model.ChildInfo;

@Controller
@RequestMapping("/admin/")
public class AdminController {
	
	@Autowired
	ChildDao childDao;

	@RequestMapping("/login")
	public String login(){
		return "loginPage";
	}
	
	@RequestMapping("/loginaction")
	public String loginAction(){
		return "";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(){
		return "dashboard";
	}
	
	/*=======================================Child Add Update Delete Operations================================*/
	
	@RequestMapping(value="/childview")
	public String viewChild(){
		return "child/viewChild";
	}
	
	@RequestMapping(value="/addchildpage")
	public String addChildPage(ChildInfo childInfo){
		
		return "child/addChild";
	}
	
	@RequestMapping(value="addchildaction",method=RequestMethod.POST)
	public String addChildAction(ChildInfo childInfo){
		childDao.addChild(childInfo);
		return "child/viewChild";
	}
	
	@ResponseBody
	@RequestMapping(value="getchilddetails")
	public List<ChildInfo> getChildDetails(@RequestParam("id")Integer id){
		return Arrays.asList(new ChildInfo());
	}
	
	@ResponseBody
	@RequestMapping(value="getchildinfo")
	public ChildInfo getChildInfo(@RequestParam("id")Integer id){
		Optional<ChildInfo> childDetail = childDao.getChildInfo(id);
		if(childDetail.isPresent()){
			return childDetail.get();
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value="deletechild")
	public String deleteChild(@RequestParam("id")Integer id){
		
		return "Sccessfull deleted";
	}
	
	
	@RequestMapping(value="updatechild")
	public String updateChild(@RequestParam("id")Integer id){
		
		return "child/viewChild";
	}
	
	/*=======================================Child Add Update Delete Operations=================================*/
	
	@RequestMapping(value="addsiblingpage")
	public String addSiblingPage(ChildInfo childInfo) {
		return "";
	}
	
	
	@RequestMapping(value="addsiblingaction",method=RequestMethod.POST)
	public String addSiblingAction(ChildInfo childInfo) {
		return "";
	}
	
	@RequestMapping(value="updatesibling")
	public String updateSibblingg(@RequestParam("id")Integer id){
		return "";
	}
	
	@ResponseBody
	@RequestMapping(value="deletesibling")
	public String deleteSibbling(@RequestParam("id")Integer id){
		return "";
	}
	
	/*=======================================Check in Check Out Api=============================================*/
	
	
	
	
	
}
