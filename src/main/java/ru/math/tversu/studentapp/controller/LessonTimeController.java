package ru.math.tversu.studentapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.math.tversu.studentapp.model.object.LessonTime;
import ru.math.tversu.studentapp.service.LessonTimeService;

import java.time.DayOfWeek;

@Controller
@RequestMapping("/lessonTime")
public class LessonTimeController {
	@Autowired
	private LessonTimeService lessonTimeService;

	@RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("lessonTimes", lessonTimeService.getAll());
		return "management/lesson-time/manage-lesson-times";
	}

	@RequestMapping(value = "/{lessonTimeId}", method = RequestMethod.GET)
	public String getEditor(@PathVariable("lessonTimeId") Integer lessonTimeId, Model model) {
		model.addAttribute(lessonTimeService.getById(lessonTimeId));
		Boolean notBoundToAnySchedule = (lessonTimeService.getNotBoundToAnyScheduleById(lessonTimeId) != null);
		model.addAttribute("inactive", notBoundToAnySchedule);
		model.addAttribute("weekdays", DayOfWeek.values());
		return "management/lesson-time/edit-lesson-time";
	}

	@RequestMapping(value = "/{lessonTimeId}", method = RequestMethod.POST)
	public String editLessonTime(@PathVariable("lessonTimeId") Integer id,
								 @ModelAttribute("startTime") String startTime,
								 @ModelAttribute("endTime") String endTime,
								 @ModelAttribute("weekday") DayOfWeek weekday) {
		LessonTime lessonTime = lessonTimeService.getById(id);
		lessonTime.setStartTime(startTime);
		lessonTime.setEndTime(endTime);
		lessonTime.setWeekday(weekday);
		lessonTimeService.save(lessonTime);
		return "redirect:/lessonTime/";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String getCreator(Model model) {
		LessonTime lessonTime = lessonTimeService.createEntity();
		model.addAttribute("lessonTime", lessonTime);
		model.addAttribute("weekdays", DayOfWeek.values());
		return "management/lesson-time/create-lesson-time";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createLessonTime(@ModelAttribute("lessonTime") LessonTime lessonTime) {
		lessonTimeService.save(lessonTime);
		return "redirect:/lessonTime/";
	}

	@RequestMapping(value = "/delete/{lessonTimeId}", method = RequestMethod.POST)
	public String deleteLessonTime(@PathVariable("lessonTimeId") Integer lessonTimeId) {
		lessonTimeService.deleteById(lessonTimeId);
		return "redirect:/lessonTime/";
	}
}
