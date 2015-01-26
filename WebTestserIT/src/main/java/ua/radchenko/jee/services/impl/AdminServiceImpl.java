package ua.radchenko.jee.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.radchenko.jee.dao.AccountDao;
import ua.radchenko.jee.dao.AccountRoleDao;
import ua.radchenko.jee.entities.Account;
import ua.radchenko.jee.services.AdminService;

/**
 * @author radchenko.as
 * @version 1.0
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {

	@Autowired
	@Qualifier("hibernateAccountDao")
	private AccountDao accountDao;
	@Autowired
	@Qualifier("hibernateaccountRoleDao")
	private AccountRoleDao accountRoleDao;

	@Transactional
	public void active(Long id) {
		Account acaunt1 = null;
		acaunt1 = accountDao.findById(id);
		acaunt1.setActive(true);
		accountDao.update(acaunt1);
	}

	@Transactional
	public void deactivate(Long id) {
		Account acaunt2 = null;
		acaunt2 = accountDao.findById(id);
		acaunt2.setActive(false);
		accountDao.update(acaunt2);
	}

	@Override
	public List<Account> listAllUsers() {
		List<Account> account = accountDao.findAll();
		return account;
	}
}