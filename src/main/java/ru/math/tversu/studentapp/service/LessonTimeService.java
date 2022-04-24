package ru.math.tversu.studentapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.math.tversu.studentapp.model.object.LessonTime;
import ru.math.tversu.studentapp.repository.object.LessonTimeRepository;

import java.util.List;

@Service
public class LessonTimeService {
    @Autowired
    private LessonTimeRepository timeRepository;

    public List<LessonTime> getAll() {
        return timeRepository.findAll();
    }
}
