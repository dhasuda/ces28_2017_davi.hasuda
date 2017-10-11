package Lab3;

public class LetterBuilder {

	public static Letter getCommercialLetter(Person sender, Person destinatary, Address addressSender, Address addressDestiny, Date date) {
		Letter letter = new Letter(sender, destinatary, addressSender, addressDestiny, date);
		
		letter.addParagraph(new CommercialHeader());
		letter.addParagraph(new CommercialBody());
		letter.addParagraph(new CommercialConclusion());
		letter.addParagraph(new CommercialSignature());
		
		return letter;
	}
	
	public static Letter getRomanticLetter(Person sender, Person destinatary, Address addressSender, Address addressDestiny, Date date) {
		Letter letter = new Letter(sender, destinatary, addressSender, addressDestiny, date);
		
		letter.addParagraph(new LoveHeader());
		letter.addParagraph(new LoveBody());
		letter.addParagraph(new LoveConclusion());
		
		return letter;
	}
	
	public static Letter getAdvertisingLetter(Person sender, Person destinatary, Address addressSender, Address addressDestiny, Date date) {
		Letter letter = new Letter(sender, destinatary, addressSender, addressDestiny, date);
		
		letter.addParagraph(new CommercialHeader());
		letter.addParagraph(new CommercialBody());
		letter.addParagraph(new AdvertisingConclusion());
		
		return letter;
	}
	
}
