import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class ControllerTest {
	
	private ControllerFactory factory = new ControllerFactory();
	private Controller controller;
	
	@Before public void createController() {
		this.controller=factory.getController();
	}
	
	@After public void deleteController() {
		this.controller=factory.deleteController();
	}
	
}
