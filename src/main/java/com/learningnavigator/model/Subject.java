package com.learningnavigator.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer subjectId;
    private String SubjectName;

    @ManyToMany(mappedBy = "enrolledSubjects")
    private List<Student> registeredStudents;
}
