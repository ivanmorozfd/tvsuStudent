package ru.math.tversu.studentapp.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j2
public class SecurityController {

	@GetMapping(value = {"/", "/login"})
	public String login() {
		return "login";
	}
}
