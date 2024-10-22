package com.example.StockMarket.controller;

import com.example.StockMarket.dto.DateClass;
import com.example.StockMarket.dto.MetaData;
import com.example.StockMarket.dto.StockMain;
import com.example.StockMarket.dto.WeeklyTimeSeries;
import com.example.StockMarket.services.StockMarketDBService;
import com.example.StockMarket.services.StockMarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/stock")
public class StockMarketController {

@Autowired
    StockMarketService stockMarketService;
@Autowired
    StockMarketDBService stockMarketDBService;


    @GetMapping("/month/{stockName}")
    public ResponseEntity<?> getMonthsEntries(@PathVariable String stockName)
    {
        try {
            Map<String, Map<String, Map<String, String>>> map = new HashMap<>();
            map = stockMarketService.getMonthData(stockName);
            stockMarketDBService.getData(map);
            Map<String, Map<String, String>> map1 = new HashMap<>();
            map1 = map.get("Monthly Time Series");
            Map<String, String> map2 = new HashMap<>();
            if (!map.containsKey("Error Message")) {
                return ResponseEntity.ok(map.get("Monthly Time Series"));
            } else {
                return ResponseEntity.badRequest().body("Please provide correct details");
            }
        }
        catch (Exception e)
        {
            return ResponseEntity.internalServerError().body("Internal server error");
        }
    }


    @GetMapping("/weekly/{stockName}")
    public ResponseEntity<?> getWeeklyEntries(@PathVariable String stockName)
    {
        try {
            Map<String, Map<String, Map<String, String>>> map = new HashMap<>();
            map = stockMarketService.getWeeklyData(stockName);
            stockMarketDBService.getData(map);
            Map<String, Map<String, String>> map1 = new HashMap<>();
            map1 = map.get("Weekly Time Series");
            Map<String, String> map2 = new HashMap<>();
            if (!map.containsKey("Error Message") && !map.containsKey("Information")) {
                return ResponseEntity.ok(map.get("Weekly Time Series"));
            }
            else if(map.containsKey("Information"))
            {
                throw (Throwable) ResponseEntity.internalServerError();
            }
            else {
                return ResponseEntity.badRequest().body("Please provide correct details");
            }
        }
        catch (Exception e)
        {
            return ResponseEntity.internalServerError().body("Internal server error"+ e.toString());
        } catch (Throwable e) {
            System.out.println(e.toString());
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/daily/{stockName}")
    public ResponseEntity<?> getDailyEntries(@PathVariable String stockName)
    {
        try {
            Map<String, Map<String, Map<String, String>>> map = new HashMap<>();
            map = stockMarketService.getDailyData(stockName);
            Map<String, Map<String, String>> map1 = new HashMap<>();
            map1 = map.get("Time Series (Daily)");
            Map<String, String> map2 = new HashMap<>();
            if (!map.containsKey("Error Message")) {
                return ResponseEntity.ok(map.get("Time Series (Daily)"));
            } else {
                return ResponseEntity.badRequest().body("Please provide correct details");
            }
        }
        catch (Exception e)
        {
            return ResponseEntity.internalServerError().body("Internal server error");
        }
    }

}
