package cl.jagerbomb.unittest.services;

import cl.jagerbomb.unittest.models.Exam;

public interface ExamService {
    Exam findExamByName(String name);
}
