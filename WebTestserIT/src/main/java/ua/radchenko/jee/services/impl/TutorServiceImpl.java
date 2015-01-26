package ua.radchenko.jee.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.radchenko.jee.components.EntityBuilder;
import ua.radchenko.jee.dao.TestDao;
import ua.radchenko.jee.entities.Account;
import ua.radchenko.jee.entities.Test;
import ua.radchenko.jee.forms.CreateTestForm;
import ua.radchenko.jee.security.SecurityUtils;
import ua.radchenko.jee.services.TutorService;
import ua.radchenko.jee.utils.ReflectionUtils;

/**
 * @author radchenko.as
 * @version 1.0
 */
@Service
public class TutorServiceImpl implements TutorService {
	@Autowired
	@Qualifier("hibernateTestDao")
	private TestDao testDao;
	@Autowired
	@Qualifier("entityBuilder")
	private EntityBuilder entityBuilder;

	public List<Test> listTests() {
		Account account = new Account();
		long currentAccount = SecurityUtils.getCurrentIdAccount();
		account.setIdAccount(currentAccount);
		List<Test> test = testDao.findByTutor(account);
		return test;
	}

	@Transactional
	@Override
	public void createTest(CreateTestForm form) {
		Long currentAccount = SecurityUtils.getCurrentIdAccount();
		Account account = new Account();
		account.setIdAccount(currentAccount);
		Test test = entityBuilder.buildTest();
		ReflectionUtils.copyByFields(test, form);
		test.setId_account(currentAccount);
		test.setAccount(account);
		testDao.save(test);

	}

}
