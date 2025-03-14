package com.api_app.api_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // this for id
    private int id;
    // which i sent to db the below and the db will fill above automatic
    
    private String name;
    private double grade;

    public Student(){

    }

    public Student(int id, String name, double grade){
        this.id=id;
        this.name=name;
        this.grade=grade;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id=id;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return this.grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

}
