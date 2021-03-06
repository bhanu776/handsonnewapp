package com.example.demo.controller;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.dao.ChildDao;
import com.example.demo.dao.EventDao;
import com.example.demo.dao.MembershipDao;
import com.example.demo.dao.ReportDao;
import com.example.demo.dao.SettingsDao;
import com.example.demo.dao.UserDao;
import com.example.demo.model.ChildInfo;
import com.example.demo.model.ChildVisitDetails;
import com.example.demo.model.ChildVisitTransaction;
import com.example.demo.model.Events;
import com.example.demo.model.Membership;
import com.example.demo.model.SetHolidayCalendar;
import com.example.demo.model.Settings;
import com.example.demo.support.ChildSupportMethods;
import com.example.demo.utility.CreateBillXLS;
import com.example.demo.utility.UtilityDao;
import com.example.pojo.ListFilter;
import com.example.pojo.ReportFilter;
import com.example.pojo.ResposnseHolidaysBO;

@Controller
@RequestMapping("/admin/")
public class AdminController {
	
	@Autowired
	ChildDao childDao;
	
	@Autowired
	SettingsDao settingsDao;
	
	@Autowired
	UtilityDao utilityDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	MembershipDao membershipDao;
	
	@Autowired
	EventDao eventDao;
	
	@Autowired
	ChildSupportMethods childSupportMethods;
	
	@Autowired
	ReportDao reportDao;

	@RequestMapping("/login")
	public String login(HttpSession session){
		
		return "loginPage";
	}
	
