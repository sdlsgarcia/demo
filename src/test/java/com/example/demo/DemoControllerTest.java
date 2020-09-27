package com.example.demo;

import com.example.demo.controller.DemoController;
import com.example.demo.persistence.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DemoControllerTest {

    @InjectMocks
    private DemoController demoController;

    @Mock
    private StudentService studentService;

    @BeforeEach
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Ignore
    public void testGetStudents(){
        ResponseEntity re = demoController.getAllStudents();
        List<Student> studentList = (List<Student>) re.getBody();
        assertEquals(11, studentList.size());
    }

}
