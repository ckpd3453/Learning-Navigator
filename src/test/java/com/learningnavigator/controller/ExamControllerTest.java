package com.learningnavigator.controller;

import com.learningnavigator.service.ExamService;
import com.learningnavigator.model.Exam;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ExamController.class)
public class ExamControllerTest {

    @Autowired private MockMvc mockMvc;

    @MockBean private ExamService examService;

    @Test
    void testGetExamById() throws Exception {
        Mockito.when(examService.getExamById(1)).thenReturn(java.util.Optional.of(new Exam()));

        mockMvc.perform(get("/exams/1"))
                .andExpect(status().isOk());
    }
}
