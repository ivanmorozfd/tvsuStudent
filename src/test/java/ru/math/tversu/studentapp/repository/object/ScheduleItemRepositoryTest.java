package ru.math.tversu.studentapp.repository.object;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.math.tversu.studentapp.model.object.ScheduleItem;

import java.util.List;

@SpringBootTest
class ScheduleItemRepositoryTest {

    @Autowired
    private ScheduleItemRepository scheduleItemRepository;

    @Test
    void findAll() {
        List<ScheduleItem> all = scheduleItemRepository.findAll();
        // TODO fix business user containing password explicitly
    }
}