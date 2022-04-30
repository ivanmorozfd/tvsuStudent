package ru.math.tversu.studentapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.math.tversu.studentapp.model.user.EducatorTitle;
import ru.math.tversu.studentapp.service.TitleService;

@Controller
@RequestMapping("/title")
public class TitleController {
    @Autowired
    private TitleService titleService;

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("titles", titleService.getAll());
        return "management/title/manage-titles";
    }

    @RequestMapping(value = "/{titleId}", method = RequestMethod.GET)
    public String getEditor(@PathVariable("titleId") Integer titleId, Model model) {
        model.addAttribute(titleService.getById(titleId));
        Boolean notBoundToAnyTeacher = (titleService.getNotBoundToAnyTeacherById(titleId) != null);
        model.addAttribute("inactive", notBoundToAnyTeacher);
        return "management/title/edit-title";
    }

    @RequestMapping(value = "/{titleId}", method = RequestMethod.POST)
    public String editTitle(@PathVariable("titleId") Integer id, @ModelAttribute("name") String name) {
        EducatorTitle title = titleService.getById(id);
        title.setName(name);
        titleService.save(title);
        return "redirect:/title/";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String getCreator(Model model) {
        EducatorTitle title = titleService.createEntity();
        model.addAttribute("title", title);
        return "management/title/create-title";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createTitle(@ModelAttribute("title") EducatorTitle title) {
        titleService.save(title);
        return "redirect:/title/";
    }

    @RequestMapping(value = "/delete/{titleId}", method = RequestMethod.POST)
    public String deleteTitle(@PathVariable("titleId") Integer titleId) {
        titleService.deleteById(titleId);
        return "redirect:/title/";
    }
}
