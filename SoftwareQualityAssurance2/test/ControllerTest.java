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
}
