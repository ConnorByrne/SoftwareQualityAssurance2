import java.util.ArrayList;

public class Controller {
	ArrayList<Survey> surveyList;
	Survey currentSurvey = new Survey("Default Survey");
	
	Controller(){
		this.surveyList=new ArrayList<Survey>();
	}
	
	public Survey createSurvey(String name) {
		Survey survey = new Survey(name);
		this.surveyList.add(survey);
		return survey;
	}

	public String addQuestion(String questionText) {
		Question question = new Question(questionText);
		return this.currentSurvey.addQuestion(question);
	}
	
	public Survey chooseSurvey(String surveyName) {
		for(Survey survey:this.surveyList) {
			if(surveyName.equalsIgnoreCase(survey.getName())) {
				this.currentSurvey=survey;
			}
		}
		return this.currentSurvey;
	}

	public ArrayList<Question> getSurveyQuestions() {
		return this.currentSurvey.getQuestionList();
	}

	public void addAnswer(Question question, int answer) throws InvalidAnswerException {
		if(answer>0 && answer<6) {
			int index=this.currentSurvey.getQuestionList().indexOf(question);
			this.currentSurvey.getQuestionList().get(index).addAnswer(answer);
		}
		else {
			throw new InvalidAnswerException(answer);
		}
	}
	
	public Survey getCurrenSurvey() {
		return this.currentSurvey;
	}

	public ArrayList<Integer> getAllAnswers() {
		ArrayList<Integer> answers=new ArrayList<Integer>();
		for(Question question:this.currentSurvey.getQuestionList()) {
			answers.addAll(question.getAnswers());
		}
		return answers;
	}
	

}
