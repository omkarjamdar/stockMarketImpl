package com.example.StockMarket.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "metaData")
@Data
public class MetaData {



   String stockName;
    String information;
    @Id
    String symbol;
    String lateRefreshed;
    String TimeZone;

    public MetaData(String lateRefreshed, String symbol, String information, String timeZone) {
        this.lateRefreshed = lateRefreshed;
        this.symbol = symbol;
        this.information = information;
        TimeZone = timeZone;
    }

    public MetaData()
    {

    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getTimeZone() {
        return TimeZone;
    }

    public void setTimeZone(String timeZone) {
        TimeZone = timeZone;
    }

    public String getLateRefreshed() {
        return lateRefreshed;
    }

    public void setLateRefreshed(String lateRefreshed) {
        this.lateRefreshed = lateRefreshed;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
