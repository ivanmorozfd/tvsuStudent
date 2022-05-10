package ru.math.tversu.studentapp.dto;

import java.time.DayOfWeek;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.math.tversu.studentapp.model.object.ScheduleItem;

@Data
@AllArgsConstructor
public class ScheduleDayDto {
  private DayOfWeek dayOfWeek;
  private List<ScheduleItem> items;
}
