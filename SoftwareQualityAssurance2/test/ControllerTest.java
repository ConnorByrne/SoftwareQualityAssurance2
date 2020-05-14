import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

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
	public void testGetSurveyByName() {
		controller.createSurvey("Test survey");
		Survey testSurvey = controller.chooseSurvey("Test survey");
		assertNotNull(testSurvey);
		assertTrue(testSurvey instanceof Survey);
	}
}
