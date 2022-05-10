package ru.math.tversu.studentapp.repository.object;

import org.springframework.data.repository.CrudRepository;
import ru.math.tversu.studentapp.model.object.Schedule;

import java.util.List;

public interface ScheduleRepository extends CrudRepository<Schedule, Integer> {
    List<Schedule> findAll();
    Schedule findFirstByOrderByIdDesc();
    List<Schedule> findByStudyGroupNameAndWeekType(String groupName, Schedule.WeekType weekType);
}
