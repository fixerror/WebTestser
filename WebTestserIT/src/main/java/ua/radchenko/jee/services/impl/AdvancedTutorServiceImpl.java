package ua.radchenko.jee.services.impl;

/**
 * @author radchenko.as
 * @version 1.0
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ua.radchenko.jee.dao.TestDao;
import ua.radchenko.jee.entities.Test;
import ua.radchenko.jee.services.AdvancedTutorService;

@Service
public class AdvancedTutorServiceImpl implements AdvancedTutorService {
	@Autowired
	@Qualifier("hibernateTestDao")
	private TestDao testDao;

	@Override
	public List<Test> listAllActiveTest() {
		List<Test> test = testDao.listAllActiveTests();
		return test;
	}

}
