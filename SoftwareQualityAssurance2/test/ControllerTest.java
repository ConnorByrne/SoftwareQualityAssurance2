import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class ControllerTest {
	
	private ControllerFactory factory = new ControllerFactory();
	private Controller controller = factory.getController();
	
	@Test
	public void testCreateSurvey() {
		
		assertEquals("first survey",this.controller.createSurvey("first survey").getName());
	}
	
}
