package iVoteSim;

import java.util.List;

public interface Question<T> {

	public void setQuestion(T question);
	public T getQuestion();
	
	public List<Answer> getAnswers();
	public void setAnswers(List<Answer> answers);
	public void addAnswer(Answer answer);
	
	public void setCorrectAnswers(List<Answer> correctAnswers);
	public List<Answer> getCorrectAnswers();
	
}
