import java.util.*;

public class SessionsManager {
	
	private final Set<ClientSession> sessions=new HashSet<ClientSession>();
	
	public SessionsManager() {}
	
	public synchronized void addSession(ClientSession session) {
		sessions.add(session);
	}
	
	public synchronized void removeSession(ClientSession session) {
		sessions.remove(session);
	}

}
