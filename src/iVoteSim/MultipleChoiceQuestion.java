package iVoteSim;

import java.util.List;

public class MultipleChoiceQuestion<T, S> implements Question<T, S> {
	
	T question;
	List<Answer<S>> answers;
	List<Answer<S>> correctAnswers;

	@Override
	public void setQuestion(T question) {
		this.question = question;
	}

	@Override
	public T getQuestion() {
		return question;
	}

	@Override
	public List<Answer<S>> getAnswers() {
		return answers;
	}

	@Override
	public void setAnswers(List<Answer<S>> answers) {
		this.answers = answers;
	}

	@Override
	public void addAnswer(Answer<S> answer) {
		answers.add(answer);
	}

	@Override
	public void setCorrectAnswers(List<Answer<S>> correctAnswers) {
		this.correctAnswers = correctAnswers;	
	}

	@Override
	public List<Answer<S>> getCorrectAnswers() {
		return correctAnswers;
	}

}
