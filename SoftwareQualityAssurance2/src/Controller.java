import java.util.ArrayList;

public class Controller {
	ArrayList<Survey> surveyList;
	Survey currentSurvey = new Survey("Default Survey");
	
	Controller(){
		this.surveyList=new ArrayList<Survey>();
	}
	
	public Survey createSurvey(String name) {
		if(this.surveyList.contains(this.chooseSurvey(name))) {
			return chooseSurvey(name);
		}
		else {
			Survey survey = new Survey(name);
			this.surveyList.add(survey);
			this.currentSurvey=survey;
			return survey;
		}
		
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

	public ArrayList<Survey> ListSurveys() {
		return this.surveyList;
	}

	public ArrayList<Question> getSurveyQuestions() {
		
	}

}
