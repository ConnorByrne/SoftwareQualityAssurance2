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

	public double getStandardDev() {
//		double powerSum1=0;
//		double powerSum2=0;
		double stdev=0;
//		
//		for(int i=0;i<this.answers.size();i++) {
//			powerSum1+=answers.get(i);
//			powerSum2+=Math.pow(answers.get(i), 2);
//			stdev=Math.sqrt(i*powerSum2 - Math.pow(powerSum1, 2))/i;
//		}
		double mean=this.getQuestionAverage();
		ArrayList<Double> dubs = new ArrayList<Double>();
		for(Integer answer : this.answers) {
			double d = Math.pow((answer-mean),2);
			dubs.add(d);
		}
		double squaredDifferences=0;
		for(Double difference: dubs) {
			squaredDifferences+=difference;
		}
		squaredDifferences=squaredDifferences/dubs.size();
		stdev=Math.sqrt(squaredDifferences);
		return stdev;
	}

	public int getMaxScore() {
		int maxScore=0;
		for(Integer answer: answers) {
			if(answer>maxScore) {
				maxScore=answer;
			}
		}
		return maxScore;
	}

	public int getMinScore() {
		int minScore=6;
		for(Integer answer: answers) {
			if(answer<minScore) {
				minScore=answer;
			}
		}
		return minScore;
	}

}
