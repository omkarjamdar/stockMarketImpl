package com.example.StockMarket;

import com.example.StockMarket.dto.DateClass;
import com.example.StockMarket.dto.MetaData;
import com.example.StockMarket.dto.StockMain;
import com.example.StockMarket.dto.WeeklyTimeSeries;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class StockMarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockMarketApplication.class, args);

	}

}
