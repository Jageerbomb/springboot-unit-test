package cl.jagerbomb.unittest.services.impl;

import cl.jagerbomb.unittest.models.Exam;
import cl.jagerbomb.unittest.repositories.ExamRepository;
import cl.jagerbomb.unittest.services.ExamService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ExamServiceImplTest {
    ExamRepository repository;
    ExamService service;

    @BeforeEach
    void setUp() {
        repository = mock(ExamRepository.class);
        service = new ExamServiceImpl(repository);
    }

    @Test
    void findExamByName() {
        List<Exam> data = Arrays.asList(
                new Exam(1L, "matemática"),
                new Exam(2L, "lenguaje"),
                new Exam(3L, "Historia"),
                new Exam(4L, "inglés")
        );
        when(repository.findAll()).thenReturn(data);
        Optional<Exam> exam = service.findExamByName("matemática");
        assertTrue(exam.isPresent());
        assertEquals(1, exam.orElseThrow().getId());
        assertEquals("matemática", exam.orElseThrow().getName());
    }

    @Test
    void findExamByNameEmptyList() {
        List<Exam> data = Collections.emptyList();
        when(repository.findAll()).thenReturn(data);
        Optional<Exam> exam = service.findExamByName("matemática");
        assertFalse(exam.isPresent());
    }


}