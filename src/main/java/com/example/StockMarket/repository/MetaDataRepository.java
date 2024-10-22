package com.example.StockMarket.repository;

import com.example.StockMarket.dto.MetaData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MetaDataRepository extends MongoRepository<MetaData,Long> {
}
