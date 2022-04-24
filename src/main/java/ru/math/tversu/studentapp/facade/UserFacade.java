package ru.math.tversu.studentapp.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.math.tversu.studentapp.model.user.Student;
import ru.math.tversu.studentapp.model.user.Teacher;
import ru.math.tversu.studentapp.model.user.User;
import ru.math.tversu.studentapp.service.StudentService;
import ru.math.tversu.studentapp.service.TeacherService;
import ru.math.tversu.studentapp.service.UserService;

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

    public Class getUserType(User user) {
        if (studentService.getById(user.getId()) != null) {
            return Student.class;
        } else if (teacherService.getById(user.getId()) != null) {
            return Teacher.class;
        }
        return User.class;
    }
}
