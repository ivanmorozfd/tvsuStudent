package ru.math.tversu.studentapp.model.object;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Schedule {
	@Id
	private Integer id;
	@OneToMany
	private List<ScheduleItem> items;
}
