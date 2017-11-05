package v2;

public class Main {
	
	public static void main(String [] args) {
		MyApplication app = new MyApplication();
		EmailService email = new EmailService();
		app.processMessages("mensagem", "person", email);
		
		SMSService sms = new SMSService();
		app.processMessages("mensagem", "person", sms);
	}
	
}
