package ru.math.tversu.studentapp.model.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Student extends User {
    @ManyToOne
//    @Cascade(CascadeType.ALL)
    @Nullable
    private StudyGroup studyGroup;

    public Student(User user) {
        this.setId(user.getId());
        this.setUsername(user.getUsername());
        this.setPassword(user.getPassword());
        this.setRole(user.getRole());
        this.setEnabled(user.getEnabled());
        this.setStudyGroup(new StudyGroup());
    }

    public Student(Student student) {
        this.setId(student.getId());
        this.setUsername(student.getUsername());
        this.setPassword(student.getPassword());
        this.setRole(student.getRole());
        this.setEnabled(student.getEnabled());
        this.setStudyGroup(student.getStudyGroup());
    }
}
