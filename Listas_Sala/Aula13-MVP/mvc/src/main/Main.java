package main;

import controller.PersonDetailControllerImpl;
import model.Person;

public class Main {
	public static void main(String[] args) {
		Person p = new Person("Rhuan");
		new PersonDetailControllerImpl(p);
	}

}

