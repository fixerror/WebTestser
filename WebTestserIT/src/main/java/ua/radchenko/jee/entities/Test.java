package ua.radchenko.jee.entities;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

/**
 * The persistent class for the test database table.
 */
@Entity
@Table(name = "test", schema = "public")
@NamedQuery(name = "Test.findAll", query = "SELECT t FROM Test t")
public class Test extends AbstractMainEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TEST_IDTEST_GENERATOR", sequenceName="TEST_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TEST_IDTEST_GENERATOR")
	@Column(name="id_test", unique = true, nullable = false)
	private Long idTest;
	@Column(name="description")
	private String description;
	@Column(name="nametest")
	private String nametest;
	@Column
	private Integer time;
	@Column(name = "id_account", insertable = false, updatable = false)
	private long id_account;

	public long getId_account() {
		return id_account;
	}
	public void setId_account(long id_account) {
		this.id_account = id_account;
	}
	//bi-directional many-to-one association to Question
	@OneToMany(mappedBy="test")
	private List<Question> questions;

	//bi-directional many-to-one association to Result
	@OneToMany(mappedBy="test")
	private List<Result> results;

	//bi-directional many-to-one association to Account
	@ManyToOne
	@JoinColumn(name="id_account", nullable = false)
	private Account account;

	public Test() {
	}

	public Long getIdTest() {
		return this.idTest;
	}

	public void setIdTest(Long idTest) {
		this.idTest = idTest;
	}


	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNametest() {
		return nametest;
	}
	public void setNametest(String nametest) {
		this.nametest = nametest;
	}

	public Integer getTime() {
		return this.time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}


	public List<Question> getQuestions() {
		return this.questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Question addQuestion(Question question) {
		getQuestions().add(question);
		question.setTest(this);

		return question;
	}

	public Question removeQuestion(Question question) {
		getQuestions().remove(question);
		question.setTest(null);

		return question;
	}

	public List<Result> getResults() {
		return this.results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	public Result addResult(Result result) {
		getResults().add(result);
		result.setTest(this);

		return result;
	}

	public Result removeResult(Result result) {
		getResults().remove(result);
		result.setTest(null);

		return result;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public Serializable getId() {
		return getIdTest();
	}
}
