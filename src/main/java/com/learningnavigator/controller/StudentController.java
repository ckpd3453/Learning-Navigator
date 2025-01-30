package com.learningnavigator.controller;

import com.learningnavigator.dto.ResponseDTO;
import com.learningnavigator.dto.StudentDTO;
import com.learningnavigator.model.Student;
import com.learningnavigator.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping(value = "students")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student savedStudent = studentService.createStudent(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

}
