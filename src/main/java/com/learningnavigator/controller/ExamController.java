package com.learningnavigator.controller;

import com.learningnavigator.model.Exam;
import com.learningnavigator.service.ExamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exams")
public class ExamController {

    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @PostMapping("/{subjectId}")
    public Exam createExam(@PathVariable Integer subjectId) {
        return examService.createExam(subjectId);
    }

    @GetMapping
    public List<Exam> getAllExams() {
        return examService.getAllExams();
    }

    @GetMapping("/{id}")
    public Exam getExamById(@PathVariable Integer id) {
        return examService.getExamById(id)
                .orElseThrow(() -> new RuntimeException("Exam not found"));
    }

    @DeleteMapping("/{id}")
    public void deleteExam(@PathVariable Integer id) {
        examService.deleteExam(id);
    }
}
