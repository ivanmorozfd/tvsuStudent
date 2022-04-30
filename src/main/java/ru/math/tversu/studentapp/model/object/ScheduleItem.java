package ru.math.tversu.studentapp.model.object;

import lombok.Data;
import ru.math.tversu.studentapp.model.user.StudyGroup;
import ru.math.tversu.studentapp.model.user.Teacher;

import javax.persistence.*;

@Entity
@Data
public class ScheduleItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne
	private Lesson lesson;
	@ManyToOne
	private Teacher teacher;
	@ManyToOne
	private LessonTime lessonTime;
	@ManyToOne
	private Room room;
	@ManyToOne
	private StudyGroup studyGroup;
}
