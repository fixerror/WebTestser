package ua.radchenko.jee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.radchenko.jee.services.StudentService;

/**
 * @author radchenko.as
 * @version 1.0
 */
@Controller
@RequestMapping("/student")
public class StudentController extends AbstractController {
	@Autowired
	protected StudentService studentService;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		return "student/home";
	}

	/*
	 * @RequestMapping(value = "/tests", method = RequestMethod.GET) public
	 * String tests(Model model) { List<Test> tests =
	 * studentService.listAllActiveTests(); model.addAttribute("tests", tests);
	 * return "student/tests"; }
	 */
	// @RequestMapping(value = "/statistics", method = RequestMethod.GET)
	// public String results(Model model, HttpSession session) {
	// List<Result> results =
	// studentService.listResult(session.getAttribute("id"));
	// model.addAttribute("statistics", results);
	// return "student/results";
	// }
}
