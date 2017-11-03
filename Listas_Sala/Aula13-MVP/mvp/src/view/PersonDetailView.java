package view;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

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
import presenter.PersonDetailPresenterImpl;
//import model.Person.PersonListener;

@SuppressWarnings("serial")
public class PersonDetailView extends JPanel implements WindowListener, Observer, PersonDetailViewListener {

	public PersonDetailView(Person person,
			PersonDetailPresenterImpl personDetailPresenterImpl) {
		//this.setPerson(person);
		this.setPresenter(personDetailPresenterImpl);
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
		//this.getPerson().addListener(this);
		this.changeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				_presenter.changeName("Rhuan");
			}
		});
	}
	
	private void populateView() {
		if (nameIsNonNullAndNonVoidString()) {
			PersonDetailPresenterImpl pres = (PersonDetailPresenterImpl) this.getPresenter();
			if (pres.isValid()) {
				this.label.setText(LABEL + pres.getName());
			}
		}
		else { this.label.setText(LABEL + "..."); }
	}
	
	public String getNameFromTextField()
	{
		System.out.println("Acao 2: getNameFromTextField()");
		return nameTextField.getText();
	}

//	public void onPersonNameChanged() {
//		System.out.println("Acao 4: onPersonNameChanged()");
//		this.populateView();
//	}
	
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
		this.windowClosed();
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
	
//	protected Person getPerson() {
//		return _person;
//	}
//
//	protected void setPerson(Person person) {
//		_person = person;
//	}

	public PersonDetailPresenterImpl getPresenter() {
		return _presenter;
	}

	public void setPresenter(PersonDetailPresenterImpl controller) {
		_presenter = controller;
	}

	public Boolean nameIsNonNullAndNonVoidString()
	{	
		PersonDetailPresenterImpl pres = (PersonDetailPresenterImpl) this.getPresenter();
		if ((pres.getName() != null) & (pres.getName() != ""))
				return true;
		return false;
	}

	private static final String LABEL = "The person name is ";
	private static final String LABEL_CHANGE_BUTTON = "Change";
	private static final String FRAME_TITLE = null;
	
	//private Person _person;
	private PersonDetailPresenterImpl _presenter;

	private JLabel label;
	private JTextField nameTextField;
	private JButton changeButton;
	private JFrame frame;
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		System.out.println("Acao 4: onPersonNameChanged()");
		populateView();
		
	}

	@Override
	public void changedButtonPressed() {
		System.out.println("Acao 1: changedButtonPressed()");
		final String newName = this.getNameFromTextField();
		_presenter.changeName(newName);
		
	}

	@Override
	public void windowClosed() {
		// TODO Auto-generated method stub
	}
}
