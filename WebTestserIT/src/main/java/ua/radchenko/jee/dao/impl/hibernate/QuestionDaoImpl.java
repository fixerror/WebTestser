package ua.radchenko.jee.dao.impl.hibernate;

import org.springframework.stereotype.Repository;

import ua.radchenko.jee.dao.QuestionDao;
import ua.radchenko.jee.entities.Question;

/**
 * @author radchenko.as
 * @version 1.0
 */
@Repository("hibernateQuestionDao")
public class QuestionDaoImpl extends AbstractEntityDao<Question> implements
		QuestionDao {
	@Override
	protected Class<Question> getEntityClass() {
		return Question.class;
	}
}
