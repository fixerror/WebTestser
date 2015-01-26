package ua.radchenko.jee.entities;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

/**
 * The persistent class for the question database table.
 */

@Entity
@Table(name = "question", schema = "public")
@NamedQuery(name = "Question.findAll", query = "SELECT q FROM Question q")
public class Question extends AbstractMainEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="QUESTION_IDQUESTION_GENERATOR", sequenceName="QUESTION_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="QUESTION_IDQUESTION_GENERATOR")
	@Column(name="id_question")
	private Long idQuestion;
	@Column
	private String text;

	//bi-directional many-to-one association to Answer
	@OneToMany(mappedBy="question")
	private List<Answer> answers;

	//bi-directional many-to-one association to Test
	@ManyToOne
	@JoinColumn(name="id_test")
	private Test test;

	public Question() {
	}

	public Long getIdQuestion() {
		return this.idQuestion;
	}

	public void setIdQuestion(Long idQuestion) {
		this.idQuestion = idQuestion;
	}

	

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}


	public List<Answer> getAnswers() {
		return this.answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public Answer addAnswer(Answer answer) {
		getAnswers().add(answer);
		answer.setQuestion(this);

		return answer;
	}

	public Answer removeAnswer(Answer answer) {
		getAnswers().remove(answer);
		answer.setQuestion(null);

		return answer;
	}

	public Test getTest() {
		return this.test;
	}

	public void setTest(Test test) {
		this.test = test;
	}
	@Override
	public Serializable getId() {

		return getIdQuestion();
	}
}
