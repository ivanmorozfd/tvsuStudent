package ru.math.tversu.studentapp.model.object;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.DayOfWeek;

@Entity
@Data
public class LessonTime {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Pattern(regexp = "^(([0-9])|([0-1][0-9])|([2][0-3]))(:(([0-9])|([0-5][0-9])))?$")
    @Column(name = "start_time")
    private String startTime;

    @Pattern(regexp = "^(([0-9])|([0-1][0-9])|([2][0-3]))(:(([0-9])|([0-5][0-9])))?$")
    @Column(name = "end_time")
    private String endTime;

    // TODO for removal
    @Column(name = "weekday")
    @Enumerated(value = EnumType.STRING)
    private DayOfWeek weekday;
}
