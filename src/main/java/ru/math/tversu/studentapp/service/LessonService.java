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

    public Lesson getById(Integer id) {
        return lessonRepository.findById(id).orElse(new Lesson());
    }

    public Lesson save(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    public Lesson createEntity() {
        Integer lastId = lessonRepository.findFirstByOrderByIdDesc().getId();
        Lesson lesson = new Lesson();
        lesson.setId(++lastId);
        return lesson;
    }

    public Lesson getNotBoundToAnyScheduleById(Integer id) {
        return lessonRepository.findOneNotBoundToAnyScheduleById(id);
    }

    public void deleteById(Integer id) {
        lessonRepository.deleteById(id);
    }
}
