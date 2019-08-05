
public class Context {
	private SessionsManager sessionsManager;
	public boolean stopFlag;
	
	public Context() {
		this.stopFlag=false;
		this.sessionsManager=new SessionsManager();
	}
	
	public SessionsManager getSessionsManager() {
		return this.sessionsManager;
	}

}
