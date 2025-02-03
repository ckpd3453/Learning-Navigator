package com.learningnavigator.controller;

import com.learningnavigator.model.Student;
import com.learningnavigator.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student registerStudent(@RequestBody Student student) {
        return studentService.registerStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Integer id) {
        return studentService.getStudentById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @PutMapping("/{studentId}/enroll/{subjectId}")
    public Student enrollSubject(@PathVariable Integer studentId, @PathVariable Integer subjectId) {
        return studentService.enrollSubject(studentId, subjectId);
    }

    @PutMapping("/{studentId}/register/{examId}")
    public Student registerForExam(@PathVariable Integer studentId, @PathVariable Integer examId) {
        return studentService.registerForExam(studentId, examId);
    }
}
