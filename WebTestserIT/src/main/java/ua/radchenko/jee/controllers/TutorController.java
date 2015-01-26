package ua.radchenko.jee.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.radchenko.jee.forms.CreateTestForm;

/**
 * @author radchenko.as
 * @version 1.0
 */
@Controller
@RequestMapping("/tutor")
public class TutorController extends AbstractTutorController {
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String listTest(Model ui) {
		ui.addAttribute("createTestForm", new CreateTestForm());
		ui.addAttribute("listTests", tutorService.listTests());
		return "tutor/home";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String CreateTest(@ModelAttribute("createTestForm") CreateTestForm createTestForm, Model ui,
BindingResult result) {
		ui.addAttribute("createTestForm", createTestForm);
		tutorService.createTest(createTestForm);
		return "redirect:/tutor/home";
	}

}