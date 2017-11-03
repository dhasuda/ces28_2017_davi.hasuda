package main;

import model.Person;
import presenter.PersonDetailPresenterImpl;

public class Main {
	public static void main(String[] args) {
		Person p = new Person("Rhuan");
		new PersonDetailPresenterImpl(p);
	}

}

