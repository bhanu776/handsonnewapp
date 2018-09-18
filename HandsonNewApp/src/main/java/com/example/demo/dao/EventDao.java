package com.example.demo.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.EventTransaction;
import com.example.demo.model.Events;
import com.example.demo.repository.EventRepository;
import com.example.demo.repository.EventTransactionRepository;
import com.example.demo.utility.UtilityDao;

@Service
public class EventDao {

	@Autowired
	EventRepository eventRepository;
	
	@Autowired
	private EventTransactionRepository eventTransactionRepository;
	
	@Autowired
	private UtilityDao utilityDao;
	
	public Events addEvent(Events events){
		return eventRepository.save(events);
	}
	
	public List<Events> getEventList(){
		return (List<Events>) eventRepository.listOfUpcommingEvents(0);
	}
	
	public Events getEvent(int id){
		Optional<Events> optional = eventRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	public List<Events> getTodaysEvent(){
		Date date = new Date();
		return eventRepository.todaysEvents(utilityDao.javaDateToUiDate(date));
	}
	
	public void deleteEvent(int id){
		eventRepository.deleteById(id);
	}
	
	/*==========================================Event Transaction========================================*/
	
	public void saveEventTransaction(EventTransaction eventTransaction){
		eventTransactionRepository.save(eventTransaction);
	}
	
	public List<EventTransaction> getListOfTransaction(){
		return eventTransactionRepository.getEventTransactionList();
	}
	
	public void deleteEventTransaction(int eventId){
		
	}
	
	public EventTransaction getEventTransaction(int eventId){
		Optional<EventTransaction> eventTransaction = eventTransactionRepository.findById(eventId);
		
		if(eventTransaction.isPresent())
			return eventTransaction.get();
		else
			return null;
	}
	
}
