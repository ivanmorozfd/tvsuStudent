package ru.math.tversu.studentapp.model.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Student extends User {
    @ManyToOne
    private StudyGroup studyGroup;
}
