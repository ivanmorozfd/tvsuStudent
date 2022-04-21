package ru.math.tversu.studentapp.model.object;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import java.time.DayOfWeek;

@Entity
@Data
public class LessonTime {
    @Id
    private Integer id;
    @Pattern(regexp = "^(([0-9])|([0-1][0-9])|([2][0-3]))(:(([0-9])|([0-5][0-9])))?$")
    @Column(name = "start_time")
    private String startTime;
    @Pattern(regexp = "^(([0-9])|([0-1][0-9])|([2][0-3]))(:(([0-9])|([0-5][0-9])))?$")
    @Column(name = "end_time")
    private String endTime;
    @Column(name = "weekday")
    private DayOfWeek weekday;
}
