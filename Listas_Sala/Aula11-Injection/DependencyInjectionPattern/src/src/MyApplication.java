package src;

public class MyApplication {
	public void processMessages(String message, String receiver) {
		// Do some msg validation, manipulation logic etc.
		_email.sendEmail(message, receiver);
	}
	private EmailService _email = new EmailService();
}
