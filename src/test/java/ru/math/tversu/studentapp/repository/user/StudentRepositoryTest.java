package ru.math.tversu.studentapp.repository.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.math.tversu.studentapp.model.user.Student;
import ru.math.tversu.studentapp.repository.user.StudentRepository;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void findAll() {
        List<Student> all = studentRepository.findAll();
    }
}