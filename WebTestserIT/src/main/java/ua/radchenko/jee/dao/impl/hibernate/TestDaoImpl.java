package ua.radchenko.jee.dao.impl.hibernate;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ua.radchenko.jee.dao.TestDao;
import ua.radchenko.jee.entities.Account;
import ua.radchenko.jee.entities.Test;

/**
 * @author radchenko.as
 * @version 1.0
 */
@Repository("hibernateTestDao")
@SuppressWarnings("unchecked")
public class TestDaoImpl extends AbstractEntityDao<Test> implements TestDao {
	@Override
	protected Class<Test> getEntityClass() {
		return Test.class;
	}

	@Override
	public List<Test> listAllActiveTests() {
		return  getSession().createCriteria(getEntityClass())
				.add(Restrictions.eq("active", true)).list();
	}

	@Override
	public List<Test> findByTutor(Account account) {
		return  getSession().createCriteria(getEntityClass())
				.add(Restrictions.eq("account.idAccount", account.getId())).list();
	}
	
}