	@RequestMapping("/loginaction")
	public String loginAction(HttpSession session,@RequestParam("uname")String userName,@RequestParam("password")String password){
		String role = userDao.getRole(userName, password);
		
		if(StringUtils.isEmpty(role))
			return "redirect:login";
		
		session.setAttribute("admin_id", 1);
		session.setAttribute("user", role);
		return "redirect:dashboard";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(HttpSession session){
		if(utilityDao.sessionExpired(session))
			return "redirect:/admin/login";
		
		return "dashboard";
	}
	
	/*=======================================Child Add Update Delete Operations================================*/
	
	@RequestMapping(value="/childview")
	public String viewChild(HttpSession session){
		
		if(utilityDao.sessionExpired(session))
			return "redirect:/admin/login";
		
		return "child/viewChild";
	}
	
	@RequestMapping(value="/addchildpage")
	public String addChildPage(ChildInfo childInfo,HttpSession session){
		
		if(utilityDao.sessionExpired(session))
			return "redirect:/admin/login";
		
		return "child/addChild";
	}
	
	@RequestMapping(value="/addchildaction", method=RequestMethod.POST)
	public String addChildAction(ChildInfo childInfo, HttpSession session){
		
		if(utilityDao.sessionExpired(session))
			return "redirect:/admin/login";
		
		childInfo.setAdmin_id(1);
		System.err.println(childInfo.toString());
		childDao.addChild(childInfo);
		return "redirect:childview";
	}
	
	@ResponseBody
	@RequestMapping(value="/child_list_count/get")
	public Long getChildLIstCount(){
		return childDao.getChildListCount();
	}
	
	@ResponseBody
	@RequestMapping(value="getchilddetails", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value=HttpStatus.OK)
	public List<ChildInfo> getChildDetails(@RequestBody ListFilter listFilter){
		return childDao.childInfosList(listFilter);
	}
	
	@ResponseBody
	@RequestMapping(value="getchildinfo/{id}")
	public ChildInfo getChildInfo(@PathVariable("id") Integer id){
		Optional<ChildInfo> childDetail = childDao.getChildInfo(id);
		if(childDetail.isPresent()){
			return childDetail.get();
		}
		return null;
	}
	
	
	@RequestMapping(value="deletechild")
	public String deleteChild(@RequestParam("childId") Integer id,HttpSession session){
		if(utilityDao.sessionExpired(session))return "redirect:/admin/login";
		
		childDao.deleteChild(id);
		return "redirect:childview";
	}
	
	
	@RequestMapping(value="updatechild")
	public String updateChild(@RequestParam("id") Integer id){
		
		return "child/viewChild";
	}
	
	@ResponseBody
	@RequestMapping(value="search_child/{keyword}")
	public List<ChildInfo> searchCild(@PathVariable("keyword")String keyword){
		if(StringUtils.isEmpty(keyword))
			return new ArrayList<>();
		return childDao.searchChild(keyword);
	}
	
	/*=======================================Child Add Update Delete Operations=================================*/
		
	@RequestMapping(value="/addsiblingaction",method=RequestMethod.POST)
	public String addSiblingAction(ChildInfo childInfo) throws GeneralSecurityException {
		Optional<ChildInfo> sibling = childDao.getChildInfo(childInfo.getSibling());
		
		if(!sibling.isPresent())
			throw new GeneralSecurityException("Incorrect child id");
			
		childSupportMethods.prepareSiblingPojo(childInfo,sibling.get());
		
		childDao.addChild(childInfo);
		
		sibling.get().setStatus(1);
		childDao.addChild(sibling.get());
			
		return "redirect:childview";
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
	public String scanCardForChildCheckin(@RequestParam("childId") Integer childId,Model model,HttpSession session){
		if(utilityDao.sessionExpired(session))return "redirect:/admin/login";
		
		model.addAttribute("childId", childId);
		return "scancard/scanCardForCheckin";
	}
	
	@RequestMapping(value="/addadvanceamountpage",method=RequestMethod.POST)
	public String addAdvanceAmount(@RequestParam("childId")Integer childId,@RequestParam("cardId")String cardId,
			ChildVisitDetails childVisitDetails,Model model, HttpSession session){
		if(utilityDao.sessionExpired(session))return "redirect:/admin/login";
		
		if(childDao.getChildVisitDetails(cardId)!=null){
			return "redirect:scancardforchildcheckin?childId="+childId;
		}
		
		Optional<ChildInfo> childInfo = childDao.getChildInfo(childId);
		boolean isExist = membershipDao.isExist(childInfo.get().getId());
						
		model.addAttribute("childDetail", childInfo.get());
		model.addAttribute("isMember", String.valueOf(isExist));
		model.addAttribute("cardId", cardId);
		return "child/advanceAmountPage";
	}
	
	@RequestMapping(value="/childcheckinaction",method=RequestMethod.POST)
	public String childCheckInAction(ChildVisitDetails childVisitDetails, HttpSession session){
		if(utilityDao.sessionExpired(session))return "redirect:/admin/login";
		
		Settings settings = settingsDao.getSettings(1);
		if(childVisitDetails.getSocks_pair_no()!=null && childVisitDetails.getSocks_pair_no()>0 && settings.getSocks()>0)
			childVisitDetails.setSocks_cost((float)childVisitDetails.getSocks_pair_no()*settings.getSocks());
		
		childVisitDetails.setAdmin_id(1);
		childVisitDetails.setStart_date(new Date());
		childDao.saveChildVisitDetail(childVisitDetails);
		return "redirect:dashboard";
	}
	
	@RequestMapping(value="/scancardforcheckout",method=RequestMethod.GET)
	public String scanCardForCheckout(Model model, HttpSession session){
		if(utilityDao.sessionExpired(session))return "redirect:/admin/login";
		
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
	public String childCheckoutAction(ChildVisitTransaction childVisitTransaction, HttpServletRequest request){
		//System.out.println(childVisitTransaction.toString());
		ChildVisitDetails childVisitDetails = childDao.getChildVisitDetailsById(childVisitTransaction.getChild_visit_id());
		Settings settings = settingsDao.getSettings(1);
		childVisitDetails.setStatus(1);
		childVisitTransaction.setChild_name(childVisitDetails.getChild_name());
		childVisitTransaction.setDate(utilityDao.javaDateToUiDate(new Date()));
		childVisitTransaction.setUpdate_date(new Date());
		
		float total = 0.0f;
		total = childVisitTransaction.getPlayzone_cost()+childVisitTransaction.getLibrary_cost();
		
		Map<String, Long> timedifferece = utilityDao.timeDifference(childVisitDetails.getStart_date(), new Date());
		long diffInMin = timedifferece.get("diffHours") * 60 +timedifferece.get("diffMinutes");
		childVisitTransaction.setTotal_time((int)diffInMin);
		
		if(membershipDao.isExist(childVisitDetails.getChild_id())){
			Membership membership = membershipDao.getMemberUsingChildId(childVisitDetails.getChild_id());
			membership.setRest_time(membership.getRest_time() - (int) diffInMin);
		}else{
			
			diffInMin = diffInMin - settings.getGrace_time();
			
			while(diffInMin>60) {
				
				if(utilityDao.isWeekend() || settingsDao.isHoliday())
					total = total + settings.getWeekend_secondhr_cost();
				else
					total = total + settings.getWeekday_secondhr_cost();
				
				diffInMin = diffInMin - 60;
			}
		
		}
		
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
		ChildVisitTransaction childVisitTransactionForBilling = childDao.saveTransactionDetail(childVisitTransaction);
		
		
		//generate bill code
		new CreateBillXLS().generateBill(request, childVisitTransactionForBilling, settings);
		
		
		childDao.saveChildVisitDetail(childVisitDetails);
		return "redirect:/admin/dashboard";
	}
	
	
	@ResponseBody
	@RequestMapping(value="is_holiday_from_cal", method=RequestMethod.GET)
	public boolean isHolidayForomCal(){
		return settingsDao.isHoliday();
	}
	
	/*====================================Child visit details===========================================*/
	
	@ResponseBody
	@RequestMapping(value="checkedin_children/get")
	public List<ChildVisitDetails> getCheckedInChildren(){
		return childDao.getCheckedInChildren();
	}
	
	/*====================================Membership====================================================*/
	
	@RequestMapping(value="membership_page",method=RequestMethod.GET)
	public String membershipPage(Membership membership,HttpSession session){
		if(utilityDao.sessionExpired(session))return "redirect:/admin/login";
		return "/child/membership";
	}
	
	@RequestMapping(value="save_membership",method=RequestMethod.POST)
	public String saveMembership(Membership membership, HttpSession session){
		if(utilityDao.sessionExpired(session))return "redirect:/admin/login";
		
		membership.setStart_date(utilityDao.uiDateStringInDate(membership.getStartDateStr()));
		membership.setEnd_date(utilityDao.uiDateStringInDate(membership.getEndDateStr()));
		
		membership.setUpdatedDate(new Date());
		
		if(membership.getId() == null){
			membership.setRest_time(membership.getHours() * 60);
			
		}else{
			Membership membershipTemp = membershipDao.getMembertDetail(membership.getId());
			membership.setRest_time(membershipTemp.getRest_time() + ( membership.getHours() * 60 ));
		}
		
		membershipDao.addMember(membership);
		
		return "redirect:membership_page";
	}
	
	@ResponseBody
	@RequestMapping(value="/membership_list/get")
	public List<Membership> getMembershipList(){
		
		return membershipDao.listMembers();
		
	}
	
	@ResponseBody
	@RequestMapping(value="/membership/get/{memberId}")
	public Membership getMembership(@PathVariable("memberId")int memberId){
		return membershipDao.getMembertDetail(memberId);
	}
	
	
	@RequestMapping(value="/delete_membership")
	public String deleteMembbership(@RequestParam("id")int memberId, HttpSession session){
		if(utilityDao.sessionExpired(session))return "redirect:/admin/login";
		 membershipDao.deleteMembership(memberId);
		return "redirect:membership_page";
	}
	
		
	/*======================================Event=======================================================*/
	
	@RequestMapping(value="/event/form")
	public String eventForm(Events events,HttpSession session) {
		if(utilityDao.sessionExpired(session))return "redirect:/admin/login";
		return "/event/viewEvent";
	}
	
	@RequestMapping(value="/event/add",method=RequestMethod.POST)
	public String addEvent(Events events){
		eventDao.addEvent(events);
		return "redirect:/admin/event/form";
	}
	
	@ResponseBody
	@RequestMapping(value="/event/list")
	public List<Events> getEveentLisi(){
		return eventDao.getEventList();
	}
	
	@RequestMapping(value="/event/delete")
	public String deleteEvent(@RequestParam("eventId")int eventId){
		eventDao.deleteEvent(eventId);
		return "redirect:/admin/event/form";
	}
	
	@ResponseBody
	@RequestMapping(value="/event/get/{eventId}")
	public Events getEvent(@PathVariable("eventId")int eventId){
		return eventDao.getEvent(eventId);
	}
	
	
	
	/*====================================Settings====================================================*/
	
	@RequestMapping(value="/settingpage")
	public String settingPage(Settings settings,Model model, HttpSession session){
		if(utilityDao.sessionExpired(session))return "redirect:/admin/login";
		model.addAttribute("settings", settingsDao.getSettings(1));
		return "master/settings";
	}
	
	@RequestMapping(value="/addsetting",method=RequestMethod.POST)
	public String addSetting(Settings settings, HttpSession session){
		if(utilityDao.sessionExpired(session))return "redirect:/admin/login";
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
	
	@SuppressWarnings("deprecation")
	@ResponseBody
	@RequestMapping(value="/set_calendar_holiday/{date}",method=RequestMethod.GET)
	public List<ResposnseHolidaysBO> saveHoliday(@PathVariable("date")Date date){
		int day = date.getDate();
		int month = date.getMonth();
		
		if(settingsDao.isDateExist(day, month) == 0)
			settingsDao.saveHoliday(new SetHolidayCalendar(day, month));
		else
			settingsDao.deleteHoliday(settingsDao.isDateExist(day, month));
		
		List<SetHolidayCalendar> holidayCalendarList = settingsDao.getHolidayList();
		List<ResposnseHolidaysBO> response = new ArrayList<>();
		holidayCalendarList.forEach(holiday -> {
			response.add(new ResposnseHolidaysBO(holiday.getDay(), holiday.getMonth(),utilityDao.currentYear(new Date())));
		});
		return response;
	}
	
	@ResponseBody
	@RequestMapping(value="/get_calendar_holiday",method=RequestMethod.GET)
	public List<ResposnseHolidaysBO> getHoliday(){
		List<SetHolidayCalendar> holidayCalendarList = settingsDao.getHolidayList();
		List<ResposnseHolidaysBO> response = new ArrayList<>();
		holidayCalendarList.forEach(holiday -> {
			response.add(new ResposnseHolidaysBO(holiday.getDay(), holiday.getMonth(),utilityDao.currentYear(new Date())));
		});
		return response;
	}
	
	
	/*====================================================== Repors API ===============================================================*/
	
	@RequestMapping(value="/report/child_visit_report", method=RequestMethod.GET)
	public String childVisitReportPage(){
		return "/reports/childVisitReport";
	}
	
	@ResponseBody
	@RequestMapping(value="/report/child_visit_report/get", method=RequestMethod.POST)
	public List<ChildVisitDetails> getChildVisitFilterdReport(@RequestBody ReportFilter reportFilter){
		return reportDao.getChildVisitReport(reportFilter);
	}
	
	@RequestMapping(value="/report/visit_transaction_report", method=RequestMethod.GET)
	public String visitTransactionReportPage(){
		return "/reports/childTranactionReport";
	}
	
	@ResponseBody
	@RequestMapping(value="/report/child_transaction_report/get", method=RequestMethod.POST)
	public List<ChildVisitTransaction> getChildVisitTransactionReport(@RequestBody ReportFilter reportFilter){
		return reportDao.getChildVisitTransactionReport(reportFilter);
	}
	
	
	/*http://ng-table.com/#/formatting/demo-cell-values*/
}
