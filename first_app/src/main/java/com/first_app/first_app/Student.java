package com.first_app.first_app;

public class Student {
    private int stud_id;
    private String stud_name;
    private double stud_grade;


    public Student() {
    }


    public Student(int stud_id, String stud_name, double stud_grade) {
        this.stud_id = stud_id;
        this.stud_name = stud_name;
        this.stud_grade = stud_grade;
    }



    public int getStud_id() {
        return this.stud_id;
    }

    public void setStud_id(int stud_id) {
        this.stud_id = stud_id;
    }

    public String getStud_name() {
        return this.stud_name;
    }

    public void setStud_name(String stud_name) {
        this.stud_name = stud_name;
    }

    public double getStud_grade() {
        return this.stud_grade;
    }

    public void setStud_grade(double stud_grade) {
        this.stud_grade = stud_grade;
    }


}
