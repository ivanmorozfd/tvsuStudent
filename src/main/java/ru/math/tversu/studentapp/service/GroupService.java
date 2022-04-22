package ru.math.tversu.studentapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.math.tversu.studentapp.model.user.StudyGroup;
import ru.math.tversu.studentapp.repository.user.GroupRepository;

@Service
public class GroupService {
	@Autowired
	private GroupRepository groupRepository;

	public StudyGroup getGroupByStudentUsername(String username) {
		return groupRepository.findGroupByStudentUsername(username);
	}
}
