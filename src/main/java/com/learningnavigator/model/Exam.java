//package com.learningnavigator.model;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.util.List;
//
//@Entity
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//public class Exam {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer examId;
//    @ManyToOne
//    @JoinColumn(name = "subject_id", nullable = false)
//    private Subject subject;
//    @ManyToMany(mappedBy = "registeredExams")
//    private List<Student> enrolledStudents;
//
//    public Integer getExamId() {
//        return examId;
//    }
//
//    public void setExamId(Integer examId) {
//        this.examId = examId;
//    }
//
//    public Subject getSubject() {
//        return subject;
//    }
//
//    public void setSubject(Subject subject) {
//        this.subject = subject;
//    }
//
//    public List<Student> getEnrolledStudents() {
//        return enrolledStudents;
//    }
//
//    public void setEnrolledStudents(List<Student> enrolledStudents) {
//        this.enrolledStudents = enrolledStudents;
//    }
//}
