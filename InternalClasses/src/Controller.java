import java.util.*;

public class Controller {
	
	private List<Event> eventList = new ArrayList<Event>();

	public void addEvent(Event e) {
		eventList.add(e);
	}
	
	public void run() {
		if(eventList.size() > 0) {
			for(Event e: new ArrayList<Event>(eventList)) {
				if(e.ready()) {
					System.out.println(e);
					e.action();
					eventList.remove(e);
				}
			}
		}
	}
	
}
