package com.first_app.first_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.first_app.first_app.Student;
import com.first_app.first_app.service.StudentService;

import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class StudentController {
    @Autowired
    StudentService stud_service;

    @PostConstruct
    public void init() {
        stud_service.addStudent(new Student("Yousef", 99));
        stud_service.addStudent(new Student("Ahmad", 96.2));
        stud_service.addStudent(new Student("Osama", 96.2));
    }


    // Pages --------------------------------------------------------------


    // test page
    @GetMapping("/getTestPage")
    public String getTestPage(){
        return "testPage"; // or testPage.html , dosent problem
    }
    //----------------------------------------------------------------------
    
    // View all student page
    @GetMapping("/getAllStudentDetailsPage")
    public String getAllStudentDetailsPage(Model model) {

        model.addAttribute("al_allStudent", stud_service.getAllStudent());

        return "allStudentDetailsPage";
    }
    //----------------------------------------------------------------------

    // add student page
    @GetMapping("/getAddStudentPage")
    public String getAddStudentPage(Model model) {

        model.addAttribute("addNewStudent", new Student());

        return "addStudentPage";
    }
    //----------------------------------------------------------------------
    // student details page
    @GetMapping("/getStudentDetailsPage")
    public String getStudentDetailsPage(@RequestParam("id") int studentId, Model model) {

        Student student=stud_service.getStudentById(studentId);
        System.out.println(student.toString());

        model.addAttribute("student", student);
        return "studentDetailsPage";
    }
    




    // operations on pages --------------------------------------------------------------

    // add
    @PostMapping("/addStudent")
    public String addStudent(@Valid @ModelAttribute("addNewStudent") Student stud, BindingResult result) {

        if(result.hasErrors()){
            return "addStudentPage";
        }

        stud_service.addStudent(stud);
        return "redirect:/getAllStudentDetailsPage";
    }


    // delete
    @GetMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("id") int studentId){

        stud_service.deleteStudent(studentId);
        return "redirect:/getAllStudentDetailsPage";
    }


    // update
    @PostMapping("/updateStudent")
    public String updateStudent(@Valid @ModelAttribute("student") Student stud, BindingResult result) {

        if(result.hasErrors()){
            return "studentDetailsPage";
        }

        stud_service.updateStudent(stud);
        return "redirect:/getAllStudentDetailsPage";
    }

    
    
}
