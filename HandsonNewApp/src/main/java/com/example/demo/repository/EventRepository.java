package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Events;

public interface EventRepository extends CrudRepository<Events, Integer>{

}
