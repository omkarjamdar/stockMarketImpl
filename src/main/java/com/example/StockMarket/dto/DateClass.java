package com.example.StockMarket.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "dataClass")
public class DateClass implements Cloneable {
    @Id
    private long id;
    String open;
    String high;
    String low;
    String close;
    String volume;

    public DateClass(String volume, String close, String low, String high, String open) {
        this.volume = volume;
        this.close = close;
        this.low = low;
        this.high = high;
        this.open = open;

    }

    public DateClass()
    {

    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.id= UUID.randomUUID().getMostSignificantBits();
        this.open = open;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    @Override
    public DateClass clone() {
        try {
            DateClass clone = (DateClass) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
