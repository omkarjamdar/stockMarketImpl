package com.example.StockMarket.repository;

import com.example.StockMarket.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository  extends MongoRepository<Student,String> {
}
