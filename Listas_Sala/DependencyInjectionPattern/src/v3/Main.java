package v3;

public class Main {
	
	public static void main(String [] args) {
		EmailServiceInjector emailInj = new EmailServiceInjector();
		Consumer consumer = emailInj.getConsumer();
		consumer.processMessages("message", "receiver");
		
		SMSServiceInjector smsInj = new SMSServiceInjector();
		consumer = smsInj.getConsumer();
		consumer.processMessages("message", "receiver");
		
		// Facebook message
		FacebookServiceInjector face = new FacebookServiceInjector();
		consumer = face.getConsumer();
		consumer.processMessages("message", "receiver");
	}
	
}
/*
 * A injeção de dependência empregada no código é por construtor
 * Se fosse por setter, a Main chamaria uma função setService, dentro de consumer
 * 
 * Vantagens: Código organizado e de fácil reuso
 * 
 * Desvantagens: O número de classe criadas é bastante alto
*/