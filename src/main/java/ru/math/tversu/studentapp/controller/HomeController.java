package ru.math.tversu.studentapp.controller;

import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import ru.math.tversu.studentapp.facade.ScheduleFacade;
import ru.math.tversu.studentapp.model.object.Schedule;
import ru.math.tversu.studentapp.model.user.Student;
import ru.math.tversu.studentapp.model.user.StudyGroup;
import ru.math.tversu.studentapp.model.user.User;
import ru.math.tversu.studentapp.model.user.UserRole;
import ru.math.tversu.studentapp.service.StudentService;
import ru.math.tversu.studentapp.service.UserService;

@Controller
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeController {

  private final UserService userService;

  private final StudentService studentService;

  private final ScheduleFacade scheduleFacade;

  @RequestMapping(method = RequestMethod.GET)
  public String home(Authentication authentication, Model model) {
    User user = userService.getByUsername(authentication.getName());

    if (user.getRole() == UserRole.STUDENT) {
      return "redirect:/home?schedule=PLUS";
    }

    model.addAttribute("userFullName", user.getFullName());
    model.addAttribute("role", user.getRole().name());
    return "home";
  }

  @RequestMapping(
      method = RequestMethod.GET,
      params = {"schedule"})
  public String schedules(
      @RequestParam(value = "schedule") Schedule.WeekType weekType,
      Authentication authentication,
      Model model) {
    var student = studentService.findByUsername(authentication.getName());
    if (student.isEmpty()) {
      return "home";
    }

    model.addAttribute("scheduleDays", scheduleFacade.getScheduleDays(student.get(), weekType));
    model.addAttribute("groupName", getGroupName(student.get()));
    model.addAttribute("scheduleWeekType", weekType.name());
    model.addAttribute("userFullName", student.get().getFullName());
    model.addAttribute("role", UserRole.STUDENT.name());
    return "home";
  }

  private String getGroupName(Student student) {
    return Optional.ofNullable(student.getStudyGroup()).map(StudyGroup::getName).orElse("");
  }
}
