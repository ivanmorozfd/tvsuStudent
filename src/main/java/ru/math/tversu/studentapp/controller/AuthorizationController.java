package ru.math.tversu.studentapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.math.tversu.studentapp.model.user.User;
import ru.math.tversu.studentapp.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthorizationController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = {"/", "/login"}, method = RequestMethod.POST)
	public User login() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth == null) {
			return null;
		}
		Object principal = auth.getPrincipal();
		return principal instanceof org.springframework.security.core.userdetails.User ?
				userService.getByUsername(auth.getName()) :
				null;
	}
}
