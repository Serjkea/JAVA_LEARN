interface Request {
	static final int INFO = 1;
	static final int ERR = 2;
	static final int MSG = 3;
	int getID();
	void doIt();
	boolean getStatus();
}

interface Handler {
	void handleRequest(Request request);
	void nextHandler(Handler nextHandler);
}

class InfoHandler implements Handler {
	
	private Handler handler;
	
	public void handleRequest(Request request) {
		if(request.getID() == Request.INFO) {
			request.doIt();
			System.out.println("Info message");
		} else handler.handleRequest(request);
	}
	
	public void nextHandler(Handler nextHandler) {
		this.handler = nextHandler;
	}
}

class ErrorHandler implements Handler {
	
	private Handler handler;
	
	public void handleRequest(Request request) {
		if(request.getID() == Request.ERR) {
			request.doIt();
			System.out.println("Error message");
		} else handler.handleRequest(request);
	}
	
	public void nextHandler(Handler nextHandler) {
		this.handler = nextHandler;
	}
}

class MessageHandler implements Handler {
	
	private Handler handler;
	
	public void handleRequest(Request request) {
		if(request.getID() == Request.MSG) {
			request.doIt();
			System.out.println("Some message");
		} else handler.handleRequest(request);
	}

	public void nextHandler(Handler nextHandler) {
		this.handler = nextHandler;
	}
}

class InfoRequest implements Request {
	private boolean done = false;
	public int getID() {
		return Request.INFO;
	}
	public void doIt(){
		done = true;
	}
	public boolean getStatus(){
		return done;
	}
}

class ErrorRequest implements Request {
	private boolean done = false;
	public int getID() {
		return Request.ERR;
	}
	public void doIt(){
		done = true;
	}
	public boolean getStatus(){
		return done;
	}
}

class MessageRequest implements Request {
	private boolean done = false;
	public int getID() {
		return Request.MSG;
	}
	public void doIt(){
		done = true;
	}
	public boolean getStatus(){
		return done;
	}
}

public class ChainOfResponsobilityPattern {
	
	public static Handler getService() {
		Handler infoHandler = new InfoHandler();
		Handler errorHandler = new ErrorHandler();
		Handler messageHandler = new MessageHandler();
		
		infoHandler.nextHandler(errorHandler);
		errorHandler.nextHandler(messageHandler);
		return infoHandler;
	}
	
	public static void main(String[] args) {
		Request request = new MessageRequest();
		while(!request.getStatus()) {
			getService().handleRequest(request);
		}
	}

}
