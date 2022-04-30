package ru.math.tversu.studentapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.math.tversu.studentapp.model.user.StudyGroup;
import ru.math.tversu.studentapp.repository.user.StudyGroupRepository;

import java.util.List;

@Service
public class StudyGroupService {
	@Autowired
	private StudyGroupRepository studyGroupRepository;

	public StudyGroup createEntity() {
		return new StudyGroup();
	}

	public StudyGroup getGroupByStudentUsername(String username) {
		return studyGroupRepository.findGroupByStudentUsername(username);
	}

	public List<StudyGroup> getAll() {
		return studyGroupRepository.findAll();
	}

	public StudyGroup getById(Integer id) {
		return studyGroupRepository.findById(id).orElse(new StudyGroup());
	}

	public StudyGroup getNotBoundToAnyScheduleById(Integer id) {
		return studyGroupRepository.findOneNotBoundToAnyScheduleById(id);
	}

	public StudyGroup save(StudyGroup group) {
		return studyGroupRepository.save(group);
	}

	public void deleteById(Integer id) {
		studyGroupRepository.deleteById(id);
	}
}
