package ru.math.tversu.studentapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.math.tversu.studentapp.model.user.StudyGroup;
import ru.math.tversu.studentapp.service.StudyGroupService;

@Controller
@RequestMapping("/studyGroup")
public class StudyGroupController {
	@Autowired
	private StudyGroupService studyGroupService;

	@RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("studyGroups", studyGroupService.getAll());
		return "management/study-group/manage-study-groups";
	}

	@RequestMapping(value = "/{studyGroupId}", method = RequestMethod.GET)
	public String getEditor(@PathVariable("studyGroupId") Integer studyGroupId, Model model) {
		model.addAttribute(studyGroupService.getById(studyGroupId));
		Boolean notBoundToAnySchedule = (studyGroupService.getNotBoundToAnyScheduleById(studyGroupId) != null);
		model.addAttribute("inactive", notBoundToAnySchedule);
		return "management/study-group/edit-study-group";
	}

	@RequestMapping(value = "/{studyGroupId}", method = RequestMethod.POST)
	public String editGroup(@PathVariable("studyGroupId") Integer id, @ModelAttribute("name") String name) {
		StudyGroup group = studyGroupService.getById(id);
		group.setName(name);
		studyGroupService.save(group);
		return "redirect:/studyGroup/";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String getCreator(Model model) {
		StudyGroup group = studyGroupService.createEntity();
		model.addAttribute("studyGroup", group);
		return "management/study-group/create-study-group";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createStudyGroup(@ModelAttribute("studyGroup") StudyGroup studyGroup) {
		studyGroupService.save(studyGroup);
		return "redirect:/studyGroup/";
	}

	@RequestMapping(value = "/delete/{studyGroupId}", method = RequestMethod.POST)
	public String deleteStudyGroup(@PathVariable("studyGroupId") Integer studyGroupId) {
		studyGroupService.deleteById(studyGroupId);
		return "redirect:/studyGroup/";
	}
}
