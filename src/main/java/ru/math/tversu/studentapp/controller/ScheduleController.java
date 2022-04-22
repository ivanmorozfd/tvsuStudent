package ru.math.tversu.studentapp.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.math.tversu.studentapp.facade.ScheduleFacade;
import ru.math.tversu.studentapp.model.object.Schedule;

import java.util.List;

@RestController
@RequestMapping("/schedule")
@Log4j2
public class ScheduleController {
	@Autowired
	private ScheduleFacade scheduleFacade;

	@RequestMapping(method = RequestMethod.GET)
	public List<Schedule> getSchedules(Authentication authentication) {
		return scheduleFacade.getSchedulesForUsername(authentication.getName());
	}
}
