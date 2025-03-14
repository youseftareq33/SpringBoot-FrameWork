package com.api_app.api_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.api_app.api_app.model.Student;
import com.api_app.api_app.repository.StudentRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
public class StudentController {
    @Autowired
    StudentRepository stud_repo;


    // Get request -------------------------------------------------------
    // get all students
    @GetMapping("/getStudents")
    public List<Student> getStudents(){
        return stud_repo.findAll();
    }

    // get specific student
    @GetMapping("/getStudent/{id}")
    public Student getStudentById(@PathVariable("id") int id) {
        return stud_repo.findById(id).get();
    }
    

    // Post request -------------------------------------------------------
    // create student
    @PostMapping("/createStudent")
    public Student createStudent(@RequestBody Student stud) {
        return stud_repo.save(stud);
    }


    // Put request -------------------------------------------------------
    // update student
    @PutMapping("/updateStudent/{id}")
    public Student updateStudent(@PathVariable("id") int id, @RequestBody Student stud) {
        stud.setId(id);
        return stud_repo.save(stud);
    }


    // Delete request -------------------------------------------------------
    // delete student
    @DeleteMapping("/deleteStudent/{id}")
    public void deleteStudent(@PathVariable("id") int id) {
        stud_repo.deleteById(id);
    }
    
}
