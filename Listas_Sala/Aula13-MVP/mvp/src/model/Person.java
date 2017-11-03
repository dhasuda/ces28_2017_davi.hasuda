package model;

import java.util.ArrayList;
import java.util.List;

public class Person {
//	public interface PersonListener{
//		void onPersonNameChanged();
//	}

	public Person()
	{
	
	}
	
	public Person(String name)
	{
		this.setName(name);
	}

	public String getName()
	{
		return _name;
	}
	
	public void setName(String name)
	{
		System.out.println("Acao 3: setName()");
		_name = name;
		//fireOnNameChanged();
	}

//	public void addListener(PersonListener l)
//	{
//		this.listeners.add(l);
//	}
//	
//	public void removeListener(PersonListener l)
//	{
//		this.listeners.remove(l);
//	}
	
//	private void fireOnNameChanged() {
//		for(PersonListener l:this.listeners)
//		{
//			l.onPersonNameChanged();
//		}
//	}
	
//	/*
//	 * Exercício 7
//	 */
//	private int nameLength() {
//		if (_name.length() <= 3) {
//			return 1; // Curto
//		}
//		if (_name.length() <= 10) {
//			return 2; // Medio
//		}
//		return 3; // Grande
//	}
//	public String getColor() {
//		int length = nameLength();
//		if (length == 1) {
//			return "VERMELHO";
//		}
//		if (length == 2) {
//			return "VERDE";
//		}
//		return "AMARELO";
//	}
	
//	/*
//	 * Exercício 6
//	 */
//	private boolean isAlpha() {
//		return _name.matches("[a-zA-Z]+");
//	}
//	private boolean isFirstCapital() {
//		return Character.isUpperCase(_name.charAt(0));
//	}
//	public boolean isValid() {
//		return isAlpha() && isFirstCapital();
//	}
//	static public boolean isValid(String name) {
//		return name.matches("[a-zA-Z]+") && Character.isUpperCase(name.charAt(0));
//	}
	
	private String _name;
	//private List<PersonListener> listeners = new ArrayList<PersonListener>();
}
