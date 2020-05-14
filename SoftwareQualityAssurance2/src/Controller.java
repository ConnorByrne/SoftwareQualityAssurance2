import java.util.ArrayList;

public class Controller {
	ArrayList<Survey> surveyList;
	
	Controller(){
		this.surveyList=new ArrayList<Survey>();
	}
	
	public Survey createSurvey(String name) {
		Survey survey = new Survey(name);
		this.surveyList.add(survey);
		return survey;
	}

}
