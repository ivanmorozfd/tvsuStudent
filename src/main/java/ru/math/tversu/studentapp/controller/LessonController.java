package ru.math.tversu.studentapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.math.tversu.studentapp.model.object.Lesson;
import ru.math.tversu.studentapp.service.LessonService;

@Controller
@RequestMapping("/lesson")
public class LessonController {
    @Autowired
    private LessonService lessonService;

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("lessons", lessonService.getAll());
        return "management/lesson/manage-lessons";
    }

    @RequestMapping(value = "/{lessonId}", method = RequestMethod.GET)
    public String getEditor(@PathVariable("lessonId") Integer lessonId, Model model) {
        model.addAttribute(lessonService.getById(lessonId));
        Boolean notBoundToAnySchedule = (lessonService.getNotBoundToAnyScheduleById(lessonId) != null);
        model.addAttribute("inactive", notBoundToAnySchedule);
        return "management/lesson/edit-lesson";
    }

    @RequestMapping(value = "/{lessonId}", method = RequestMethod.POST)
    public String editLesson(@PathVariable("lessonId") Integer id, @ModelAttribute("name") String name) {
        Lesson lesson = lessonService.getById(id);
        lesson.setName(name);
        lessonService.save(lesson);
        return "redirect:/lesson/";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String getCreator(Model model) {
        Lesson lesson = lessonService.createEntity();
        model.addAttribute("lesson", lesson);
        return "management/lesson/create-lesson";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createLesson(@ModelAttribute("lesson") Lesson lesson) {
        lessonService.save(lesson);
        return "redirect:/lesson/";
    }

    @RequestMapping(value = "/delete/{lessonId}", method = RequestMethod.POST)
    public String deleteLesson(@PathVariable("lessonId") Integer lessonId) {
        lessonService.deleteById(lessonId);
        return "redirect:/lesson/";
    }

}
