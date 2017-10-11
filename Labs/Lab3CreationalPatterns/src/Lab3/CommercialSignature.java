package Lab3;


public class CommercialSignature extends Paragraph {

	@Override
	public String getString() {
		return "\n\n__________________\n " + sender.getPhone() +
				 sender.getName() + "\n" +
				 "\n                                    email:"   +   sender.getEmail();
	}

}
