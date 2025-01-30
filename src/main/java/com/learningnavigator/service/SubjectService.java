package com.learningnavigator.service;

import com.learningnavigator.model.Subject;
import com.learningnavigator.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }
}
