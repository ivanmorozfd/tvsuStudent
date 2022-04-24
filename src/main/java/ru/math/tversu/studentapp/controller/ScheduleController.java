package ru.math.tversu.studentapp.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.math.tversu.studentapp.facade.ScheduleFacade;
import ru.math.tversu.studentapp.model.object.Schedule;

@Controller
@RequestMapping("/schedule")
@Log4j2
public class ScheduleController {
    @Autowired
    private ScheduleFacade scheduleFacade;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public String getSchedules(@PathVariable("id") Integer id, Model model) {
        model.addAttribute(scheduleFacade.getById(id));
        return "schedule";
    }

    @RequestMapping(path = "/management", method = RequestMethod.GET)
    public String getGlobalManagement(Model model) {
        model.addAttribute("schedules", scheduleFacade.getAll());
        return "schedules-management";
    }

    @RequestMapping(path = "/management/{id}", method = RequestMethod.GET)
    public String manageScheduleById(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("schedule", scheduleFacade.getById(id));
        return "edit-schedule";
    }

    @RequestMapping(path = "/management/{scheduleId}/delete/{itemId}", method = RequestMethod.POST)
    public String deleteItem(@PathVariable("scheduleId") Integer scheduleId, @PathVariable("itemId") Integer itemId, Model model) {
        scheduleFacade.deleteItemById(scheduleId, itemId);
        return "redirect:/schedule/management/{scheduleId}";
    }

    @RequestMapping(method = RequestMethod.POST)
    public Schedule saveSchedule(@RequestBody Schedule schedule) {
        return scheduleFacade.save(schedule);
    }
}
