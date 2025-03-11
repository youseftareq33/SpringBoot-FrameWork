package com.first_app.first_app.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.first_app.first_app.Student;

@Repository
public class StudentRepository {

    private List<Student> al_allStudent=new ArrayList<>();

    // get
    public List<Student> getAllStudent(){
        return al_allStudent;
    }

    public Student getStudentById(int student_id){
        Student stud=null;
        for(int i=0;i<al_allStudent.size();i++){
            if(al_allStudent.get(i).getStud_id()==student_id){
                stud=al_allStudent.get(i);
                break;
            }
        }

        return stud;
    }

    //----------------------------------------------------

    // add
    public void addStudent(Student student){
        student.setStud_id(al_allStudent.size()+1);
        al_allStudent.add(student);
    }

    //----------------------------------------------------

    // delete
    public void deleteStudent(int stud_id){
        al_allStudent.remove(getStudentById(stud_id));
    }

    //----------------------------------------------------

    // update
    public void updateStudent(Student student){
        for(int i=0;i<al_allStudent.size();i++){
            if(al_allStudent.get(i).getStud_id()==student.getStud_id()){
                al_allStudent.set(i, student);
                break;
            }
        }
    }

}
