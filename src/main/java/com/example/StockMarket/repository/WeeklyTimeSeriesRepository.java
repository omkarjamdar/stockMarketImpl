package com.example.StockMarket.repository;

import com.example.StockMarket.dto.WeeklyTimeSeries;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WeeklyTimeSeriesRepository extends MongoRepository<WeeklyTimeSeries,String> {
}
