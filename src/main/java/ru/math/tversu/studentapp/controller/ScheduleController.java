package ru.math.tversu.studentapp.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.math.tversu.studentapp.facade.ScheduleFacade;
import ru.math.tversu.studentapp.model.object.*;
import ru.math.tversu.studentapp.model.user.StudyGroup;
import ru.math.tversu.studentapp.model.user.Teacher;
import ru.math.tversu.studentapp.service.*;

import java.util.LinkedList;

@Controller
@RequestMapping("/schedule")
@Log4j2
public class ScheduleController {
    @Autowired
    private ScheduleFacade scheduleFacade;

    @Autowired
    private LessonService lessonService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private StudyGroupService studyGroupService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private LessonTimeService lessonTimeService;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public String getSchedules(@PathVariable("id") Integer id, Model model) {
        model.addAttribute(scheduleFacade.getById(id));
        return "schedule";
    }

    @RequestMapping(path = "/management", method = RequestMethod.GET)
    public String getGlobalManagement(Model model) {
        model.addAttribute("schedules", scheduleFacade.getAll());
        return "management/schedule/manage-schedules";
    }

    @RequestMapping(path = "/management/{id}", method = RequestMethod.GET)
    public String manageScheduleById(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("schedule", scheduleFacade.getById(id));
        return "management/schedule/edit-schedule";
    }

    @RequestMapping(path = "/management/{scheduleId}/edit/{itemId}", method = RequestMethod.GET)
    public String editItem(@PathVariable("scheduleId") Integer scheduleId, @PathVariable("itemId") Integer itemId, Model model) {
        model.addAttribute("rooms", roomService.getAll());
        model.addAttribute("lessons", lessonService.getAll());
        model.addAttribute("groups", studyGroupService.getAll());
        model.addAttribute("teachers", teacherService.getAll());
        model.addAttribute("times", lessonTimeService.getAll());
        model.addAttribute("item", scheduleFacade.getItemById(itemId));
        return "management/schedule/edit-item";
    }

    @RequestMapping(path = "/management/{scheduleId}/update/{itemId}", method = RequestMethod.POST)
    public String updateItem(
            @PathVariable("scheduleId") Integer scheduleId,
            @PathVariable(value = "itemId") Integer itemId,
            @ModelAttribute Lesson lesson,
            @ModelAttribute Room room,
            @ModelAttribute StudyGroup studyGroup,
            @ModelAttribute Teacher teacher,
            @ModelAttribute LessonTime lessonTime,
            Model model) {
        ScheduleItem item = scheduleFacade.getItemById(itemId);
        item.setLesson(lesson);
        item.setRoom(room);
        item.setStudyGroup(studyGroup);
        item.setTeacher(teacher);
        item.setLessonTime(lessonTime);
        scheduleFacade.saveItem(item);
        return "redirect:/schedule/management/{scheduleId}";
    }

    @RequestMapping(path = "/management/create", method = RequestMethod.GET)
    public String getCreateForm(Model model) {
        Schedule schedule = new Schedule();
        schedule.setItems(new LinkedList<>());
        model.addAttribute("schedule", schedule);
        return "management/schedule/create-schedule";
    }

    @RequestMapping(path = "/management/create", method = RequestMethod.POST)
    public String create() {
        scheduleFacade.save(new Schedule());
        return "redirect:/schedule/management/";
    }

    @RequestMapping(path = "/management/{scheduleId}/create", method = RequestMethod.GET)
    public String getCreateItemForm(@PathVariable("scheduleId") Integer scheduleId, Model model) {
        model.addAttribute("rooms", roomService.getAll());
        model.addAttribute("lessons", lessonService.getAll());
        model.addAttribute("groups", studyGroupService.getAll());
        model.addAttribute("teachers", teacherService.getAll());
        model.addAttribute("times", lessonTimeService.getAll());
        model.addAttribute("item", new ScheduleItem());
        return "management/schedule/create-item";
    }

    @RequestMapping(path = "/management/{scheduleId}/create", method = RequestMethod.POST)
    public String createItem(
            @PathVariable("scheduleId") Integer scheduleId,
            @ModelAttribute Lesson lesson,
            @ModelAttribute Room room,
            @ModelAttribute StudyGroup studyGroup,
            @ModelAttribute Teacher teacher,
            @ModelAttribute LessonTime lessonTime) {
        ScheduleItem item = scheduleFacade.createItemEntity();
        item.setLesson(lesson);
        item.setRoom(room);
        item.setStudyGroup(studyGroup);
        item.setTeacher(teacher);
        item.setLessonTime(lessonTime);
        scheduleFacade.saveItem(item, scheduleId);
        return "redirect:/schedule/management/{scheduleId}";
    }

    @RequestMapping(path = "/management/{scheduleId}/delete/{itemId}", method = RequestMethod.POST)
    public String deleteItem(@PathVariable("scheduleId") Integer scheduleId, @PathVariable("itemId") Integer itemId) {
        scheduleFacade.deleteItemById(scheduleId, itemId);
        return "redirect:/schedule/management/{scheduleId}";
    }

    @RequestMapping(path = "/management/delete/{scheduleId}", method = RequestMethod.POST)
    public String deleteSchedule(@PathVariable("scheduleId")Integer scheduleId) {
        Schedule schedule = scheduleFacade.getById(scheduleId);
        if (schedule != null && schedule.getItems().isEmpty()) {
            scheduleFacade.deleteById(scheduleId);
        }
        return "redirect:/schedule/management/";
    }

    @RequestMapping(method = RequestMethod.POST)
    public Schedule saveSchedule(@RequestBody Schedule schedule) {
        return scheduleFacade.save(schedule);
    }
}
