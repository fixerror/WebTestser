package ua.radchenko.jee.dao;

import java.util.List;

import ua.radchenko.jee.entities.Result;

/**
 * @author radchenko.as
 * @version 1.0
 */
public interface ResultDao extends IEntityDao<Result> {
	List<Result> listUserResults(long id_student);
}
