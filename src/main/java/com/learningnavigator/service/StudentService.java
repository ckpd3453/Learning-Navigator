package com.learningnavigator.service;

import com.learningnavigator.model.Student;
import com.learningnavigator.model.Subject;
import com.learningnavigator.repository.StudentRepository;
import com.learningnavigator.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student enrollSubjects(Integer studentId, List<Integer> subjectIds) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        List<Subject> subjects = subjectRepository.findAllById(subjectIds);

        if (subjects.isEmpty()) {
            throw new RuntimeException("Subjects not found for given IDs");
        }

        student.setEnrolledSubjects(subjects);
        return studentRepository.save(student);
    }


}
