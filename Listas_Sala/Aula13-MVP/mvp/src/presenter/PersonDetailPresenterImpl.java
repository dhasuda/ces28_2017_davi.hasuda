package presenter;

import model.Person;
import view.PersonDetailView;
import view.PersonDetailViewListener;
import java.util.Observable;

public class PersonDetailPresenterImpl extends Observable  {

	public PersonDetailPresenterImpl(Person person)
	{
		this.setModel(person);
		this.setView(person); 
	}
	
	// Método para o teste
	public PersonDetailPresenterImpl(Person person, PersonDetailView view)
	{
		this.setModel(person);
		_view = view;
	}

	public void changeName(String newName) {
		
		if (isNotEmpty(newName) && PersonDetailPresenterImpl.isValid(newName))
		{	
			this.getModel().setName(newName);
			super.setChanged();
			super.notifyObservers();
		}
	}
	
	protected PersonDetailView getView() {
		return _view;
	}
	
	protected void setView(Person person){
		_view = new PersonDetailView(person, this);
		super.addObserver(_view);
		this.getView().display();
	}
	
	protected Person getModel() {
		return _model;
	}

	protected void setModel(Person model) {
		_model = model;
	}
	
	private Boolean isNotEmpty(String s){
		return !s.trim().isEmpty();
	}

	private Person _model;
	private PersonDetailView _view;
	
	public String getName() {
		System.out.println("Acao 5: getName()");
		return this.getColor() + " " + _model.getName();
	}
	
	/*
	 * Exercício 7
	 */
	private int nameLength() {
		if (_model.getName().length() <= 3) {
			return 1; // Curto
		}
		if (_model.getName().length() <= 10) {
			return 2; // Medio
		}
		return 3; // Grande
	}
	private String getColor() {
		int length = nameLength();
		if (length == 1) {
			return "VERMELHO";
		}
		if (length == 2) {
			return "VERDE";
		}
		return "AMARELO";
	}
	
	/*
	 * Exercício 6
	 */
	private boolean isAlpha() {
		return _model.getName().matches("[a-zA-Z]+");
	}
	private boolean isFirstCapital() {
		return Character.isUpperCase(_model.getName().charAt(0));
	}
	public boolean isValid() {
		return isAlpha() && isFirstCapital();
	}
	static public boolean isValid(String name) {
		return name.matches("[a-zA-Z]+") && Character.isUpperCase(name.charAt(0));
	}
	
}
