package Lab3Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Lab3.Date;
import Lab3.Address;
import Lab3.LetterBuilder;
import Lab3.Person;
import Lab3.Letter;

public class Exercicio1 {

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
	public void test() {
		Letter letter = LetterBuilder.getCommercialLetter(sender, destinatary, addressSender, addressDestiny, date);
		String expectedText = "10/10/2017\n" + 
				"\n" + 
				"Sender\n" + 
				"sender add\n" + 
				"Destinarydestiny add\n" + 
				"Dear   Destinary\n" + 
				"\n" + 
				"Sincerely,\n" + 
				"\n" + 
				"\n" + 
				"__________________\n" + 
				" 0000-0000Sender\n" + 
				"\n" + 
				"                                    email:sender@servidor";
		assertEquals(letter.getText(), expectedText);
		
		
		letter = LetterBuilder.getAdvertisingLetter(sender, destinatary, addressSender, addressDestiny, date);
		expectedText = "10/10/2017\n" + 
				"\n" + 
				"Sender\n" + 
				"sender add\n" + 
				"Destinarydestiny add\n" + 
				"Dear   Destinary\n" + 
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
