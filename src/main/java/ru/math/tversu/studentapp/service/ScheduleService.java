package ru.math.tversu.studentapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.math.tversu.studentapp.model.object.Schedule;
import ru.math.tversu.studentapp.repository.object.ScheduleRepository;

import java.util.List;

@Service
public class ScheduleService {
	@Autowired
	private ScheduleRepository scheduleRepository;

	public List<Schedule> getAll() {
		return scheduleRepository.findAll();
	}
}
