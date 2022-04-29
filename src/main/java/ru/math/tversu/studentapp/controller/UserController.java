package ru.math.tversu.studentapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.math.tversu.studentapp.facade.UserFacade;
import ru.math.tversu.studentapp.model.user.EducatorTitle;
import ru.math.tversu.studentapp.model.user.Student;
import ru.math.tversu.studentapp.model.user.StudyGroup;
import ru.math.tversu.studentapp.model.user.Teacher;
import ru.math.tversu.studentapp.model.user.User;
import ru.math.tversu.studentapp.service.StudyGroupService;
import ru.math.tversu.studentapp.service.TitleService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserFacade userFacade;

	@Autowired
	private StudyGroupService studyGroupService;
	@Autowired
	private TitleService titleService;
	private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("users", userFacade.getAll());
		return "management/user/manage-users";
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public String getEditor(@PathVariable("userId") Integer userId, Model model) {
		User user = userFacade.getById(userId);
		model.addAttribute("user", user);
		if (user instanceof Teacher) {
			Boolean notBoundToAnySchedule = (userFacade.getTeacherNotBoundToAnyScheduleById(userId) != null);
			model.addAttribute("inactive", notBoundToAnySchedule);
			model.addAttribute("titles", titleService.getAll());
		}
		if (user instanceof Student) {
			model.addAttribute("studyGroups", studyGroupService.getAll());
		}
		return "management/user/edit-user";
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.POST)
	public String editUser(@PathVariable("userId")Integer userId,
						   @ModelAttribute("user") User user,
						   @ModelAttribute("title") EducatorTitle title,
						   @ModelAttribute("studyGroup") StudyGroup studyGroup,
						   @ModelAttribute("passwordChange")String passwordChange) {
		user.setId(userId);
		if (!passwordChange.equals("")) {
			user.setPassword(passwordEncoder.encode(passwordChange));
		}
		User persistedUser = userFacade.getById(userId);
		if (persistedUser instanceof Student) {
			((Student) persistedUser).setStudyGroup(studyGroup);
		} else if (persistedUser instanceof Teacher) {
			((Teacher) persistedUser).setTitle(title);
		}
		persistedUser.setUsername(user.getUsername());
		persistedUser.setPassword(user.getPassword());
		persistedUser.setEnabled(user.getEnabled());
		persistedUser.setRole(user.getRole());
		persistedUser.setId(user.getId());
		userFacade.saveUser(persistedUser);
		return "redirect:/user/";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String getCreator(Model model) {
		User user = userFacade.createUserEntity();
		model.addAttribute("user", user);
		return "management/user/create-user";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createUser(@ModelAttribute("user") User user) {
		userFacade.saveUser(user);
		return "redirect:/user/";
	}

	@RequestMapping(value = "/delete/{userId}", method = RequestMethod.POST)
	public String deleteUser(@PathVariable("userId") Integer userId) {
		userFacade.deleteById(userId);
		return "redirect:/user/";
	}
}
