package ru.math.tversu.studentapp.model.object;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;
}
