package com.example.StockMarket.repository;

import com.example.StockMarket.dto.StockMain;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StockMainRepository extends MongoRepository<StockMain,String> {

}
