package ua.radchenko.jee.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ua.radchenko.jee.dao.ResultDao;
import ua.radchenko.jee.dao.TestDao;
import ua.radchenko.jee.entities.Result;
import ua.radchenko.jee.entities.Test;
import ua.radchenko.jee.services.StudentService;

/**
 * @author radchenko.as
 * @version 1.0
 */
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	@Qualifier("hibernateTestDao")
	private TestDao testDao;
	@Autowired
	@Qualifier("hibernateResultDao")
	private ResultDao resultDao;

	@Override
	public List<Test> listAllActiveTests() {
		List<Test> tests = testDao.listAllActiveTests();
		return tests;
	}

	@Override
	public List<Result> listResults(long id_student) {
		return resultDao.listUserResults(id_student);
	}
}
