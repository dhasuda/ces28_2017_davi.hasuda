package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Person;
import model.Person.PersonListener;

@SuppressWarnings("serial")
public class PersonDetailView extends JPanel implements PersonListener, WindowListener{

	public PersonDetailView(Person person,
			PersonDetailViewListener personDetailController) {
		this.setPerson(person);
		this.setController(personDetailController);
		this.createUI();
		this.bindUI();
		this.populateView();
	}

	private void createUI() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.label = new JLabel();
		add(label, BorderLayout.NORTH);
	
		this.nameTextField = new JTextField();
		add(nameTextField);
		
		this.changeButton = new JButton(LABEL_CHANGE_BUTTON);
		add(changeButton);
	}
	
	private void bindUI() {
		this.getPerson().addListener(this);
		this.changeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				_controller.changedButtonPressed();
			}
		});
	}
	
	private void populateView() {
		if (nameIsNonNullAndNonVoidString()) {
			if (this.getPerson().isValid()) {
				this.label.setText(LABEL + this.getPerson().getColor() + " " + this.getPerson().getName());
			}
		}
		else { this.label.setText(LABEL + "..."); }
	}
	
	public String getNameFromTextField()
	{
		System.out.println("Acao 2: getNameFromTextField()");
		return nameTextField.getText();
	}

	@Override
	public void onPersonNameChanged() {
		System.out.println("Acao 4: onPersonNameChanged()");
		this.populateView();
	}
	
	public void display() {
		if (this.frame == null) {
			this.frame = new JFrame() {
				{
					setTitle(FRAME_TITLE );
					setLocationRelativeTo(null);
					setContentPane(PersonDetailView.this);
					setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					addWindowListener(PersonDetailView.this);
					pack();
				}
			};
		}

		this.frame.setVisible(true);
	}
	
	@Override
	public void windowClosed(WindowEvent arg0) {
		this.getController().windowClosed();
	}
	
	@Override
	public void windowActivated(WindowEvent arg0) {
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
	}
	
	protected Person getPerson() {
		return _person;
	}

	protected void setPerson(Person person) {
		_person = person;
	}

	public PersonDetailViewListener getController() {
		return _controller;
	}

	public void setController(PersonDetailViewListener controller) {
		_controller = controller;
	}

	public Boolean nameIsNonNullAndNonVoidString()
	{	if ((this.getPerson().getName() != null) & (this.getPerson().getName() != ""))
				return true;
		return false;
	}

	private static final String LABEL = "The person name is ";
	private static final String LABEL_CHANGE_BUTTON = "Change";
	private static final String FRAME_TITLE = null;
	
	private Person _person;
	private PersonDetailViewListener _controller;

	private JLabel label;
	private JTextField nameTextField;
	private JButton changeButton;
	private JFrame frame;
}
