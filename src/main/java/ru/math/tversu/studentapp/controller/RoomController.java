package ru.math.tversu.studentapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.math.tversu.studentapp.model.object.Room;
import ru.math.tversu.studentapp.service.RoomService;

@Controller
@RequestMapping("/room")
public class RoomController {
	@Autowired
	private RoomService roomService;

	@RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("rooms", roomService.getAll());
		return "management/room/manage-rooms";
	}

	@RequestMapping(value = "/{roomId}", method = RequestMethod.GET)
	public String getEditor(@PathVariable("roomId") Integer roomId, Model model) {
		model.addAttribute(roomService.getById(roomId));
		Boolean notBoundToAnySchedule = (roomService.getNotBoundToAnyScheduleById(roomId) != null);
		model.addAttribute("inactive", notBoundToAnySchedule);
		return "management/room/edit-room";
	}

	@RequestMapping(value = "/{roomId}", method = RequestMethod.POST)
	public String editRoom(@PathVariable("roomId") Integer id, @ModelAttribute("number") String number) {
		Room room = roomService.getById(id);
		room.setNumber(number);
		roomService.save(room);
		return "redirect:/room/";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String getCreator(Model model) {
		Room room = roomService.createEntity();
		model.addAttribute("room", room);
		return "management/room/create-room";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createRoom(@ModelAttribute("room") Room room) {
		roomService.save(room);
		return "redirect:/room/";
	}

	@RequestMapping(value = "/delete/{roomId}", method = RequestMethod.POST)
	public String deleteRoom(@PathVariable("roomId") Integer roomId) {
		roomService.deleteById(roomId);
		return "redirect:/room/";
	}
}
