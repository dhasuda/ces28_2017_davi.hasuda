package Infraestrutura;

import java.util.ArrayList;
import java.util.List;

public enum FakeEventService {
	
	INSTANCE;
	
    // Static getter
    public static FakeEventService getInstance()
    { return INSTANCE; }

	
	public Publisher getPublisher(String topic) {
		Publisher p = new Publisher(topic);
		this.addPublisher(p);
		return p;
	}
	
	public void addSubscriber(Subscriber s) {
		_subscribers.add(s);
		update();
	}
	
	private void addPublisher(Publisher p) {
		_publishers.add(p);
		update();
	}
	
	public void removeSubscriber(Subscriber s) {
		_subscribers.remove(s);
		update();
	}
	
	public void removePublisher(Publisher p) {
		_publishers.remove(p);
		update();
	}
	
	private void update() {
		for (Publisher p: _publishers) {
			p.deleteObservers();
			for (Subscriber s: _subscribers) {
				if (s.get_topic().equals(p.getTopic()) )
					p.addObserver(s);
			}
		}
	}
	
	private List<Publisher> _publishers = new ArrayList<>();
	private List<Subscriber> _subscribers = new ArrayList<>();
}
