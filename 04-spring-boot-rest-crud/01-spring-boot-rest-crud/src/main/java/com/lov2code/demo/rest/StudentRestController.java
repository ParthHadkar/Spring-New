package com.lov2code.demo.rest;

import com.lov2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> students;

    // define @PostContructor to load the student data only once
    @PostConstruct
    public void loadData(){
        students = new ArrayList<Student>();
        students.add(new Student("parth", "hadkar"));
        students.add(new Student("nikhil", "etame"));
        students.add(new Student("nitin", "ghadi"));
        students.add(new Student("deepak", "phejale"));
        students.add(new Student("rishi", "echale"));
    }

    // define endpoint for "/students" - return the list of students
    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }
    // define endpoint for "/students/{id}" - return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable("studentId") int studentId){

        // check student again the list
        if(studentId >= students.size() || studentId < 0){
            throw new StudentNotFoundException("Student not found with id "+studentId);
        }
        return students.get(studentId);
    }

}
