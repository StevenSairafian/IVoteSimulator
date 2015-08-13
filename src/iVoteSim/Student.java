package iVoteSim;

public class Student {

	private boolean isReady = false;
	private Answer answer;
	private String id;
	
	public Student(String id){
		this.id = id;
	}
	
	public String getId(){
		return this.id;
	}
	
	public void submitAnswer(){
		isReady = true;
	}
	
	public void setAnswer(Answer a){
		this.answer = a;
	}
	
	public Answer getAnswer(){
		return this.answer;
	}
	
	public boolean getAnswerReady(){
		return isReady;
	}
	
}
