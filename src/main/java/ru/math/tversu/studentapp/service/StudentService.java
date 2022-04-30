package ru.math.tversu.studentapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.math.tversu.studentapp.model.user.Student;
import ru.math.tversu.studentapp.repository.user.StudentRepository;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student getStudentByUsername(String username) {
        return studentRepository.findOneByUsername(username);
    }

    public Student getById(Integer id) {
        return studentRepository.findById(id).orElse(new Student());
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public void deleteById(Integer id) {
        studentRepository.deleteById(id);
    }
}
