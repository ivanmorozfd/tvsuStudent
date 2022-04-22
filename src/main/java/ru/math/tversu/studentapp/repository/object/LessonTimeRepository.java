package ru.math.tversu.studentapp.repository.object;

import org.springframework.data.repository.CrudRepository;
import ru.math.tversu.studentapp.model.object.LessonTime;

import java.util.List;

public interface LessonTimeRepository extends CrudRepository<LessonTime, Integer> {
    List<LessonTime> findAll();
}
