package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.ChildVisitTransaction;

public interface ChildVisitTransactionRepository extends CrudRepository<ChildVisitTransaction, Integer> {

}
