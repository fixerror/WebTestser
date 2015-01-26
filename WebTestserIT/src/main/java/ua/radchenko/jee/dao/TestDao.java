package ua.radchenko.jee.dao;

import java.util.List;

import ua.radchenko.jee.entities.Account;
import ua.radchenko.jee.entities.Test;

/**
 * @author radchenko.as
 * @version 1.0
 */
public interface TestDao extends IEntityDao<Test> {
	List<Test> listAllActiveTests();
	List<Test> findByTutor(Account account);
}
