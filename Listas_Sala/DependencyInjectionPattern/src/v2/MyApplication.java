package v2;

public class MyApplication {
	public void processMessages(String message, String receiver, MessageService service) {
		// Do some msg validation, manipulation logic etc.
		service.sendMessage(message, receiver);
	}
	
}
