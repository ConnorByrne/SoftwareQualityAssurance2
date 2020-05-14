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
	

}
