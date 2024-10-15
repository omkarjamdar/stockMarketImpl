package com.example.StockMarket.repository;

import com.example.StockMarket.entity.Subject;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SubjectRepository extends MongoRepository<Subject,String> {
}
