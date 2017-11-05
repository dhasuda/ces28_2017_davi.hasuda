package v1;

public class MyApplication {
	public void processMessages(String message, String receiver, EmailService email) {
		// Do some msg validation, manipulation logic etc.
		email.sendEmail(message, receiver);
	}
	
}
