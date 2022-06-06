package cl.jagerbomb.unittest.services;

import cl.jagerbomb.unittest.models.Exam;

import java.util.Optional;

public interface ExamService {
    Optional<Exam> findExamByName(String name);
}
