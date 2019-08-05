import java.util.*;

interface Publisher {
}

class NewsAgency extends Observable implements Publisher {
	
	private List<Observer> channels = new ArrayList();
	
	public void addNews(String newsItem) {
		for(Observer outlet: this.channels) {
			outlet.update(this, newsItem);
		}
	}
	
	public void register(Observer outlet) {
		channels.add(outlet);
	}
}

class RadioChannel implements Observer {

	@Override
	public void update(Observable agency, Object newsItem) {
		if (agency instanceof Publisher) {
		System.out.println((String) newsItem); 
		}
	}
}

public class ObserverPattern {
	
	public static void main(String[] args) {
		NewsAgency newsAgency = new NewsAgency();
		RadioChannel radioChannel1 = new RadioChannel();
		RadioChannel radioChannel2 = new RadioChannel();
		RadioChannel radioChannel3 = new RadioChannel();
		
		newsAgency.register(radioChannel1);
		newsAgency.register(radioChannel2);
		newsAgency.register(radioChannel3);
		
		newsAgency.addNews("Important news");
		newsAgency.addNews("Another news");
		newsAgency.addNews("Last news");
	}

}
