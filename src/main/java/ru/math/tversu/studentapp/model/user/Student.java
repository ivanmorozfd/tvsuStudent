package ru.math.tversu.studentapp.model.user;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Student extends User {

    @ManyToOne
    private StudyGroup studyGroup;

    public StudyGroup getGroup() {
        return studyGroup;
    }

    public void setGroup(StudyGroup studyGroup) {
        this.studyGroup = studyGroup;
    }
}
