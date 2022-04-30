package ru.math.tversu.studentapp.model.object;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Schedule {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@OneToMany
	private List<ScheduleItem> items;
}
