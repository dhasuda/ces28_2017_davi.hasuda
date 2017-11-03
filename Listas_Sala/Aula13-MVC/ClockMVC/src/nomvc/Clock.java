package nomvc;

import java.util.GregorianCalendar;
import java.util.Observable;

public class Clock extends Observable implements Runnable {
	private ClockView view;
	
	public Clock() {
		view = new ClockView(this);
		super.addObserver(view);
	}
	
	public String getTime() {
		String time = "";
		GregorianCalendar calendario = new GregorianCalendar();
		int h = calendario.get(GregorianCalendar.HOUR_OF_DAY);
		int m = calendario.get(GregorianCalendar.MINUTE);
		int s = calendario.get(GregorianCalendar.SECOND);
		time += ((h < 10) ? "0" : "") + h + ":";
		time += ((m < 10) ? "0" : "") + m + ":";
		time += ((s < 10) ? "0" : "") + s;
		return time;
	}
	
	public void run() {
		while (true) {
			//update();
			super.notifyObservers();
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
	
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				//Clock clView = new Clock();
				//Thread th = new Thread(clView);
				//th.start();

			}
		});
	}
	
	
}
