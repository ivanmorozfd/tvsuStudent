package ru.math.tversu.studentapp.repository.object;

import org.springframework.data.repository.CrudRepository;
import ru.math.tversu.studentapp.model.object.Room;

import java.util.List;

public interface RoomRepository extends CrudRepository<Room, Integer> {
	List<Room> findAll();
}
