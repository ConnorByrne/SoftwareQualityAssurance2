
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



class ControllerTest {
	
	private ControllerFactory factory = new ControllerFactory();
	private Controller controller = factory.getController();
	
	@Test
	public void testCreateSurvey() {
		
		assertEquals("first survey",this.controller.createSurvey("first survey").getName());
	}
	
	@Test
	public void testCreateQuestion() {
		assertEquals("Test question",this.controller.addQuestion("Test question"));
	}
	
	@Test
	public void testCreateSurveyResponse() throws InvalidAnswerException {
		this.controller.createSurvey("Test survey");
		this.controller.chooseSurvey("Test survey");
		this.controller.addQuestion("Give Test Answer");
		assertTrue(this.controller.getSurveyQuestions() instanceof ArrayList<?>);
		assertTrue(this.controller.getSurveyQuestions().get(0) instanceof Question);
		ArrayList<Question> questions=this.controller.getSurveyQuestions();
		Question question = questions.get(0);
		this.controller.addAnswer(question,3);
		assertTrue(this.controller.getCurrenSurvey().getQuestionList().get(0).getAnswers() instanceof ArrayList<?>);
		ArrayList<Integer> answerList=this.controller.getCurrenSurvey().getQuestionList().get(0).getAnswers();
		assertTrue(answerList.get(0) instanceof Integer);
		assertEquals(3, answerList.get(0));
	}
	
	@Test
	public void testInvalidAnswer() throws InvalidAnswerException{
		this.controller.createSurvey("Test survey");
		this.controller.chooseSurvey("Test survey");
		this.controller.addQuestion("Give Test Answer");
		assertTrue(this.controller.getSurveyQuestions() instanceof ArrayList<?>);
		assertTrue(this.controller.getSurveyQuestions().get(0) instanceof Question);
		ArrayList<Question> questions=this.controller.getSurveyQuestions();
		Question question = questions.get(0);
		Assertions.assertThrows(InvalidAnswerException.class, () ->{
			this.controller.addAnswer(question,10);
		});
		
	}
	
	@Test
	public void testGetAllAnswers() throws InvalidAnswerException {
		this.controller.createSurvey("Test survey");
		this.controller.chooseSurvey("Test survey");
		this.controller.addQuestion("Test Question 1");
		this.controller.addQuestion("Test Question 2");
		this.controller.addQuestion("Test Question 3");
		this.controller.addQuestion("Test Question 4");
		assertTrue(this.controller.getSurveyQuestions() instanceof ArrayList<?>);
		assertTrue(this.controller.getSurveyQuestions().get(0) instanceof Question);
		ArrayList<Question> questions=this.controller.getSurveyQuestions();
		Question question = questions.get(0);
		this.controller.addAnswer(question,3);
		this.controller.addAnswer(question,4);
		this.controller.addAnswer(question,1);
		this.controller.addAnswer(question,3);
		this.controller.addAnswer(question,2);
		this.controller.addAnswer(question,5);
		this.controller.addAnswer(question,2);
		Question question2 = questions.get(1);
		this.controller.addAnswer(question2,3);
		this.controller.addAnswer(question2,4);
		this.controller.addAnswer(question2,1);
		this.controller.addAnswer(question2,3);
		this.controller.addAnswer(question2,2);
		this.controller.addAnswer(question2,5);
		this.controller.addAnswer(question2,2);
		Question question3 = questions.get(2);
		this.controller.addAnswer(question3,3);
		this.controller.addAnswer(question3,4);
		this.controller.addAnswer(question3,1);
		this.controller.addAnswer(question3,3);
		this.controller.addAnswer(question3,2);
		this.controller.addAnswer(question3,5);
		this.controller.addAnswer(question3,2);
		Question question4 = questions.get(3);
		this.controller.addAnswer(question4,3);
		this.controller.addAnswer(question4,4);
		this.controller.addAnswer(question4,1);
		this.controller.addAnswer(question4,3);
		this.controller.addAnswer(question4,2);
		this.controller.addAnswer(question4,5);
		this.controller.addAnswer(question4,2);
		assertTrue(this.controller.getAllAnswers() instanceof ArrayList<?>);
		ArrayList<Integer> answerList=this.controller.getAllAnswers();
		assertTrue(answerList.get(0) instanceof Integer);
		assertEquals(3, answerList.get(0));
		assertEquals(5, answerList.get(5));
		assertEquals(3, answerList.get(10));
	}
	
	@Test
	public void testGetQuestionAverage() throws InvalidAnswerException {
		this.controller.createSurvey("Test survey");
		this.controller.chooseSurvey("Test survey");
		this.controller.addQuestion("Test Question 1");
		assertTrue(this.controller.getQuestion("Test Question 1") instanceof Question);
		Question question = this.controller.getQuestion("Test Question 1");
		assertNotNull(question);
		this.controller.addAnswer(question,3);
		this.controller.addAnswer(question,4);
		this.controller.addAnswer(question,1);
		this.controller.addAnswer(question,3);
		this.controller.addAnswer(question,2);
		this.controller.addAnswer(question,5);
		this.controller.addAnswer(question,2);
		double average=this.controller.getQuestionAverage("Test Question 1");
		assertNotEquals(0.0, average);
		assertEquals(2.857142857142857, average);
		this.controller.addQuestion("Test question 2");
		Question question2 = this.controller.getQuestion("Test Question 2");
		this.controller.addAnswer(question2,4);
		this.controller.addAnswer(question2,4);
		this.controller.addAnswer(question2,4);
		this.controller.addAnswer(question2,4);
		this.controller.addAnswer(question2,4);
		this.controller.addAnswer(question2,4);
		this.controller.addAnswer(question2,4);
		double average2=this.controller.getQuestionAverage("Test Question 2");
		assertNotEquals(0.0, average2);
		assertEquals(4, average2);
	}
}
