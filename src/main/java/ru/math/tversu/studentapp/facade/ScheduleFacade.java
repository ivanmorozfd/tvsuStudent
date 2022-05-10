package ru.math.tversu.studentapp.facade;

import static java.util.Comparator.comparing;
import static java.util.Objects.isNull;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ru.math.tversu.studentapp.dto.ScheduleDayDto;
import ru.math.tversu.studentapp.model.object.Schedule;
import ru.math.tversu.studentapp.model.object.ScheduleItem;
import ru.math.tversu.studentapp.model.user.Student;
import ru.math.tversu.studentapp.service.ScheduleService;

@Service
@RequiredArgsConstructor
public class ScheduleFacade {

  private final ScheduleService scheduleService;

  public List<ScheduleDayDto> getScheduleDays(Student student, Schedule.WeekType weekType) {
    if (isNull(student.getStudyGroup())) {
      return Collections.emptyList();
    }

    var schedules =
        scheduleService.getByGroupNameAndWeekType(student.getStudyGroup().getName(), weekType);
    if (schedules.isEmpty()) {
      return Collections.emptyList();
    }

    return schedules.get(0).getItems().stream()
        .collect(groupingBy(item -> item.getLessonTime().getWeekday()))
        .entrySet()
        .stream()
        .map(entry -> new ScheduleDayDto(entry.getKey(), entry.getValue()))
        .sorted(comparing(ScheduleDayDto::getDayOfWeek))
        .collect(toList());
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

    public ScheduleItem createItemEntity() {
        return scheduleService.createItemEntity();
    }

    public Schedule createEntity() {
        return scheduleService.createEntity();
    }

    public Schedule getById(Integer id) {
        Schedule schedule = scheduleService.getById(id);
        if (schedule != null && schedule.getItems() == null) {
            schedule.setItems(new ArrayList<>());
        }
        if (schedule != null) {
            schedule.setItems(schedule.getItems().stream().sorted(
                    Comparator.comparingInt(o -> o.getLessonTime().getWeekday().getValue())).collect(
                    toList()));
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
        schedule.setItems(schedule.getItems().stream().filter(item -> !item.getId().equals(itemId)).collect(toList()));
        save(schedule);
        scheduleService.deleteItemById(itemId);
    }

}
