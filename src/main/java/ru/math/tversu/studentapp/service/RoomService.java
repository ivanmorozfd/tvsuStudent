package ru.math.tversu.studentapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.math.tversu.studentapp.model.object.Room;
import ru.math.tversu.studentapp.repository.object.RoomRepository;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAll() {
        return roomRepository.findAll();
    }

    public Room getById(Integer id) {
        return roomRepository.findById(id).orElse(new Room());
    }

    public Room save(Room room) {
        return roomRepository.save(room);
    }

    public Room createEntity() {
        return new Room();
    }

    public Room getNotBoundToAnyScheduleById(Integer id) {
        return roomRepository.findOneNotBoundToAnyScheduleById(id);
    }

    public void deleteById(Integer id) {
        roomRepository.deleteById(id);
    }

}
