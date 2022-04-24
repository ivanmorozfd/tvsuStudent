package ru.math.tversu.studentapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
    private Logger logger = LoggerFactory.getLogger(SecurityController.class);

    @GetMapping(value = {"/", "/login"})
    public String login() {
        return "redirect:/home";
    }
}
