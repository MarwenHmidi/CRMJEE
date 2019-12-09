package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Quizs database table.
 * 
 */
@Entity
@Table(name="Quizs")
@NamedQuery(name="Quiz.findAll", query="SELECT q FROM Quiz q")
public class Quiz implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="QuizId")
	private int quizId;

	@Column(name="QuizName")
	private String quizName;

	//bi-directional many-to-one association to Question
	@OneToMany(mappedBy="quiz")
	private List<Question> questions;

	public Quiz() {
	}

	public int getQuizId() {
		return this.quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

	public String getQuizName() {
		return this.quizName;
	}

	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}

	public List<Question> getQuestions() {
		return this.questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Question addQuestion(Question question) {
		getQuestions().add(question);
		question.setQuiz(this);

		return question;
	}

	public Question removeQuestion(Question question) {
		getQuestions().remove(question);
		question.setQuiz(null);

		return question;
	}

}