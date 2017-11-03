package Infraestrutura;

import java.util.Observable;
import java.util.Observer;

public class Subscriber implements Observer {

	private String _topic;
	
	public Subscriber(String topic) {
		this._topic = topic;
	}

	public void receiveMessageCallback(Object arg) {
		//doNothing
	}
	
	@Override
	public void update(Observable o, Object arg) {
		String msgtopic = ((Publisher)o).getTopic(); 
		if (!msgtopic.equals(this._topic)) {
			System.out.println("ERROR: Observer with topic "+ this._topic + " received a message with topic " + msgtopic );
		}
		this.receiveMessageCallback(arg);
	}

	public String get_topic() {
		return _topic;
	}

}
