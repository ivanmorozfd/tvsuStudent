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
        if (user instanceof Student || user.getRole().equals("student")) {
            Student student = new Student(user);
            if (student.getStudyGroup() != null && student.getStudyGroup().getId() == null) {
                student.setStudyGroup(null);
            }
            return studentService.save(student);
        }
        if (user instanceof Teacher || user.getRole().equals("teacher")) {
            Teacher teacher = new Teacher(user);
            if (teacher.getTitle() != null && teacher.getTitle().getId() == null) {
                teacher.setTitle(null);
            }
            return teacherService.save(teacher);
        }
        return userService.save(user);
    }

    public void deleteById(Integer id) {
        userService.deleteById(id);
    }
}
