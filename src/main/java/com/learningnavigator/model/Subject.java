package com.learningnavigator.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer subjectId;

//    @Column(name = "subject_name")
    @JsonProperty("subjectName")
    private String subjectName;

    // Many-to-Many relationship with Student (Bidirectional)
    @ManyToMany(mappedBy = "enrolledSubjects")
    private List<Student> enrolledStudents;

    public Subject(Integer subjectId, String subjectName) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.enrolledStudents = new ArrayList<>();
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(List<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", subjectName='" + subjectName + '\'' +
                ", enrolledStudents=" + enrolledStudents +
                '}';
    }
}
