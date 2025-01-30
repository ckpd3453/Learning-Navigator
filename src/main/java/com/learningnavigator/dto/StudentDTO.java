package com.learningnavigator.dto;

import com.learningnavigator.model.Subject;

import java.util.List;
import java.util.stream.Collectors;

public class StudentDTO {

    private Integer studentId;
    private String studentName;
    private List<String> enrolledSubjects;

    public StudentDTO(Integer studentId, String studentName, List<Subject> enrolledSubjects) {

    }

    // Constructor to convert Student entity to StudentDTO
    public void StudentDTO(Integer studentId, String studentName, List<Subject> enrolledSubjects) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.enrolledSubjects = enrolledSubjects.stream()
                .map(Subject::getSubjectName)
                .collect(Collectors.toList()); // Get only subject names in the DTO
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<String> getEnrolledSubjects() {
        return enrolledSubjects;
    }

    public void setEnrolledSubjects(List<String> enrolledSubjects) {
        this.enrolledSubjects = enrolledSubjects;
    }
}
