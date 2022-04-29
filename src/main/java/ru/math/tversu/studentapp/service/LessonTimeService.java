package ru.math.tversu.studentapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.math.tversu.studentapp.model.object.LessonTime;
import ru.math.tversu.studentapp.repository.object.LessonTimeRepository;

import java.util.List;

@Service
public class LessonTimeService {
	@Autowired
	private LessonTimeRepository timeRepository;

	public List<LessonTime> getAll() {
		return timeRepository.findAll();
	}

	public LessonTime getById(Integer id) {
		return timeRepository.findById(id).orElse(new LessonTime());
	}

	public LessonTime save(LessonTime lessonTime) {
		return timeRepository.save(lessonTime);
	}

	public LessonTime createEntity() {
		Integer lastId = timeRepository.findFirstByOrderByIdDesc().getId();
		LessonTime lesson = new LessonTime();
		lesson.setId(++lastId);
		return lesson;
	}

	public LessonTime getNotBoundToAnyScheduleById(Integer id) {
		return timeRepository.findOneNotBoundToAnyScheduleById(id);
	}

	public void deleteById(Integer id) {
		timeRepository.deleteById(id);
	}
}
