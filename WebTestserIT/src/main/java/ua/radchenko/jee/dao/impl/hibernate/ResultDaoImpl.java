package ua.radchenko.jee.dao.impl.hibernate;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ua.radchenko.jee.dao.ResultDao;
import ua.radchenko.jee.entities.Result;

/**
 * @author radchenko.as
 * @version 1.0
 */

@Repository("hibernateResultDao")
@SuppressWarnings("unchecked")
public class ResultDaoImpl extends AbstractEntityDao<Result> implements
		ResultDao {
	@Override
	protected Class<Result> getEntityClass() {
		return Result.class;
	}

	@Override
	public List<Result> listUserResults(final long id_account) {
		return (List<Result>) getSession().createCriteria(getEntityClass())
				.add(Restrictions.eq("id_account", id_account)).list();
	}
}
