package ru.math.tversu.studentapp.model.object;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Schedule {
	@Id
	private Integer id;
}
