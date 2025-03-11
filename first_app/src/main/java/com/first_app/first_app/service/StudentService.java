package com.first_app.first_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.first_app.first_app.Student;
import com.first_app.first_app.repository.StudentRepository;

@Service
public class StudentService {
    @Autowired
    StudentRepository stud_repo;

    // get
    public List<Student> getAllStudent(){
        return stud_repo.getAllStudent();
    }

    public Student getStudentById(int student_id){
        return stud_repo.getStudentById(student_id);
    }

    //----------------------------------------------------

    // add
    public void addStudent(Student student){
        stud_repo.addStudent(student);
    }

    //----------------------------------------------------

    // delete
    public void deleteStudent(int stud_id){
        stud_repo.deleteStudent(stud_id);
    }

    //----------------------------------------------------

    // update
    public void updateStudent(Student student){
        stud_repo.updateStudent(student);
    }

    
}
