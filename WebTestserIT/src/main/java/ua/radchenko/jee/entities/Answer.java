package ua.radchenko.jee.entities;

import javax.persistence.*;

import java.io.Serializable;

/**
 * The persistent class for the answer database table.
 */

@Entity
@Table(name = "answer", schema = "public")
@NamedQuery(name = "Answer.findAll", query = "SELECT a FROM Answer a")
public class Answer extends AbstractMainEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ANSWER_IDANSWER_GENERATOR", sequenceName="ANSWER_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ANSWER_IDANSWER_GENERATOR")
	@Column(name="id_answer")
	private Long idAnswer;
	@Column
	private Boolean correct;
	@Column
	private String text;

	//bi-directional many-to-one association to Question
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_question")
	private Question question;

	public Answer() {
	}

	public Long getIdAnswer() {
		return this.idAnswer;
	}

	public void setIdAnswer(Long idAnswer) {
		this.idAnswer = idAnswer;
	}

	

	public Boolean getCorrect() {
		return this.correct;
	}

	public void setCorrect(Boolean correct) {
		this.correct = correct;
	}


	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}


	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Override
	public Serializable getId() {
		return getIdAnswer();
	}
}
