package com.first_app.first_app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.first_app.first_app.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class StudentController {

    // test page
    @GetMapping("/getTestPage")
    public String getTestPage(){
        return "testPage"; // or testPage.html , dosent problem
    }
    
    //----------------------------------------------------------------------
    List<Student> al_allStudent=new ArrayList<>();

    // add student page
    @GetMapping("/getAddStudentPage")
    public String getAddStudentPage(Model model) {
        Student newStud=new Student();
        model.addAttribute("addNewStudent", newStud);
        return "addStudentPage";
    }

    @PostMapping("/addStudent")
    public String addStudent(Student stud) {
        al_allStudent.add(stud);
        return "redirect:/getAllStudentDetailsPage";
    }

    //----------------------------------------------------------------------

    // all student page
    @GetMapping("/getAllStudentDetailsPage")
    public String getAllStudentDetailsPage(Model model) {
        model.addAttribute("al_allStudent", al_allStudent);
        return "allStudentDetailsPage";
    }

    //----------------------------------------------------------------------

    // student details page
    @GetMapping("/getStudentDetailsPage")
    public String getStudentDetailsPage(@RequestParam("id") String studentId, Model model) {

        Student student=null;
        for(int i=0;i<al_allStudent.size();i++){
            if(al_allStudent.get(i).getStud_id()==Integer.parseInt(studentId)){
                student=al_allStudent.get(i);
                break;
            }
        }
       
        // Add the student to the model
        model.addAttribute("student", student);
        return "studentDetailsPage";
    }

    @PostMapping("/updateStudent")
    public String updateStudent(Student stud) {

        for(int i=0;i<al_allStudent.size();i++){
            if(al_allStudent.get(i).getStud_id()==stud.getStud_id()){
                al_allStudent.set(i, stud);
                break;
            }
        }
        return "redirect:/getAllStudentDetailsPage";
    }

    
    
    
}
