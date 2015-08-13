package iVoteSim;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IVoteService<T, S> {

	private Question<T, S> question;
	private List<Answer<S>> correctAnswers;
	private Map<String, Answer<S>> studentAnswers;
	private List<Student> students;
	
	public IVoteService(Question<T, S> q){
		this.question = q;
		studentAnswers = new HashMap<String, Answer<S>>();
		students = new ArrayList<Student>();
		correctAnswers = new ArrayList<Answer<S>>();
	}
	
	public void connectStudent(Student s){
		students.add(s);
	}
	
	public void updateAnswers(){
		for(Student s: students){
			if(s.getAnswerReady()){
				submitAnswer(s.getId(), s.getAnswer());
			}
		}
	}
	
	public void submitAnswer(String id, Answer<S> answer){
		if(studentAnswers.containsKey(id)){
			studentAnswers.remove(id);
		}
		studentAnswers.put(id, answer);
	}
	
	public Collection<Answer<S>> retreiveAnswers(){
		return studentAnswers.values();
	}
	
	public Question<T, S> getQuestion(){
		return question;
	}
	
	public void printStatistics(){
		int count = 0;
		int correctCount = 0;
		for(Answer<S> a : question.getAnswers()){
			for(Student s : students){
				if(studentAnswers.get(s.getId()).getAnswer() == a){
					count++;
				}
				if(correctAnswers.contains(studentAnswers.get(s.getId()).getAnswer())){
					correctCount++;
				}
			}
			System.out.println(a.getAnswer() + ": " + count + " Students.");
		}
		System.out.println("Correct answers: " + correctCount);
		System.out.println("Percent of class correct: " + ((float)correctCount)/((float)studentAnswers.size()));
	}
	
}
