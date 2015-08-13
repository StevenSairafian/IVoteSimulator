package iVoteSim;

public class MultipleChoiceAnswer<T> implements Answer<T> {

	private T answer;
	
	@Override
	public void setAnswer(T answer) {
		this.answer = answer;
	}

	@Override
	public T getAnswer() {
		// TODO Auto-generated method stub
		return answer;
	}

}
