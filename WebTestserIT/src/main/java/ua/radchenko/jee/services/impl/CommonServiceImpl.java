package ua.radchenko.jee.services.impl;

import java.util.List;

import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restfb.types.User;

import ua.radchenko.jee.components.EntityBuilder;
import ua.radchenko.jee.dao.AccountDao;
import ua.radchenko.jee.dao.AccountRoleDao;
import ua.radchenko.jee.dao.RoleDao;
import ua.radchenko.jee.entities.Account;
import ua.radchenko.jee.entities.AccountRole;
import ua.radchenko.jee.entities.Role;
import ua.radchenko.jee.exceptions.InvalidUserInputException;
import ua.radchenko.jee.forms.SignUpForm;
import ua.radchenko.jee.services.CommonService;
import ua.radchenko.jee.services.EmailService;
import ua.radchenko.jee.utils.ReflectionUtils;

/**
 * @author radchenko.as
 * @version 1.0
 */
@Service("commonService")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CommonServiceImpl implements CommonService {

	@Autowired
	@Qualifier("hibernateAccountDao")
	private AccountDao accountDao;

	@Autowired
	@Qualifier("hibernateRoleDao")
	private RoleDao roleDao;

	@Autowired
	@Qualifier("hibernateaccountRoleDao")
	private AccountRoleDao accountRoleDao;

	@Autowired
	private EntityBuilder entityBuilder;

	@Autowired
	private EmailService emailService;

	public CommonServiceImpl() {
		super();
	}

	@Override
	public Account login(String login, String password, int role)
			throws InvalidUserInputException {
		Account a = accountDao.findByLogin(login);
		if (a == null) {
			throw new InvalidUserInputException("Bad credentials");
		}
		if (!StringUtils.equals(password, a.getPassword())) {
			throw new InvalidUserInputException("Bad credentials");
		}
		if (!a.getActive()) {
			throw new InvalidUserInputException("Account is not active");
		}
		boolean found = false;
		for (AccountRole ar : a.getAccountRoles()) {
			if (ar.getRole().getIdRole().intValue() == role) {
				found = true;
				break;
			}
		}
		if (!found) {
			throw new InvalidUserInputException(
					"Current account does not have selected role");
		}
		return a;
	}

	protected Account signUp(SignUpForm form, boolean sendVerificationEmail,
			boolean sendPasswordToEmail) throws InvalidUserInputException {
		Account a = entityBuilder.buildAccount();
		ReflectionUtils.copyByFields(a, form);
		accountDao.save(a);

		Role r = roleDao.getStudentRole();
		AccountRole ar = entityBuilder.buildAccountRole(a, r);
		accountRoleDao.save(ar);

		if (sendVerificationEmail) {
			emailService.sendVerificationEmail();
		}
		if (sendPasswordToEmail) {
			emailService.sendGeneratedPasswordToEmail();
		}
		return a;
	}

	@Override
	@Transactional(readOnly = false, rollbackFor = {
			InvalidUserInputException.class, RuntimeException.class })
	public Account signUp(SignUpForm form) throws InvalidUserInputException {
		return signUp(form, true, false);
	}

	@Override
	public List<Role> listAllRoles() {
		return roleDao.findAll();
	}

	@Override
	@Transactional(readOnly = false, rollbackFor = {
			InvalidUserInputException.class, RuntimeException.class })
	public Account login(User user) throws InvalidUserInputException {
		Account a = accountDao.findByLogin(user.getEmail());
		if (a != null) {
			return a;
		} else {
			SignUpForm form = new SignUpForm();
			form.setEmail(user.getEmail());
			form.setName(user.getFirstName());
			form.setLogin(user.getEmail());
			form.setActive(true);
			UUID pwd = UUID.randomUUID();// generate temp password
			form.setPassword(pwd.toString());
			form.setPassword2(pwd.toString());

			return signUp(form, false, true);
		}
	}
}
