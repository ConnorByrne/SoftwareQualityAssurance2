import java.util.ArrayList;

public class Survey {
	
	

	private String name;
	private ArrayList<Question> questionList = new ArrayList<Question>();
	
	Survey(String name) {
		this.name=name;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	public String addQuestion(Question question) {
		questionList.add(question);
		return question.getQuestionText();
	}

	public ArrayList<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(ArrayList<Question> questionList) {
		this.questionList = questionList;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAverage() {
		double average = 0.0;
		for(Question question : this.getQuestionList()) {
			average+=question.getQuestionAverage();
		}
		average=average/this.getQuestionList().size();
		return average;
	}

	public double getStandardDev() {
		double stdDev = 0;
		double mean = this.getAverage();
		ArrayList<Double> dubs = new ArrayList<Double>();
		for(Question question: this.questionList) {
			for(Integer answer: question.getAnswers()) {
				double d=Math.pow((answer-mean), 2);
				dubs.add(d);
			}
		}
		double squaredDifferences=0;
		for(Double difference: dubs) {
			squaredDifferences+=difference;
		}
		squaredDifferences=squaredDifferences/dubs.size();
		stdDev=Math.sqrt(squaredDifferences);
		return stdDev;
	}
	
	
	

}
