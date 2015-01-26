package ua.radchenko.jee.dao;

import ua.radchenko.jee.entities.Role;

/**
 * @author radchenko.as
 * @version 1.0
 */
public interface RoleDao extends IEntityDao<Role> {
	Role getStudentRole();
}
