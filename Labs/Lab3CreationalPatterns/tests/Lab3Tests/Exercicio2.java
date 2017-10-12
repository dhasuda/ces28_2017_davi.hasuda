package Lab3Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Lab3.Date;
import Lab3.Address;
import Lab3.LanguageAbstractFactory;
import Lab3.LanguageFactory;
import Lab3.LetterBuilder;
import Lab3.Person;
import Lab3.Letter;

public class Exercicio2 {

	private String language;
	private Person sender;
	private Person destinatary;
	private Address addressSender;
	private Address addressDestiny;
	private Date date;
	
	@Before
	public void setUp() {
		sender = new Person("Sender", "sender@servidor", "0000-0000");
		destinatary = new Person("Destinary", "destinary@servidor", "1111-1111");
		addressSender = new Address("sender add");
		addressDestiny = new Address("destiny add");
		date = new Date(2017, 10, 10);
	}
	
	@Test
	public void test1() {
		language = "English";
		LanguageAbstractFactory languageFactory = LanguageFactory.getFactory(language);
		languageFactory.getPersonDecorated(sender, addressSender);
		languageFactory.getPersonDecorated(destinatary, addressDestiny);
		Letter letter = LetterBuilder.getCommercialLetter(sender, destinatary, addressSender, addressDestiny, date);
		String expectedText = "10/10/2017\n" + 
				"\n" + 
				"Mr. Sender\n" + 
				"St. sender add\n" + 
				"Mr. DestinarySt. destiny add\n" + 
				"Dear   Mr. Destinary\n" + 
				"\n" + 
				"Sincerely,\n" + 
				"\n" + 
				"\n" + 
				"__________________\n" + 
				" +1 0000-0000Mr. Sender\n" + 
				"\n" + 
				"                                    email:sender@servidor";
		assertEquals(letter.getText(), expectedText);

		
		letter = LetterBuilder.getAdvertisingLetter(sender, destinatary, addressSender, addressDestiny, date);
		expectedText = "10/10/2017\n" + 
				"\n" + 
				"Mr. Sender\n" + 
				"St. sender add\n" + 
				"Mr. DestinarySt. destiny add\n" + 
				"Dear   Mr. Destinary\n" + 
				"             Have a nice week\n";
		assertEquals(letter.getText(), expectedText);
		
		letter = LetterBuilder.getRomanticLetter(sender, destinatary, addressSender, addressDestiny, date);
		expectedText = "My darling\n" + 
				"I love you \n" + 
				"\n" + 
				"\n" + 
				"                 With all my love\n";
		assertEquals(letter.getText(), expectedText);
	}

	
	@Test
	public void test2() {
		language = "Portuguese";
		LanguageAbstractFactory languageFactory = LanguageFactory.getFactory(language);
		languageFactory.getPersonDecorated(sender, addressSender);
		languageFactory.getPersonDecorated(destinatary, addressDestiny);
		Letter letter = LetterBuilder.getCommercialLetter(sender, destinatary, addressSender, addressDestiny, date);
		String expectedText = "10/10/2017\n" + 
				"\n" + 
				"Sr. Sender\n" + 
				"Rua sender add\n" + 
				"Sr. DestinaryRua destiny add\n" + 
				"Dear   Sr. Destinary\n" + 
				"\n" + 
				"Sincerely,\n" + 
				"\n" + 
				"\n" + 
				"__________________\n" + 
				" +55 0000-0000Sr. Sender\n" + 
				"\n" + 
				"                                    email:sender@servidor";
		assertEquals(letter.getText(), expectedText);

		
		letter = LetterBuilder.getAdvertisingLetter(sender, destinatary, addressSender, addressDestiny, date);
		expectedText = "10/10/2017\n" + 
				"\n" + 
				"Sr. Sender\n" + 
				"Rua sender add\n" + 
				"Sr. DestinaryRua destiny add\n" + 
				"Dear   Sr. Destinary\n" + 
				"             Have a nice week\n";
		assertEquals(letter.getText(), expectedText);
		
		letter = LetterBuilder.getRomanticLetter(sender, destinatary, addressSender, addressDestiny, date);
		expectedText = "My darling\n" + 
				"I love you \n" + 
				"\n" + 
				"\n" + 
				"                 With all my love\n";
		assertEquals(letter.getText(), expectedText);
	}
	
}
