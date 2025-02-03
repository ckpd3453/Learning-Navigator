package com.learningnavigator.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

    public Student(String studentName) {
        this.studentName = studentName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer studentRegistrationId;

    private String studentName;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "student_subject",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    @JsonIgnore
    private List<Subject> enrolledSubjects = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "student_exam",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "exam_id")
    )
    @JsonIgnore
    private List<Exam> registeredExamsList = new ArrayList<>();

    public Student() {
    }

    public Integer getStudentRegistrationId() {
        return studentRegistrationId;
    }

    public void setStudentRegistrationId(Integer studentRegistrationId) {
        this.studentRegistrationId = studentRegistrationId;
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

    public List<Exam> getRegisteredExamsList() {
        return registeredExamsList;
    }

    public void setRegisteredExamsList(List<Exam> registeredExamsList) {
        this.registeredExamsList = registeredExamsList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentRegistrationId +
                ", studentName='" + studentName + '\'' +
                '}';
    }
}
