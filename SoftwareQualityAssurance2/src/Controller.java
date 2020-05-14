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

}
