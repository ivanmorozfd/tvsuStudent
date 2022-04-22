package ru.math.tversu.studentapp.repository.user;

import org.springframework.data.repository.CrudRepository;
import ru.math.tversu.studentapp.model.user.Teacher;

import java.util.List;

public interface TeacherRepository extends CrudRepository<Teacher, Integer> {
    List<Teacher> findAll();
}
