
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



class ControllerTest {
	
	private ControllerFactory factory = new ControllerFactory();
	private Controller controller = factory.getController();
	
	@Test
	public void testCreateSurvey() {
		//tests that survey is created
		Survey testSurvey = this.controller.createSurvey("first survey");
		assertNotNull(testSurvey);
		//tests that same survey is not created twice
		assertEquals(testSurvey,this.controller.createSurvey("first survey"));
		//assertEquals("first survey",this.controller.createSurvey("first survey").getName());
	}
	
	@Test
	public void testCreateQuestion() {
		assertEquals("Test question",this.controller.addQuestion("Test question"));
	}
	
	@Test
  	public void testListSurveys() {
		try {
			ArrayList<Survey> surveyList = controller.ListSurveys();
			assertNotNull(surveyList);
			assertTrue(surveyList instanceof ArrayList<?>);
		}catch(Exception e) {
			fail("got Exception, i want ArrayList<Survey>");
		}
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
      public void testGetSurveyByName() {
		controller.createSurvey("Test survey");
		Survey testSurvey = controller.chooseSurvey("Test survey");
		assertNotNull(testSurvey);
		assertTrue(testSurvey instanceof Survey);
	}
      
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
      public void testGetAverageResponseSurvey() throws InvalidAnswerException {
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
  		this.controller.addAnswer(question2,5);
  		this.controller.addAnswer(question2,5);
  		this.controller.addAnswer(question2,5);
  		this.controller.addAnswer(question2,5);
  		this.controller.addAnswer(question2,5);
  		this.controller.addAnswer(question2,5);
  		this.controller.addAnswer(question2,5);
  		Question question3 = questions.get(2);
  		this.controller.addAnswer(question3,2);
  		this.controller.addAnswer(question3,4);
  		this.controller.addAnswer(question3,1);
  		this.controller.addAnswer(question3,4);
  		this.controller.addAnswer(question3,1);
  		this.controller.addAnswer(question3,5);
  		this.controller.addAnswer(question3,4);
  		Question question4 = questions.get(3);
  		this.controller.addAnswer(question4,3);
  		this.controller.addAnswer(question4,1);
  		this.controller.addAnswer(question4,3);
  		this.controller.addAnswer(question4,4);
  		this.controller.addAnswer(question4,2);
  		this.controller.addAnswer(question4,4);
  		this.controller.addAnswer(question4,5);
  		double average=this.controller.getSurveyAverage();
		assertNotEquals(0.0, average);
		assertEquals(3.5, average);
  	
      }
      
      @Test
      public void testGetSurveyStandardDeviation() throws InvalidAnswerException {
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
    		this.controller.addAnswer(question2,5);
    		this.controller.addAnswer(question2,5);
    		this.controller.addAnswer(question2,5);
    		this.controller.addAnswer(question2,5);
    		this.controller.addAnswer(question2,5);
    		this.controller.addAnswer(question2,5);
    		this.controller.addAnswer(question2,5);
    		Question question3 = questions.get(2);
    		this.controller.addAnswer(question3,2);
    		this.controller.addAnswer(question3,4);
    		this.controller.addAnswer(question3,1);
    		this.controller.addAnswer(question3,4);
    		this.controller.addAnswer(question3,1);
    		this.controller.addAnswer(question3,5);
    		this.controller.addAnswer(question3,4);
    		Question question4 = questions.get(3);
    		this.controller.addAnswer(question4,3);
    		this.controller.addAnswer(question4,1);
    		this.controller.addAnswer(question4,3);
    		this.controller.addAnswer(question4,4);
    		this.controller.addAnswer(question4,2);
    		this.controller.addAnswer(question4,4);
    		this.controller.addAnswer(question4,5);
      		double stdDev=this.controller.getSurveyStandardDev();
    		assertNotEquals(0.0, stdDev);
    		assertEquals(1.4516001023501126, stdDev);
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
	
	@Test
	public void testQuestionStandardDev() throws InvalidAnswerException {
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
		double stdDev = this.controller.getQuestionStandardDev(question);
		assertNotEquals(0.0, stdDev);
		assertEquals(1.2453996981544782, stdDev);
		this.controller.addQuestion("Test question 2");
		Question question2 = this.controller.getQuestion("Test Question 2");
		this.controller.addAnswer(question2,1);
		this.controller.addAnswer(question2,2);
		this.controller.addAnswer(question2,3);
		this.controller.addAnswer(question2,4);
		this.controller.addAnswer(question2,5);
		this.controller.addAnswer(question2,2);
		this.controller.addAnswer(question2,4);
		double stdDev2 = this.controller.getQuestionStandardDev(question2);
		assertNotEquals(0.0, stdDev2);
		assertEquals(1.3093073414159542, stdDev2);
	}
	
	@Test
	public void testGetMaxScoreQuestion() throws InvalidAnswerException {
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
		int maxScore = this.controller.getQuestionMaxScore(question);
		assertNotEquals(0, maxScore);
		assertEquals(5, maxScore);
		this.controller.addQuestion("Test question 2");
		Question question2 = this.controller.getQuestion("Test Question 2");
		this.controller.addAnswer(question2,1);
		this.controller.addAnswer(question2,2);
		this.controller.addAnswer(question2,3);
		this.controller.addAnswer(question2,2);
		this.controller.addAnswer(question2,3);
		this.controller.addAnswer(question2,2);
		this.controller.addAnswer(question2,1);
		int maxScore2 = this.controller.getQuestionMaxScore(question2);
		assertNotEquals(0, maxScore2);
		assertEquals(3, maxScore2);
		
	}
	
	@Test
	public void testGetMinScoreQuestion() throws InvalidAnswerException {
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
		int minScore = this.controller.getQuestionMinScore(question);
		assertNotEquals(0, minScore);
		assertEquals(1, minScore);
		this.controller.addQuestion("Test question 2");
		Question question2 = this.controller.getQuestion("Test Question 2");
		this.controller.addAnswer(question2,5);
		this.controller.addAnswer(question2,4);
		this.controller.addAnswer(question2,5);
		this.controller.addAnswer(question2,4);
		this.controller.addAnswer(question2,5);
		this.controller.addAnswer(question2,4);
		this.controller.addAnswer(question2,4);
		int minScore2 = this.controller.getQuestionMinScore(question2);
		assertNotEquals(0, minScore2);
		assertEquals(4, minScore2);
		
	}
}
