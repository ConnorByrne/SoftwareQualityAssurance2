import java.util.ArrayList;

public class Question {
	
	private String questionText;
	ArrayList<Integer> answers = new ArrayList<Integer>();

	public Question(String questionText) {
		this.questionText=questionText;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public ArrayList<Integer> getAnswers() {
		return answers;
	}

	public void setAnswers(ArrayList<Integer> answers) {
		this.answers = answers;
	}
	
	public void addAnswer(int answer) {
		this.answers.add(answer);
	}

	public double getQuestionAverage() {
		double average=0.0;
		for(Integer answer : answers) {
			average=average+answer;
		}
		average=average/answers.size();
		return average;
	}

}
