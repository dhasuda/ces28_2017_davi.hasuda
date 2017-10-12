package Lab3;

public class LanguageFactory {

	public static LanguageAbstractFactory getFactory(String language) {
		if (language.equalsIgnoreCase("English"))
			return new EnglishFactory();
		if (language.equalsIgnoreCase("Portuguese"))
			return new PortugueseFactory();
		return null;
	}
		
}
