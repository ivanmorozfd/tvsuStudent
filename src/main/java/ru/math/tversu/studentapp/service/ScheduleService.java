package ru.math.tversu.studentapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.math.tversu.studentapp.model.object.Schedule;
import ru.math.tversu.studentapp.model.object.ScheduleItem;
import ru.math.tversu.studentapp.repository.object.ScheduleItemRepository;
import ru.math.tversu.studentapp.repository.object.ScheduleRepository;

import java.util.List;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private ScheduleItemRepository scheduleItemRepository;

    public List<Schedule> getAll() {
        return scheduleRepository.findAll();
    }

    public Schedule save(Schedule entity) {
        return scheduleRepository.save(entity);
    }

    public ScheduleItem saveItem(ScheduleItem item) {
        return scheduleItemRepository.save(item);
    }

    public Schedule getById(Integer id) {
        return scheduleRepository.findById(id).orElse(new Schedule());
    }

    public ScheduleItem getItemById(Integer id) {
        return scheduleItemRepository.findById(id).orElse(new ScheduleItem());
    }

    public void deleteById(Integer id) {
        scheduleRepository.deleteById(id);
    }

    public void deleteItemById(Integer id) {
        scheduleItemRepository.deleteById(id);
    }

}
