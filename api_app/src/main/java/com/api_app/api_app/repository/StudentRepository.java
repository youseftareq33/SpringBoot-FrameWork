package com.api_app.api_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api_app.api_app.model.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>{
    
}
