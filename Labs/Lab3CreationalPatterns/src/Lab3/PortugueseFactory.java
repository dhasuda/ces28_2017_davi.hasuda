package Lab3;

public class PortugueseFactory implements LanguageAbstractFactory {
	
	public PersonDecorated getPersonDecorated(Person person, Address address){
		return new PersonDecoratedPortuguese(person, address);
	}
	
}
