package com.example.StockMarket.repository;

import com.example.StockMarket.dto.DateClass;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DataRepository extends MongoRepository<DateClass,Long> {
}
