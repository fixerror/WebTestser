package ua.radchenko.jee.components.impl;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import ua.radchenko.jee.components.EntityBuilder;
import ua.radchenko.jee.entities.Account;
import ua.radchenko.jee.entities.AccountRole;
import ua.radchenko.jee.entities.Role;
import ua.radchenko.jee.entities.Test;
import ua.radchenko.jee.security.SecurityUtils;



/**
 * @author radchenko.as
 * @version 1.0
 */
@Component("entityBuilder")
public class EntityBuilderImpl implements EntityBuilder {
	@Override
	public Account buildAccount() {
		Account u = new Account();
		u.setCreated(new Timestamp(System.currentTimeMillis()));
		u.setActive(Boolean.FALSE);
		return u;
	}
	@Override
	public AccountRole buildAccountRole(Account account, Role role) {
		return new AccountRole(account, role);
	}
	@Override
	public Test buildTest() {
        Long currentAccount = SecurityUtils.getCurrentIdAccount();
        Account account = new Account() ;
		account.setIdAccount(currentAccount);
		Test test = new Test();
		test.setCreated(new Timestamp(System.currentTimeMillis()));
		test.setActive(Boolean.FALSE);
		/*test.setAccount(account);*/
		return test;
	}
}