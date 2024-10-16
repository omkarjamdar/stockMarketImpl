package com.example.StockMarket.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "subjects")
public class Subject {
    @Id
    private String id;

    private String name;
    private double marks;
    //@OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)


    public Subject( String id, double marks, String name) {

        this.marks = marks;
        this.name = name;
        this.id=id;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getmarks() {
        return marks;
    }

    public void setmarks(double marks) {
        this.marks = marks;
    }


}
