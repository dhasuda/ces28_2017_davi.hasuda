package v3;

public class FacebookServiceImpl implements MessageService {

	@Override
	public void sendMessage(String msg, String rec) {
		System.out.println("Facebook message sent to " + rec + " with Message=" + msg);
	}

}
