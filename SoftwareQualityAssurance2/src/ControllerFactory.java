
public class ControllerFactory {
	
	Controller controller = null;
	
	ControllerFactory(){
		if(this.controller==null) {
			this.controller=new Controller();
		}
	}
	
	public Controller getController() {
		if(this.controller==null) {
			this.controller=new Controller();
		}
		return this.controller;
	}
	
	public Controller deleteController() {
		this.controller=null;
		return this.controller;
	}

}
