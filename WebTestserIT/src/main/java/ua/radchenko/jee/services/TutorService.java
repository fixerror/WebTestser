package ua.radchenko.jee.services;

import java.util.List;

import ua.radchenko.jee.entities.Test;
import ua.radchenko.jee.forms.CreateTestForm;

/**
 * @author radchenko.as
 * @version 1.0
 */
public interface TutorService {

	List<Test> listTests();

	void createTest(CreateTestForm form);

}
