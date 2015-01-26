package ua.radchenko.jee.dao.impl.hibernate;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ua.radchenko.jee.dao.RoleDao;
import ua.radchenko.jee.entities.Role;

/**
 * @author radchenko.as
 * @version 1.0
 */
@Repository("hibernateRoleDao")
public class RoleDaoImpl extends AbstractEntityDao<Role> implements RoleDao {

	@Override
	protected Class<Role> getEntityClass() {
		return Role.class;
	}

	@Override
	public Role getStudentRole() {
		return (Role) getSession().createCriteria(getEntityClass())
				.add(Restrictions.eq("idRole", 4L)).uniqueResult();
	}

}
