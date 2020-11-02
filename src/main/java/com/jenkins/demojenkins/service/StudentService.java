package com.jenkins.demojenkins.service;

import com.jenkins.demojenkins.domain.Student;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    public List<Student> getStudents(){
        return Arrays.asList(
                new Student(1,"Simon","Asmara"),
                new Student(2,"Filimon","Masawa"),
                new Student(3,"John","Keren"),
                new Student(4,"Peter","Dekemhare"),
                new Student(5,"Alex","Assab")
        );
    }
}
