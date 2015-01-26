package ua.radchenko.jee.entities;

import javax.persistence.*;

import java.io.Serializable;

/**
 * The persistent class for the user_registration database table.
 */
@Entity
@Table(name = "user_registration", schema = "public")
@NamedQuery(name = "UserRegistration.findAll", query = "SELECT u FROM UserRegistration u")
public class UserRegistration extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_account", unique = true, nullable = false)
	private long idAccount;

	@Basic
	@Column(name = "hash")
	private String hash;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_account", referencedColumnName = "id_account", nullable = false)
	private Account account;

	public UserRegistration() {
	}

	public Long getIdAccount() {
		return this.idAccount;
	}

	public void setIdAccount(Long idAccount) {
		this.idAccount = idAccount;
	}

	public String getHash() {
		return this.hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public Serializable getId() {
		return getIdAccount();
	}
}
