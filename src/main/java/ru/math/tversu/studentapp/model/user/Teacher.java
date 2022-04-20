package ru.math.tversu.studentapp.model.user;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Teacher extends User {

    @ManyToOne
    private EducatorTitle title;

    public EducatorTitle getTitle() {
        return title;
    }

    public void setTitle(EducatorTitle title) {
        this.title = title;
    }
}
