package ru.math.tversu.studentapp.model.user;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class StudyGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "name")
	private String name;
}
