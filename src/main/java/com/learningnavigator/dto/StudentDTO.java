package com.learningnavigator.dto;

import com.learningnavigator.model.Subject;

import java.util.List;
import java.util.stream.Collectors;

public class StudentDTO {

    private String studentName;
    private List<Subject> enrolledSubjects;

    public void StudentDTO(String studentName, List<Subject> enrolledSubjects) {
        this.studentName = studentName;
        this.enrolledSubjects = enrolledSubjects;
    }

    public List<Subject> getEnrolledSubjects() {
        return enrolledSubjects;
    }

    public void setEnrolledSubjects(List<Subject> enrolledSubjects) {
        this.enrolledSubjects = enrolledSubjects;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
