package com.learningnavigator.controller;

import com.learningnavigator.service.SubjectService;
import com.learningnavigator.model.Subject;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(SubjectController.class)
public class SubjectControllerTest {

    @Autowired private MockMvc mockMvc;

    @MockBean private SubjectService subjectService;

    @Test
    void testGetSubjectById() throws Exception {
        Mockito.when(subjectService.getSubjectById(1)).thenReturn(java.util.Optional.of(new Subject()));

        mockMvc.perform(get("/subjects/1"))
                .andExpect(status().isOk());
    }
}
