package ru.math.tversu.studentapp.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class SecurityController {

  @GetMapping(value = {"/", "/login"})
  public String login(Authentication authentication, Model model) {
    return "login";
  }
}
