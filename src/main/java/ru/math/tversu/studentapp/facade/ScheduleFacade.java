package ru.math.tversu.studentapp.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.math.tversu.studentapp.model.object.Schedule;
import ru.math.tversu.studentapp.model.user.Student;
import ru.math.tversu.studentapp.model.user.StudyGroup;
import ru.math.tversu.studentapp.service.ScheduleService;
import ru.math.tversu.studentapp.service.StudentService;

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
		StudyGroup currentStudentGroup = currentStudent.getGroup();
		return scheduleService.getAll().stream().filter(
				schedule -> schedule.getItems().stream().anyMatch(
						item -> item.getStudyGroup().equals(currentStudentGroup)
				)
		).collect(Collectors.toList());
	}

}
