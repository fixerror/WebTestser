package ua.radchenko.jee.dao.impl.hibernate;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ua.radchenko.jee.dao.IEntityDao;

/**
 * @author radchenko.as
 * @version 1.0
 */
public abstract class AbstractEntityDao<T> implements IEntityDao<T> {
	protected final Logger LOGGER = Logger.getLogger(getClass());

	@Autowired
	protected SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	protected abstract Class<T> getEntityClass();

	@Override
	public void save(final T e) {
		getSession().save(e);
	}

	@Override
	public void update(final T e) {
		getSession().update(e);
	}

	@Override
	public void delete(final T e) {
		getSession().delete(e);
	}

	@Override
	public void remove(final T e) {
		delete(e);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(final Serializable id) {
		return (T) getSession().get(getEntityClass(), id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return getSession().createCriteria(getEntityClass()).list();
	}

	@Override
	public void close() {

	}
}
