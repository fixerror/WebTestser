package ua.radchenko.jee.dao.impl.hibernate;

import org.springframework.stereotype.Repository;

import ua.radchenko.jee.dao.AccountRoleDao;
import ua.radchenko.jee.entities.AccountRole;

/**
 * @author radchenko.as
 * @version 1.0
 */
@Repository("hibernateaccountRoleDao")
public class AccountRoleDaoImpl extends AbstractEntityDao<AccountRole>
		implements AccountRoleDao {
	@Override
	protected Class<AccountRole> getEntityClass() {
		return AccountRole.class;
	}
}
