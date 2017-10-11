package Lab3;

import java.util.ArrayList;
import java.util.List;

public class Letter {
	private List<Paragraph> paragraphs = new ArrayList<Paragraph>();	
	private Date date;
	private Person sender;
	private Person destinatary;
	private Address addressSender;
	private Address addressDestiny;
	
	public Letter(Person sender, Person destinatary, Address addressSender, Address addressDestiny, Date date) {
		this.date = date;
		this.sender = sender;
		this.destinatary = destinatary;
		this.addressSender = addressSender;
		this.addressDestiny = addressDestiny;
	}
	
	public void addParagraph(Paragraph p) {
		p.setParameters(sender, destinatary, addressSender, addressDestiny, date);
		paragraphs.add(p);
	}
	
	public String getText() {
		String text = "";
		for (Paragraph p : paragraphs) {
			text += p.getString();
		}
		return text;
	}
}
