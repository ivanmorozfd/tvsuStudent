package ru.math.tversu.studentapp.repository.object;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.math.tversu.studentapp.model.object.Lesson;

import java.util.List;

public interface LessonRepository extends CrudRepository<Lesson, Integer> {
    List<Lesson> findAll();
    Lesson findFirstByOrderByIdDesc();
    @Query("SELECT lesson FROM Lesson lesson WHERE lesson.id = :id AND (SELECT COUNT(item) FROM ScheduleItem item WHERE item.lesson = lesson) < 1")
    Lesson findOneNotBoundToAnyScheduleById(Integer id);
}
