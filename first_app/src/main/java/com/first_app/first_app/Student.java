package com.first_app.first_app;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Student {

    private int stud_id;

    @NotBlank(message = "student name cannot be empty")
    private String stud_name;

    @NotNull(message = "student grade cannot be empty")
    @Min(value = 0, message = "Grade must be at least 0")
    @Max(value = 100, message = "Grade cannot be more than 100")
    private double stud_grade;


    public Student() {

    }


    public Student(String stud_name, double stud_grade) {
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


    @Override
    public String toString() {
        return "{" +
            " stud_id='" + getStud_id() + "'" +
            ", stud_name='" + getStud_name() + "'" +
            ", stud_grade='" + getStud_grade() + "'" +
            "}";
    }


}
