package ua.radchenko.jee.components;

import ua.radchenko.jee.entities.Account;
import ua.radchenko.jee.entities.AccountRole;
import ua.radchenko.jee.entities.Role;
import ua.radchenko.jee.entities.Test;

/**
 * @author radchenko.as
 * @version 1.0
 */
public interface EntityBuilder {

	Account buildAccount();

	AccountRole buildAccountRole(Account account, Role role);

	Test buildTest();

}
