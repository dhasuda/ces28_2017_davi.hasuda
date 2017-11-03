package Infraestrutura;

import java.util.Observable;

public class Publisher extends Observable {
	private String _topic;
	
	public Publisher(String _topic) {
		super();
		this._topic = _topic;
	}

	public void setValue(Object msg) {
		setChanged();
		notifyObservers(msg);
	}

	public String getTopic() {
		return _topic;
	}
	
	
}
