package com.example.demo.controller;

import com.example.demo.persistence.Student;
import com.example.demo.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class DemoController {

    private static final Logger log = LoggerFactory.getLogger(DemoController.class);
    private final StudentService studentService;

    @Autowired
    public DemoController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping(value = "/api/v1/students")
    public ResponseEntity<?> getAllStudents(){
        List<Student> studentList = studentService.getAllStudents();
        return new ResponseEntity<> (studentList, HttpStatus.OK);
    }

    @GetMapping(value = "/api/v1/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id){
        Student student = studentService.findStudentById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping(value = "/api/v1/students")
    public ResponseEntity<Student> saveExistingStudent(@RequestBody Student tempStudent) throws SQLException {
        Student modified = studentService.saveStudent(tempStudent);
        return new ResponseEntity<>(modified, HttpStatus.ACCEPTED);
    }

    @PutMapping(value = "/api/v1/students")
    public ResponseEntity<Student> saveNewStudent(@RequestBody Student newStudent) throws SQLException{
        Student added = studentService.saveStudent(newStudent);
        return new ResponseEntity<>(added, HttpStatus.CREATED);
    }
}
