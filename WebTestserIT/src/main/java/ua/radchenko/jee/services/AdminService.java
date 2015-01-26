package ua.radchenko.jee.services;

import java.util.List;

import ua.radchenko.jee.entities.Account;

/**
 * @author radchenko.as
 * @version 1.0
 */
public interface AdminService {
	public List<Account> listAllUsers();

	public void active(Long id);

	public void deactivate(Long id);
}
