package ua.radchenko.jee.services;

import java.util.List;

import ua.radchenko.jee.entities.Result;
import ua.radchenko.jee.entities.Test;

/**
 * @author radchenko.as
 * @version 1.0
 */
public interface StudentService {

	List<Test> listAllActiveTests();

	List<Result> listResults(long id_student);

}
