package ru.math.tversu.studentapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.math.tversu.studentapp.model.user.Teacher;
import ru.math.tversu.studentapp.repository.user.TeacherRepository;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> getAll() {
        return teacherRepository.findAll();
    }

    public Teacher getById(Integer id) {
        return teacherRepository.findById(id).orElse(new Teacher());
    }

    public Teacher getNotBoundToAnyScheduleById(Integer id) {
        return teacherRepository.findOneNotBoundToAnyScheduleById(id);
    }

    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }
}
