package ru.math.tversu.studentapp.model.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Teacher extends User {
    @ManyToOne
    @Nullable
    private EducatorTitle title;

    public Teacher(User user) {
        this.setId(user.getId());
        this.setUsername(user.getUsername());
        this.setPassword(user.getPassword());
        this.setRole(user.getRole());
        this.setEnabled(user.getEnabled());
        this.setTitle(new EducatorTitle());
    }

    public Teacher(Teacher teacher) {
        this.setId(teacher.getId());
        this.setUsername(teacher.getUsername());
        this.setPassword(teacher.getPassword());
        this.setRole(teacher.getRole());
        this.setEnabled(teacher.getEnabled());
        this.setTitle(teacher.getTitle());
    }
}
