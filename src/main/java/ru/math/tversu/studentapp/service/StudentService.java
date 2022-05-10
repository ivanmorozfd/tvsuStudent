package ru.math.tversu.studentapp.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ru.math.tversu.studentapp.model.user.Student;
import ru.math.tversu.studentapp.repository.user.StudentRepository;

@Service
@RequiredArgsConstructor
public class StudentService {

  private final StudentRepository studentRepository;

  public Optional<Student> findByUsername(String username) {
    return studentRepository.findByUsername(username);
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
