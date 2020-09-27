package com.example.demo.service;

import com.example.demo.persistence.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepo;

    @Autowired
    public StudentService(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<Student> getAllStudents(){
        return studentRepo.findAll();
    }

    public Student findStudentById(Long studentId){
        Optional<Student> student = studentRepo.findById(studentId);
        return student.orElseGet(Student::new);
    }

    @Transactional(rollbackOn = {SQLException.class})
    public Student saveStudent(Student tempStudent) throws SQLException {
        return studentRepo.save(tempStudent);
    }
}
