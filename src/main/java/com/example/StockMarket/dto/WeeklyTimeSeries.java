package com.example.StockMarket.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document(collection = "weeklyTimeSeries")
public class WeeklyTimeSeries {
//    @Id
//    Long id;
    @DBRef
    List<DateClass> dateClasses;

    public WeeklyTimeSeries(List<DateClass> dateClasses) {
        this.dateClasses = dateClasses;
    }
    public WeeklyTimeSeries()
    {

    }
    public List<DateClass> getDateClasses() {
        return dateClasses;
    }

    public void setDateClasses(List<DateClass> dateClasses) {
        this.dateClasses = dateClasses;
    }
}