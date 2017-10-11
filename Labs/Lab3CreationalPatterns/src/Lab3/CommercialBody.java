package Lab3;


public class CommercialBody extends Paragraph {

	@Override
	public String getString() {
		return   "Dear   " + destinatary.getName() + "\n";
	}

}
