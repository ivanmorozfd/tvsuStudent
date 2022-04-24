package ru.math.tversu.studentapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.math.tversu.studentapp.model.object.Lesson;
import ru.math.tversu.studentapp.repository.object.LessonRepository;

import java.util.List;

@Service
public class LessonService {
    @Autowired
    private LessonRepository lessonRepository;

    public List<Lesson> getAll() {
        return lessonRepository.findAll();
    }
}
