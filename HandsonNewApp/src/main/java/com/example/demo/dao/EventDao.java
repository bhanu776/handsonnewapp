package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Events;
import com.example.demo.repository.EventRepository;

@Service
public class EventDao {

	@Autowired
	EventRepository eventRepository;
	
	public Events addEvent(Events events){
		return eventRepository.save(events);
	}
	
	public List<Events> getEventList(){
		return (List<Events>) eventRepository.findAll();
	}
	
	public Events getEvent(int id){
		Optional<Events> optional = eventRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	public void deleteEvent(int id){
		eventRepository.deleteById(id);
	}
}
