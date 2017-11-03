package nomvc;

import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.util.Observable;
import java.util.Observer;

public class ClockView implements Observer {
	private Clock clock;
	
	public ClockView(Clock clock) {
		this.clock = clock;
		this.mountDisplay();
	}

	public void update() {
		System.out.println("Hora: " + clock.getTime());
		label.setText((String) clock.getTime());
	}

	public void mountDisplay() {
		JPanel panel = new JPanel();

		panel.add(label);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));

		label.setFont(new Font("Arial", Font.ITALIC, 25));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().add(panel);

		frame.setResizable(false);
		frame.setBounds(200, 200, 500, 110);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		label.setText(clock.getTime());
	}

	private JLabel label = new JLabel();
	private static JFrame frame = new JFrame("Clock :D");

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		this.update();
		
	}

}
