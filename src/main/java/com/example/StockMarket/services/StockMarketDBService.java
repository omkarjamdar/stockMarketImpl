package com.example.StockMarket.services;

import com.example.StockMarket.dto.DateClass;
import com.example.StockMarket.dto.MetaData;
import com.example.StockMarket.dto.StockMain;
import com.example.StockMarket.dto.WeeklyTimeSeries;
import com.example.StockMarket.repository.DataRepository;
import com.example.StockMarket.repository.MetaDataRepository;
import com.example.StockMarket.repository.StockMainRepository;
import com.example.StockMarket.repository.WeeklyTimeSeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class StockMarketDBService {
    @Autowired
    DataRepository dataRepository;

    @Autowired
    MetaDataRepository metaDataRepository;

    @Autowired
    StockMainRepository stockMainRepository;

    @Autowired
    WeeklyTimeSeriesRepository weeklyTimeSeriesRepository;

    MetaData metaData = new MetaData();
    StockMain stockMain = new StockMain();
    WeeklyTimeSeries weeklyTimeSeries = new WeeklyTimeSeries();
    DateClass dateClass = new DateClass();
    List<DateClass> dateClassList = new ArrayList<>();

    Map<String, Map<String, Map<String, String>>> mainMap = new HashMap<>();

    Map<String, Map<String, String>> metaDataMap = new HashMap<>();
    Map<String, Map<String, String>> weeklyTimeSeriesMap = new HashMap<>();
    Map<String, Map<String, String>> map1 = new HashMap<>();

    public void getData(Map<String, Map<String, Map<String, String>>> map) {
        mainMap = map;
        metaDataMap = mainMap.get("Meta Data");
        weeklyTimeSeriesMap = mainMap.get("Weekly Time Series");
        System.out.println(metaDataMap.get("1. Information"));

        metaData.setInformation(String.valueOf(metaDataMap.get("1. Information")));
        metaData.setSymbol(String.valueOf(metaDataMap.get("2. Symbol")));
        metaData.setLateRefreshed(String.valueOf(metaDataMap.get("3. Last Refreshed")));
        metaData.setTimeZone(String.valueOf(metaDataMap.get("4. Time Zone")));


        for (int i = 0; i < weeklyTimeSeriesMap.size(); i++) {
            for (String key : weeklyTimeSeriesMap.keySet()) {
                DateClass dateClass1 = (DateClass) dateClass.clone();
                Map<String,String> dateClassMap = new HashMap<>();
                dateClassMap = weeklyTimeSeriesMap.get(key);
                dateClass1.setOpen(dateClassMap.get("1. open"));
                dateClass1.setHigh(dateClassMap.get("2. high"));
                dateClass1.setLow(dateClassMap.get("3. low"));
                dateClass1.setClose(dateClassMap.get("4. close"));
                dateClass1.setVolume(dateClassMap.get("5. volume"));
                dateClassList.add(dateClass1);
            }
        }
        weeklyTimeSeries.setDateClasses(dateClassList);
       // System.out.println(dateClassList);
        stockMain.setMetaData(metaData);
        stockMain.setWeeklyTimeSeries(weeklyTimeSeries);
        addData(stockMain);
    }

    public void addData(StockMain stockMain)
    {
        dataRepository.saveAll(stockMain.getWeeklyTimeSeries().getDateClasses());
        weeklyTimeSeriesRepository.save(stockMain.getWeeklyTimeSeries());
        metaDataRepository.save(stockMain.getMetaData());
        stockMainRepository.save(stockMain);
    }


}


