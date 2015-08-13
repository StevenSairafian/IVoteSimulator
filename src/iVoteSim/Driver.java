package iVoteSim;

import java.util.ArrayList;
import java.util.List;

public class Driver {
	public static void main(String[] args){
		Question<String, String> q = new MultipleChoiceQuestion<String, String>();
		q.setQuestion("How many apples fit in a barrel?");
		Answer<String> ans1 = new MultipleChoiceAnswer<String>();
		Answer<String> ans2 = new MultipleChoiceAnswer<String>();
		Answer<String> ans3  = new MultipleChoiceAnswer<String>();
		ans1.setAnswer("10");
		q.addAnswer(ans1);
		ans2.setAnswer("30");
		q.addAnswer(ans2);
		ans3.setAnswer("600");
		q.addAnswer(ans3);
		List<Answer<String>> tempList = new ArrayList<Answer<String>>();
		tempList.add(ans3);
		q.setCorrectAnswers(tempList);
		IVoteService<String, String> ivs = new IVoteService<String, String>(q);
		new Thread(() -> {
			while (true) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    System.exit(1);
                }
                ivs.updateAnswers();
			}
		}).start();
		Student s1 = new Student("1");
		Student s2 = new Student("2");
		Student s3 = new Student("3");
		Student s4 = new Student("4");
		Student s5 = new Student("5");
		ivs.connectStudent(s1);
		ivs.connectStudent(s2);
		ivs.connectStudent(s3);
		ivs.connectStudent(s4);
		ivs.connectStudent(s5);
		s1.setAnswer(q.getAnswers().get(2));
		s2.setAnswer(q.getAnswers().get(1));
		s3.setAnswer(q.getAnswers().get(2));
		s4.setAnswer(q.getAnswers().get(2));
		s5.setAnswer(q.getAnswers().get(0));
		
		ivs.printStatistics();

	}
}
