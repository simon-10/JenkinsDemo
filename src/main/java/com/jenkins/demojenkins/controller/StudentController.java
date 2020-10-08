package com.jenkins.demojenkins.controller;

import com.jenkins.demojenkins.domain.Student;
import com.jenkins.demojenkins.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/all")
    public List<Student> getStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id){
        List<Student> student=studentService.getAllStudents();
        for (Student st: student){
            if(st.getId()==id)
                return st;
        }
        return null;
    }




}
