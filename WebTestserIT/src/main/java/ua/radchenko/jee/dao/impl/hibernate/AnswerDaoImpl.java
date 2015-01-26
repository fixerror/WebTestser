package ua.radchenko.jee.dao.impl.hibernate;

import org.springframework.stereotype.Repository;

import ua.radchenko.jee.dao.AnswerDao;
import ua.radchenko.jee.entities.Answer;

/**
 * @author radchenko.as
 * @version 1.0
 */

@Repository("hibernateAnswerDao")
public class AnswerDaoImpl extends AbstractEntityDao<Answer> implements
		AnswerDao {

	@Override
	protected Class<Answer> getEntityClass() {
		return Answer.class;
	}

}
