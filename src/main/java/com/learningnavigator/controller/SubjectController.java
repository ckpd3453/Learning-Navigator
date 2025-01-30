package com.learningnavigator.controller;

import com.learningnavigator.dto.ResponseDTO;
import com.learningnavigator.model.Subject;
import com.learningnavigator.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping(value = "subjects", produces = "application/json")
    public ResponseEntity<Subject> createSubject(@RequestBody Subject subject) {
        Subject savedSubject = subjectService.createSubject(subject);
        return new ResponseEntity<>(savedSubject, HttpStatus.CREATED);
    }

}

