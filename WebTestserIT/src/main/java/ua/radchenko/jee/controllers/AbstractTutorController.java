package ua.radchenko.jee.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import ua.radchenko.jee.services.AdvancedTutorService;
import ua.radchenko.jee.services.TutorService;

/**
 * @author radchenko.as
 * @version 1.0
 */
public abstract class AbstractTutorController extends AbstractController {

	@Autowired
	protected TutorService tutorService;
	@Autowired
	protected AdvancedTutorService advancedTutorService;
}
