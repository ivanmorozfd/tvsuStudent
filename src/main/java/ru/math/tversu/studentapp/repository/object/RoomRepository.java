package ru.math.tversu.studentapp.repository.object;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.math.tversu.studentapp.model.object.Room;

import java.util.List;

public interface RoomRepository extends CrudRepository<Room, Integer> {
	List<Room> findAll();

	Room findFirstByOrderByIdDesc();

	@Query("SELECT room FROM Room room WHERE room.id = :id AND (SELECT COUNT(item) FROM ScheduleItem item " +
			"WHERE item.room = room) < 1")
	Room findOneNotBoundToAnyScheduleById(Integer id);
}
