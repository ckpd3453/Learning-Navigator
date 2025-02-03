package com.learningnavigator.service;

import com.learningnavigator.model.Exam;
import com.learningnavigator.model.Student;
import com.learningnavigator.model.Subject;
import com.learningnavigator.repository.ExamRepository;
import com.learningnavigator.repository.StudentRepository;
import com.learningnavigator.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final ExamRepository examRepository;
    private final SubjectRepository subjectRepository;

    public StudentService(StudentRepository studentRepository, ExamRepository examRepository, SubjectRepository subjectRepository) {
        this.studentRepository = studentRepository;
        this.examRepository = examRepository;
        this.subjectRepository = subjectRepository;
    }

    public Student registerStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Integer id) {
        return studentRepository.findById(id);
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }

    public Student enrollSubject(Integer studentId, Integer subjectId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new RuntimeException("Subject not found"));

        student.getEnrolledSubjects().add(subject);
        return studentRepository.save(student);
    }

    public Student registerForExam(Integer studentId, Integer examId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Exam exam = examRepository.findById(examId)
                .orElseThrow(() -> new RuntimeException("Exam not found"));

        if (!student.getEnrolledSubjects().contains(exam.getSubject())) {
            throw new RuntimeException("Student must enroll in subject before registering for exam");
        }

        student.getRegisteredExamsList().add(exam);
        return studentRepository.save(student);
    }
}
