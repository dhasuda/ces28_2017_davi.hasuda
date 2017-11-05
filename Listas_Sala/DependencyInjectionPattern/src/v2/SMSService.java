package v2;

public class SMSService implements MessageService {

	public void sendMessage(String message, String receiver) {
			System.out.println("SMS sent to "+ receiver);
			System.out.println("----------------------------------");
			System.out.println("Message: " + message);
		
	}

}
