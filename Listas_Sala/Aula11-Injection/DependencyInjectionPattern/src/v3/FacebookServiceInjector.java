package v3;

public class FacebookServiceInjector implements MessageServiceInjector {
	@Override
	public Consumer getConsumer() {
		return new MyDIApplication(new FacebookServiceImpl());
	}

}
