package Lab3;

public class EnglishFactory implements LanguageAbstractFactory {
	
	public PersonDecorated getPersonDecorated(Person person, Address address){
		return new PersonDecoratedEnglish(person, address);
	}
}
