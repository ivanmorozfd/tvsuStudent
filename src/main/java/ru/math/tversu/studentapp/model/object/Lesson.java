package ru.math.tversu.studentapp.model.object;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Lesson {
    @Id
    private Integer id;
    @Column(name = "name")
    private String name;
}
