package Lab3;

public abstract class Paragraph {

	protected Date date;
	protected Person sender;
	protected Person destinatary;
	protected Address addressSender;
	protected Address addressDestiny;
	/*
	public Paragraph(Person sender, Person destinatary, Address addressSender, Address addressDestiny, Date date) {
		this.date = date;
		this.sender = sender;
		this.destinatary = destinatary;
		this.addressSender = addressSender;
		this.addressDestiny = addressDestiny;
	}*/
	public Paragraph() {}
	
	public void setParameters(Person sender, Person destinatary, Address addressSender, Address addressDestiny, Date date) {
		this.date = date;
		this.sender = sender;
		this.destinatary = destinatary;
		this.addressSender = addressSender;
		this.addressDestiny = addressDestiny;
	}
	
	abstract public String getString();
}
