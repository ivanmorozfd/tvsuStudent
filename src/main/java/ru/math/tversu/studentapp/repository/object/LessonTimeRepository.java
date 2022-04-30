package ru.math.tversu.studentapp.repository.object;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.math.tversu.studentapp.model.object.LessonTime;

import java.util.List;

public interface LessonTimeRepository extends CrudRepository<LessonTime, Integer> {
	List<LessonTime> findAll();

	LessonTime findFirstByOrderByIdDesc();

	@Query("SELECT lessonTime FROM LessonTime lessonTime WHERE lessonTime.id = :id AND (SELECT COUNT(item) FROM " +
			"ScheduleItem item " +
			"WHERE item.lessonTime = lessonTime) < 1")
	LessonTime findOneNotBoundToAnyScheduleById(Integer id);
}
