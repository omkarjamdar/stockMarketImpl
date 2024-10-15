package com.example.StockMarket.entity;

import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "subjects")
public class Subject {

    private long id;
    private String name;
    private double markes;
    //@OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Student student;

    public Subject(long id, Student student, double markes, String name) {
        this.id = id;
        this.student = student;
        this.markes = markes;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMarkes() {
        return markes;
    }

    public void setMarkes(double markes) {
        this.markes = markes;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
