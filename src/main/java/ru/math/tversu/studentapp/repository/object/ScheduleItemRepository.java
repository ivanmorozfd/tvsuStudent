package ru.math.tversu.studentapp.repository.object;

import org.springframework.data.repository.CrudRepository;
import ru.math.tversu.studentapp.model.object.ScheduleItem;

import java.util.List;

public interface ScheduleItemRepository extends CrudRepository<ScheduleItem, Integer> {
    List<ScheduleItem> findAll();
    ScheduleItem findFirstByOrderByIdDesc();
}
