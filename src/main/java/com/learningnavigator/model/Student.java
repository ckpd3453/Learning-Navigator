package com.learningnavigator.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer studentId;
    private String studentName;

    // ManyToMany relationship with subject
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "student_subject",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<Subject> enrolledSubjects;


    public Student(Integer studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.enrolledSubjects = new ArrayList<>();
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

    public List<Subject> getEnrolledSubjects() {
        return enrolledSubjects;
    }

    public void setEnrolledSubjects(List<Subject> enrolledSubjects) {
        this.enrolledSubjects = enrolledSubjects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", enrolledSubjects=" + enrolledSubjects +
                '}';
    }
}
