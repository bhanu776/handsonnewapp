package com.example.demo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.ChildDao;
import com.example.demo.dao.SettingsDao;
import com.example.demo.model.ChildInfo;
import com.example.demo.model.ChildVisitDetails;
import com.example.demo.model.ChildVisitTransaction;
import com.example.demo.model.Settings;
import com.example.demo.utility.UtilityDao;

@Controller
@RequestMapping("/admin/")
public class AdminController {
	
	@Autowired
	ChildDao childDao;
	
	@Autowired
	SettingsDao settingsDao;
	
	@Autowired
	UtilityDao utilityDao;

	@RequestMapping("/login")
	public String login(HttpSession session){
		session.setAttribute("admin_id", 1);
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
	
	@RequestMapping(value="/addchildaction",method=RequestMethod.POST)
	public String addChildAction(ChildInfo childInfo,HttpSession session){
		//childInfo.setAdmin_id(Integer.parseInt((String)session.getAttribute("admin")));
		childInfo.setAdmin_id(1);
		System.err.println(childInfo.toString());
		childDao.addChild(childInfo);
		return "child/viewChild";
	}
	
	@ResponseBody
	@RequestMapping(value="getchilddetails")
	public List<ChildInfo> getChildDetails(){
		return childDao.childInfosList();
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
	
	@ResponseBody
	@RequestMapping(value="search_child/{keyword}")
	public List<ChildInfo> searchCild(@PathVariable("keyword")String keyword){
		return childDao.searchChild(keyword);
	}
	
	/*=======================================Child Add Update Delete Operations=================================*/
	
	@RequestMapping(value="/addsiblingpage")
	public String addSiblingPage(ChildInfo childInfo) {
		return "";
	}
	
	
	@RequestMapping(value="/addsiblingaction",method=RequestMethod.POST)
	public String addSiblingAction(ChildInfo childInfo) {
		return "";
	}
	
	@RequestMapping(value="/updatesibling")
	public String updateSibblingg(@RequestParam("id")Integer id){
		return "";
	}
	
	@ResponseBody
	@RequestMapping(value="/deletesibling")
	public String deleteSibbling(@RequestParam("id")Integer id){
		return "";
	}
	
	/*=======================================Check in Check Out Api=============================================*/
	
	@RequestMapping(value="/scancardforchildcheckin",method=RequestMethod.GET)
	public String scanCardForChildCheckin(@RequestParam("childId") Integer childId,Model model){
		model.addAttribute("childId", childId);
		return "scancard/scanCardForCheckin";
	}
	
	@RequestMapping(value="/addadvanceamountpage",method=RequestMethod.POST)
	public String addAdvanceAmount(@RequestParam("childId")Integer childId,@RequestParam("cardId")String cardId,
			ChildVisitDetails childVisitDetails,Model model){
		
		if(childDao.getChildVisitDetails(cardId)!=null){
			return "redirect:scancardforchildcheckin?childId="+childId;
		}
		Optional<ChildInfo> childInfo = childDao.getChildInfo(childId);
		model.addAttribute("childDetail", childInfo.get());
		model.addAttribute("cardId", cardId);
		return "child/advanceAmountPage";
	}
	
	@RequestMapping(value="/childcheckinaction",method=RequestMethod.POST)
	public String childCheckInAction(ChildVisitDetails childVisitDetails){
		
		childVisitDetails.setAdmin_id(1);
		childVisitDetails.setStart_date(new Date());
		childDao.saveChildVisitDetail(childVisitDetails);
		return "redirect:dashboard";
	}
	
	@RequestMapping(value="/scancardforcheckout",method=RequestMethod.GET)
	public String scanCardForCheckout(Model model){
		return "scancard/scanCardForCheckout";
	}
	
	@RequestMapping(value="/playzonebillingdetails",method=RequestMethod.POST)
	public String billingDetails(@RequestParam("cardId")String cardId,
			Model model,ChildVisitTransaction childVisitTransaction){
		
		ChildVisitDetails childVisitDetails = childDao.getChildVisitDetails(cardId);
		if(childVisitDetails==null)
			return "redirect:/admin/dashboard";
		
		childVisitDetails.setEnd_date(new Date());
		ChildVisitDetails childVisitDetailnew = childDao.saveChildVisitDetail(childVisitDetails);
		
		model.addAttribute("childId", childVisitDetails.getChild_id());
		model.addAttribute("cardId", cardId);
		model.addAttribute("totalTime", utilityDao.timeDifference(childVisitDetailnew.getStart_date(), childVisitDetailnew.getEnd_date()));
		model.addAttribute("visitDetail", childVisitDetailnew);
		
		return "child/playzoneBillingDetails";
	}
	
	@RequestMapping(value="childcheckoutaction",method=RequestMethod.POST)
	public String childCheckoutAction(ChildVisitTransaction childVisitTransaction){
		System.out.println(childVisitTransaction.toString());
		ChildVisitDetails childVisitDetails = childDao.getChildVisitDetailsById(childVisitTransaction.getChild_visit_id());
		childVisitDetails.setStatus(1);
		float total = 0.0f;
		
		total = childVisitTransaction.getPlayzone_cost()+childVisitTransaction.getLibrary_cost();
			
		if(childVisitTransaction.getAdvanceAmount()!=null)
			total = total - childVisitTransaction.getAdvanceAmount();
		if(childVisitTransaction.getMiscellaneous_cost() != null)
			total = total+childVisitTransaction.getMiscellaneous_cost();
		if(childVisitTransaction.getExtra_amount() != null)
			total = total+childVisitTransaction.getExtra_amount();
		if(childVisitTransaction.getExtra_socks() != null)
			total = total+childVisitTransaction.getExtra_socks();
		
		if(total>=0) {
			childVisitTransaction.setTotal_amount(total);
			childVisitTransaction.setRefund_amount(0.0f);
		}else {
			childVisitTransaction.setTotal_amount(0.0f);
			childVisitTransaction.setRefund_amount(total*(-1));
		}
		childDao.saveTransactionDetail(childVisitTransaction);
		//generate bill code
		
		
		
		childDao.saveChildVisitDetail(childVisitDetails);
		return "redirect:/admin/dashboard";
	}
	
	/*====================================Settings====================================================*/
	
	@RequestMapping(value="/settingpage")
	public String settingPage(Settings settings,Model model){
		model.addAttribute("settings", settingsDao.getSettings(1));
		return "master/settings";
	}
	
	@RequestMapping(value="/addsetting",method=RequestMethod.POST)
	public String addSetting(Settings settings){
		System.out.println(settings.toString());
		settingsDao.saveSettings(settings);
		return "redirect:/admin/settingpage";
	}
	
	@ResponseBody
	@RequestMapping(value="/getsettings",method=RequestMethod.GET)
	public Map<String,Object> getSettings(){
		Map<String, Object> model = new HashMap<>();
		model.put("settings", settingsDao.getSettings(1));
		model.put("isWeekend", utilityDao.isWeekend());
		return model;
	}
	
	
	
	
}
