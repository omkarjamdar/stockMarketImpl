package com.example.StockMarket.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class StockMarketService {
    @Autowired
    RestTemplate restTemplate;

    @Value("${stock.url}")
    String defaultURL;

    public Map getMonthData(String stockName)
    {
        String URL =defaultURL.replace("stockName",stockName);
        return restTemplate.getForObject(URL.replace("timeRange","TIME_SERIES_MONTHLY"), Map.class);
    }

    public Map getWeeklyData(String stockName)
    {

        String URL =defaultURL.replace("stockName",stockName);
        return restTemplate.getForObject(URL.replace("timeRange","TIME_SERIES_WEEKLY"), Map.class);
    }
    public Map getDailyData(String stockName)
    {

        String URL =defaultURL.replace("stockName",stockName);
        return restTemplate.getForObject(URL.replace("timeRange","TIME_SERIES_DAILY"), Map.class);
    }
}
