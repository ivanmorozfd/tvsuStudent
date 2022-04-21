package ru.math.tversu.studentapp.repository.object;

import org.springframework.data.repository.CrudRepository;
import ru.math.tversu.studentapp.model.object.Lesson;

import java.util.List;

public interface LessonRepository extends CrudRepository<Lesson, Integer> {
	List<Lesson> findAll();
}
