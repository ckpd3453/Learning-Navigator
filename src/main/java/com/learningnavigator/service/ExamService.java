//package com.learningnavigator.service;
//
//import com.learningnavigator.model.Exam;
//import com.learningnavigator.model.Subject;
//import com.learningnavigator.repository.ExamRepository;
//import com.learningnavigator.repository.SubjectRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ExamService {
//
//    @Autowired
//    private ExamRepository examRepository;
//
//    @Autowired
//    private SubjectRepository subjectRepository;
//
//    public Exam createExam(Exam exam) {
//        // Ensure subject exists before associating
//        Subject subject = subjectRepository.findById(exam.getSubject().getSubjectId())
//                .orElseThrow(() -> new RuntimeException("Subject not found"));
//        exam.setSubject(subject);
//
//        return examRepository.save(exam);
//    }
//}
