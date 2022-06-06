package cl.jagerbomb.unittest.repositories;

import cl.jagerbomb.unittest.models.Exam;

import java.util.List;

public interface ExamRepository {
    List<Exam> findAll();
}
