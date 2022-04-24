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
    public String getManagement(Model model) {
        return "scheduleManagement";
    }

    @RequestMapping(method = RequestMethod.POST)
    public Schedule saveSchedule(@RequestBody Schedule schedule) {
        return scheduleFacade.save(schedule);
    }
}
