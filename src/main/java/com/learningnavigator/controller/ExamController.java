//package com.learningnavigator.controller;
//
//import com.learningnavigator.dto.ResponseDTO;
//import com.learningnavigator.model.Exam;
//import com.learningnavigator.service.ExamService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("api/v1/")
//public class ExamController {
//
//    @Autowired
//    private ExamService examService;
//
//    @PostMapping(value = "exams", produces = "application/json")
//    public ResponseEntity<ResponseDTO> createExam(Exam exam){
//        Exam examEntry = examService.createExam(exam);
//        ResponseDTO responseDTO = new ResponseDTO("Added Exam Successfully", examEntry);
//        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
//    }
//}
