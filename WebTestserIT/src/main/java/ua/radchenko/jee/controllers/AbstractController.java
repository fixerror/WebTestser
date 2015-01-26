package ua.radchenko.jee.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import ua.radchenko.jee.services.CommonService;

/**
 * @author radchenko.as
 * @version 1.0
 */
public abstract class AbstractController {
	protected final Logger LOGGER = Logger.getLogger(getClass());
	@Autowired
	protected CommonService commonService;
}
