package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Questions database table.
 * 
 */
@Entity
@Table(name="Questions")
@NamedQuery(name="Question.findAll", query="SELECT q FROM Question q")
public class Question implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="QuestionId")
	private int questionId;

	@Column(name="Choice1")
	private String choice1;

	@Column(name="Choice2")
	private String choice2;

	@Column(name="Choice3")
	private String choice3;

	@Column(name="Choice4")
	private String choice4;

	@Column(name="CorrectAnswer")
	private String correctAnswer;
	
	@Column(name="QuestionName")
	private String questionName;

	@Column(name="Score")
	private int score;

	//bi-directional many-to-one association to Quiz
	@ManyToOne
	@JoinColumn(name="QuizId")
	private Quiz quiz;

	public Question() {
	}

	public int getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getChoice1() {
		return this.choice1;
	}

	public void setChoice1(String choice1) {
		this.choice1 = choice1;
	}

	public String getChoice2() {
		return this.choice2;
	}

	public void setChoice2(String choice2) {
		this.choice2 = choice2;
	}

	public String getChoice3() {
		return this.choice3;
	}

	public void setChoice3(String choice3) {
		this.choice3 = choice3;
	}

	public String getChoice4() {
		return this.choice4;
	}

	public void setChoice4(String choice4) {
		this.choice4 = choice4;
	}

	public String getCorrectAnswer() {
		return this.correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public String getQuestionName() {
		return this.questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	public int getScore() {
		return this.score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Quiz getQuiz() {
		return this.quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

}