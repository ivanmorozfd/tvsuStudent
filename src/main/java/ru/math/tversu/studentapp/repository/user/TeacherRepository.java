package ru.math.tversu.studentapp.repository.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.math.tversu.studentapp.model.user.Teacher;
import ru.math.tversu.studentapp.model.user.User;

import java.util.List;

public interface TeacherRepository extends CrudRepository<Teacher, Integer> {
    List<Teacher> findAll();
    @Query("SELECT teacher FROM Teacher teacher WHERE teacher.id = :id AND (SELECT COUNT(item) FROM ScheduleItem item WHERE item.teacher = teacher) < 1")
    Teacher findOneNotBoundToAnyScheduleById(Integer id);
}
