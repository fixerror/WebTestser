package ua.radchenko.jee.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author radchenko.as
 * @version 1.0
 */
@Controller
@RequestMapping("/advanced_tutor")
public class AdvancedTutorController extends AbstractTutorController {

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String listContacts(Map<String, Object> map) {

		map.put("listAllActiveTest", advancedTutorService.listAllActiveTest());
		return "advanced_tutor/home";
	}
}
