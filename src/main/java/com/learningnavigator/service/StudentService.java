package com.learningnavigator.service;

import com.learningnavigator.model.Student;
import com.learningnavigator.repository.StudentRepository;
import com.learningnavigator.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

}
