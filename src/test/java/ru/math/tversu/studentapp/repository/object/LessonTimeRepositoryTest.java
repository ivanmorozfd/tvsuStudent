package ru.math.tversu.studentapp.repository.object;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.math.tversu.studentapp.model.object.LessonTime;

import java.util.List;

@SpringBootTest
class LessonTimeRepositoryTest {

    @Autowired
    private LessonTimeRepository lessonTimeRepository;

    @Test
    void findAll() {
        List<LessonTime> all = lessonTimeRepository.findAll();
    }
}