package ru.math.tversu.studentapp.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.math.tversu.studentapp.model.user.Teacher;
import ru.math.tversu.studentapp.repository.user.TeacherRepository;

import java.util.List;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    void findAll() {
        List<Teacher> all = teacherRepository.findAll();
    }
}