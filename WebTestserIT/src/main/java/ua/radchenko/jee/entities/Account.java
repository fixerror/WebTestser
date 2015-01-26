package ua.radchenko.jee.entities;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

/**
 * The persistent class for the user database table.
 */
@Entity
@Table(name = "account", schema = "public")
@NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a")
public class Account extends AbstractMainEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "ACCOUNT_IDACCOUNT_GENERATOR", sequenceName = "ACCOUNT_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNT_IDACCOUNT_GENERATOR")
	@Column(name = "id_account")
	private Long idAccount;
	@Column
	private String email;
	@Column
	private String login;
	@Column
	private String name;
	@Column
	private String password;

	// bi-directional many-to-one association to AccountRole
	@OneToMany(mappedBy = "account")
	private List<AccountRole> accountRoles;

	// bi-directional many-to-one association to Result
	@OneToMany(mappedBy = "account")
	private List<Result> results;

	// bi-directional many-to-one association to Test
	@OneToMany(mappedBy = "account")
	private List<Test> tests;

	// bi-directional one-to-one association to UserRegistration
	@OneToOne(mappedBy = "account")
	private UserRegistration userRegistration;

	public Account() {
	}

	public Long getIdAccount() {
		return this.idAccount;
	}

	public void setIdAccount(Long idAccount) {
		this.idAccount = idAccount;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<AccountRole> getAccountRoles() {
		return this.accountRoles;
	}

	public void setAccountRoles(List<AccountRole> accountRoles) {
		this.accountRoles = accountRoles;
	}

	public AccountRole addAccountRole(AccountRole accountRole) {
		getAccountRoles().add(accountRole);
		accountRole.setAccount(this);

		return accountRole;
	}

	public AccountRole removeAccountRole(AccountRole accountRole) {
		getAccountRoles().remove(accountRole);
		accountRole.setAccount(null);

		return accountRole;
	}

	public List<Result> getResults() {
		return this.results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	public Result addResult(Result result) {
		getResults().add(result);
		result.setAccount(this);

		return result;
	}

	public Result removeResult(Result result) {
		getResults().remove(result);
		result.setAccount(null);

		return result;
	}

	public List<Test> getTests() {
		return this.tests;
	}

	public void setTests(List<Test> tests) {
		this.tests = tests;
	}

	public Test addTest(Test test) {
		getTests().add(test);
		test.setAccount(this);

		return test;
	}

	public Test removeTest(Test test) {
		getTests().remove(test);
		test.setAccount(null);

		return test;
	}

	public UserRegistration getUserRegistration() {
		return this.userRegistration;
	}

	public void setUserRegistration(UserRegistration userRegistration) {
		this.userRegistration = userRegistration;
	}

	@Override
	public Serializable getId() {
		return getIdAccount();
	}

}