package ua.radchenko.jee.entities;

import javax.persistence.*;

import java.io.Serializable;

/**
 * The persistent class for the result database table.
 */
@Entity
@Table(name = "result", schema = "public")
@NamedQuery(name = "Result.findAll", query = "SELECT r FROM Result r")
public class Result extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RESULT_IDRESULT_GENERATOR", sequenceName="RESULT_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RESULT_IDRESULT_GENERATOR")
	@Column(name="id_result")
	private Long idResult;

	private String comment;

	private String result;

	//bi-directional many-to-one association to Account
	@ManyToOne
	@JoinColumn(name="id_student")
	private Account account;

	//bi-directional many-to-one association to Test
	@ManyToOne
	@JoinColumn(name="id_test")
	private Test test;

	public Result() {
	}

	public Long getIdResult() {
		return this.idResult;
	}

	public void setIdResult(Long idResult) {
		this.idResult = idResult;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}


	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Test getTest() {
		return this.test;
	}

	public void setTest(Test test) {
		this.test = test;
	}
	@Override
	public Serializable getId() {
		return getIdResult();
	}
}
