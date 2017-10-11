package Lab3;


public class CommercialHeader extends Paragraph {
/*	
	public CommercialHeader(Person sender, Person destinatary, Address addressSender, Address addressDestiny, Date date) {
		//super(sender, destinatary, addressSender, addressDestiny, date);
		super();
	}
*/	
	@Override
	public String getString() {
		return   date.toString()   +   "\n\n"   +   sender.getName()   +   
				"\n"   + addressSender.getName()   +   "\n"   +   
				destinatary.getName()   + addressDestiny.getName()   +   "\n";
	}

}
