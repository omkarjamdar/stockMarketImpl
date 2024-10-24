package com.example.StockMarket.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "stockMain")
public class StockMain {
    @Id
    long id;



    @DBRef
 MetaData metaData;
    @DBRef
 WeeklyTimeSeries weeklyTimeSeries;

    public StockMain(WeeklyTimeSeries weeklyTimeSeries, MetaData metaData) {
        this.weeklyTimeSeries = weeklyTimeSeries;
        this.metaData = metaData;
    }

    public StockMain(MetaData metaData,WeeklyTimeSeries weeklyTimeSeries) {
        this.metaData = metaData;
        this.weeklyTimeSeries = weeklyTimeSeries;
    }

    public StockMain()
    {

    }
    public MetaData getMetaData() {
        return metaData;
    }

    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }


    public WeeklyTimeSeries getWeeklyTimeSeries() {
        return weeklyTimeSeries;
    }

    public void setWeeklyTimeSeries(WeeklyTimeSeries weeklyTimeSeries) {
        this.weeklyTimeSeries = weeklyTimeSeries;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
