package ru.math.tversu.studentapp.repository.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.math.tversu.studentapp.model.user.StudyGroup;

import java.util.List;

public interface StudyGroupRepository extends CrudRepository<StudyGroup, Integer> {
	List<StudyGroup> findAll();

	@Query("SELECT g FROM StudyGroup g " +
			"JOIN Student s ON g = s.studyGroup " +
			"JOIN User u ON s.id = u.id " +
			"WHERE u.username = :username")
	StudyGroup findGroupByStudentUsername(String username);

	// TODO: for refactor
	@Query("SELECT g FROM StudyGroup g WHERE g.id = :id")
	StudyGroup findOneNotBoundToAnyScheduleById(Integer id);

	@Query("SELECT g FROM StudyGroup g WHERE g.id = :id AND (SELECT COUNT(student) FROM Student student WHERE student" +
			".studyGroup = g) < 1")
	StudyGroup findOneNotBoundToAnyStudentById(Integer id);

	StudyGroup findFirstByOrderByIdDesc();
}
