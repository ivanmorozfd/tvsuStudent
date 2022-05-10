package ru.math.tversu.studentapp.model.object;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import ru.math.tversu.studentapp.model.user.Teacher;

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
}
