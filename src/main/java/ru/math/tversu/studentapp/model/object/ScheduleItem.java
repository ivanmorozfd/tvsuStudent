package ru.math.tversu.studentapp.model.object;

import lombok.Data;
import ru.math.tversu.studentapp.model.user.StudyGroup;
import ru.math.tversu.studentapp.model.user.Teacher;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class ScheduleItem {
    @Id
    private Integer id;
    @ManyToOne
    private Lesson lesson;
    @ManyToOne
    private Teacher teacher;
    @ManyToOne
    private LessonTime time;
    @ManyToOne
    private Room room;
    @ManyToOne
    private StudyGroup studyGroup;
    @ManyToOne
    private Schedule schedule;
}
