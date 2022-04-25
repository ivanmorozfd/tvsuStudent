package ru.math.tversu.studentapp.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.math.tversu.studentapp.model.object.Schedule;
import ru.math.tversu.studentapp.model.object.ScheduleItem;
import ru.math.tversu.studentapp.model.user.Student;
import ru.math.tversu.studentapp.model.user.StudyGroup;
import ru.math.tversu.studentapp.service.ScheduleService;
import ru.math.tversu.studentapp.service.StudentService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
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

    public ScheduleItem saveItem(ScheduleItem item) {
        return scheduleService.saveItem(item);
    }

    public ScheduleItem saveItem(ScheduleItem item, Integer scheduleId) {
        Schedule schedule = scheduleService.getById(scheduleId);
        List<ScheduleItem> items = schedule.getItems();
        items.add(item);
        schedule.setItems(items);
        ScheduleItem scheduleItem = scheduleService.saveItem(item);
        scheduleService.save(schedule);
        return scheduleItem;
    }

    public ScheduleItem createEntity() {
        return scheduleService.createEntity();
    }

    public Schedule getById(Integer id) {
        Schedule schedule = scheduleService.getById(id);
        if (schedule != null && schedule.getItems() == null) {
            schedule.setItems(new ArrayList<>());
        }
        return schedule;
    }

    public List<Schedule> getAll() {
        return scheduleService.getAll();
    }

    public ScheduleItem getItemById(Integer id) {
        return scheduleService.getItemById(id);
    }

    public void deleteById(Integer id) {
        scheduleService.deleteById(id);
    }

    public void deleteItemById(Integer scheduleId, Integer itemId) {
        Schedule schedule = scheduleService.getById(scheduleId);
        schedule.setItems(schedule.getItems().stream().filter(item -> !item.getId().equals(itemId)).collect(Collectors.toList()));
        save(schedule);
        scheduleService.deleteItemById(itemId);
    }

}
