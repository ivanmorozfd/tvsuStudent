package ru.math.tversu.studentapp.model.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Teacher extends User {
	@ManyToOne
	private EducatorTitle title;
}
