package ru.math.tversu.studentapp.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.math.tversu.studentapp.model.object.Schedule;
import ru.math.tversu.studentapp.model.user.Student;
import ru.math.tversu.studentapp.model.user.StudyGroup;
import ru.math.tversu.studentapp.service.ScheduleService;
import ru.math.tversu.studentapp.service.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleFacade {
    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private StudentService studentService;

    public List<Schedule> getSchedulesForUsername(String username) {
        Student currentStudent = studentService.getStudentByUsername(username);
        if (currentStudent != null) {
            StudyGroup currentStudentGroup = currentStudent.getGroup();
            if (currentStudentGroup != null) {
                return scheduleService.getAll().stream().filter(
                        schedule -> schedule.getItems().stream().anyMatch(
                                item -> item.getStudyGroup().equals(currentStudentGroup)
                        )
                ).collect(Collectors.toList());
            }
        }
        return new ArrayList<>();
    }

    public Schedule save(Schedule entity) {
        return scheduleService.save(entity);
    }

    public Schedule getById(Integer id) {
        Schedule schedule = scheduleService.getById(id);
        if (schedule != null && schedule.getItems() == null) {
            schedule.setItems(new ArrayList<>());
        }
        return schedule;
    }

}
