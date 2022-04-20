package ru.math.tversu.studentapp.model.object;

import ru.math.tversu.studentapp.model.user.StudyGroup;
import ru.math.tversu.studentapp.model.user.Teacher;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public LessonTime getTime() {
        return time;
    }

    public void setTime(LessonTime time) {
        this.time = time;
    }

    public StudyGroup getStudyGroup() {
        return studyGroup;
    }

    public void setStudyGroup(StudyGroup studyGroup) {
        this.studyGroup = studyGroup;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public StudyGroup getGroup() {
        return studyGroup;
    }

    public void setGroup(StudyGroup studyGroup) {
        this.studyGroup = studyGroup;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
