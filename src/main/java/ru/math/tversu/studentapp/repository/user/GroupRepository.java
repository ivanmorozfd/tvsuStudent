package ru.math.tversu.studentapp.repository.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.math.tversu.studentapp.model.user.StudyGroup;

import java.util.List;

public interface GroupRepository extends CrudRepository<StudyGroup, Integer> {
	List<StudyGroup> findAll();

	@Query("SELECT g FROM StudyGroup g " +
			"JOIN Student s ON g = s.studyGroup " +
			"JOIN User u ON s.id = u.id " +
			"WHERE u.username = :username")
	StudyGroup findGroupByStudentUsername(String username);
}
