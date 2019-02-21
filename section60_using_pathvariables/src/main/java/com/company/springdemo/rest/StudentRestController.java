package com.company.springdemo.rest;

import com.company.springdemo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    // define @PostConstruct to load the student data... only once
    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Mark", "Holden"));
        theStudents.add(new Student("Ted", "Baker"));
        theStudents.add(new Student("Julie", "Patel"));
    }


    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }


    // define endpoint for "students/{studentId}" - return student by index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        return theStudents.get(studentId);
    }
}
