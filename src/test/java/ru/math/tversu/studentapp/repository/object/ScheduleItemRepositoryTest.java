package ru.math.tversu.studentapp.repository.object;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.math.tversu.studentapp.model.object.LessonTime;
import ru.math.tversu.studentapp.model.object.ScheduleItem;
import ru.math.tversu.studentapp.service.LessonTimeService;

import java.time.DayOfWeek;
import java.util.List;

@SpringBootTest
class ScheduleItemRepositoryTest {

    @Autowired
    private ScheduleItemRepository scheduleItemRepository;

    @Autowired
    private LessonTimeService lessonTimeService;

    @Test
    void findAll() {
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            LessonTime one = new LessonTime();
            one.setWeekday(dayOfWeek);
            one.setStartTime("8:30");
            one.setEndTime("10:05");
            lessonTimeService.save(one);

            LessonTime two = new LessonTime();
            two.setWeekday(dayOfWeek);
            two.setStartTime("10:15");
            two.setEndTime("11:55");
            lessonTimeService.save(two);

            LessonTime three = new LessonTime();
            three.setWeekday(dayOfWeek);
            three.setStartTime("12:10");
            three.setEndTime("13:45");
            lessonTimeService.save(three);

            LessonTime four = new LessonTime();
            four.setWeekday(dayOfWeek);
            four.setStartTime("14:00");
            four.setEndTime("15:35");
            lessonTimeService.save(four);

            LessonTime five = new LessonTime();
            five.setWeekday(dayOfWeek);
            five.setStartTime("15:55");
            five.setEndTime("17:30");
            lessonTimeService.save(five);

            LessonTime six = new LessonTime();
            six.setWeekday(dayOfWeek);
            six.setStartTime("17:45");
            six.setEndTime("19:20");
            lessonTimeService.save(six);

        }
    }
}