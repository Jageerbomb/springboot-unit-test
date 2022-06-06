package cl.jagerbomb.unittest.services.impl;

import cl.jagerbomb.unittest.models.Exam;
import cl.jagerbomb.unittest.repositories.ExamRepository;
import cl.jagerbomb.unittest.services.ExamService;
import java.util.Optional;

public class ExamServiceImpl implements ExamService {

    private ExamRepository examRepository;

    public ExamServiceImpl(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    @Override
    public Optional<Exam> findExamByName(String name) {
        return examRepository.findAll()
                .stream()
                .filter(e -> e.getName().equals(name))
                .findFirst();
    }
}
