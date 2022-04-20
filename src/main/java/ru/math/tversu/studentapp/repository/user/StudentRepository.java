package ru.math.tversu.studentapp.repository.user;

import org.springframework.data.repository.CrudRepository;
import ru.math.tversu.studentapp.model.user.Student;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Integer> {
    List<Student> findAll();
}
