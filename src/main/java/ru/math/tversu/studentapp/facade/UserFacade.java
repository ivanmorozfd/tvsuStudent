package ru.math.tversu.studentapp.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.math.tversu.studentapp.model.user.Student;
import ru.math.tversu.studentapp.model.user.Teacher;
import ru.math.tversu.studentapp.model.user.User;
import ru.math.tversu.studentapp.service.StudentService;
import ru.math.tversu.studentapp.service.TeacherService;
import ru.math.tversu.studentapp.service.UserService;

import java.util.List;

@Service
public class UserFacade {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private UserService userService;

    public User getByUsername(String username) {
        return userService.getByUsername(username);
    }

    public Teacher getTeacherNotBoundToAnyScheduleById(Integer id) {
        return teacherService.getNotBoundToAnyScheduleById(id);
    }

    public Class getUserType(User user) {
        if (studentService.getById(user.getId()) != null) {
            return Student.class;
        } else if (teacherService.getById(user.getId()) != null) {
            return Teacher.class;
        }
        return User.class;
    }

    public List<User> getAll() {
        return userService.getAll();
    }

    public User getById(Integer id) {
        Teacher teacher = teacherService.getById(id);
        if (teacher.getId() != null) {
            return teacher;
        }
        Student student = studentService.getById(id);
        if (student.getId() != null) {
            return student;
        }
        return userService.getById(id);
    }

    public User createUserEntity() {
        return userService.createEntity();
    }

    public User saveUser(User user) {
        if (user instanceof Student) {
            return studentService.save((Student) user);
        }
        if (user instanceof Teacher) {
            return teacherService.save((Teacher) user);
        }
        return userService.save(user);
    }

    public void deleteById(Integer id) {
        userService.deleteById(id);
    }
}
