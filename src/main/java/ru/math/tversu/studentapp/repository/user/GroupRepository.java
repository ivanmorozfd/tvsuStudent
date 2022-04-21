package ru.math.tversu.studentapp.repository.user;

import org.springframework.data.repository.CrudRepository;
import ru.math.tversu.studentapp.model.user.StudyGroup;

import java.util.List;

public interface GroupRepository extends CrudRepository<StudyGroup, Integer> {
	List<StudyGroup> findAll();
}
