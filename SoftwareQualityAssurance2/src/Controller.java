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

	public Question getQuestion(String questionText) {
		for(Question question : this.currentSurvey.getQuestionList()) {
			if(question.getQuestionText().equalsIgnoreCase(questionText)) {
				return question;
			}
		}
		return null;
	}

	public double getQuestionAverage(String questionText) {
		for(Question question : this.currentSurvey.getQuestionList()) {
			if(question.getQuestionText().equalsIgnoreCase(questionText)) {
				return getQuestionAverage(question);
			}
		}
		return 0.0;
		
	}
	
	public double getQuestionAverage(Question question) {
		return question.getQuestionAverage();
	}
	
	public double getQuestionStandardDev(String questionText) {
		for(Question question : this.currentSurvey.getQuestionList()) {
			if(question.getQuestionText().equalsIgnoreCase(questionText)) {
				return getQuestionStandardDev(question);
			}
		}
		return 0.0;
	}

	public double getQuestionStandardDev(Question question) {
		return question.getStandardDev();
	}

	public int getQuestionMaxScore(Question question) {
		return question.getMaxScore();
	}
	
	public int getQuestionMaxSxore(String questionText) {
		for(Question question : this.currentSurvey.getQuestionList()) {
			if(question.getQuestionText().equalsIgnoreCase(questionText)) {
				return getQuestionMaxScore(question);
			}
		}
		return 0;
	}

	public int getQuestionMinScore(Question question) {
		return question.getMinScore();
	}
	
	public int getQuestionMinSxore(String questionText) {
		for(Question question : this.currentSurvey.getQuestionList()) {
			if(question.getQuestionText().equalsIgnoreCase(questionText)) {
				return getQuestionMinScore(question);
			}
		}
		return 0;
	}

	public double getSurveyAverage() {
		double average = 0.0;
		for(Question question : this.currentSurvey.getQuestionList()) {
			average+=question.getQuestionAverage();
		}
		average=average/this.currentSurvey.getQuestionList().size();
		return average;
	}

	
}
