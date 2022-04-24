package ru.math.tversu.studentapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.math.tversu.studentapp.facade.ScheduleFacade;
import ru.math.tversu.studentapp.model.object.Schedule;
import ru.math.tversu.studentapp.model.user.User;
import ru.math.tversu.studentapp.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private ScheduleFacade scheduleFacade;

    @RequestMapping(method = RequestMethod.GET)
    public String home(Authentication authentication, Model model) {
        User user = userService.getByUsername(authentication.getName());
        List<Schedule> schedulesForUsername = scheduleFacade.getSchedulesForUsername(user.getUsername());
        model.addAttribute("username", user.getUsername());
        model.addAttribute("schedules", schedulesForUsername);
        return "home";
    }
}
