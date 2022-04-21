package ru.math.tversu.studentapp.model.object;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Room {
	@Id
	private Integer id;
	@Column(name = "number")
	private String number;
}
