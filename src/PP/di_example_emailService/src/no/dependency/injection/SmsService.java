package di_example_emailService.src.no.dependency.injection;

public class SmsService  implements Notification {

    @Override
	public void sendNotification(String message, String receiver){
		// Neste ponto teríamos a lógica (conjunto de instruções) para enviar um email
		System.out.println("Sms sent to "+receiver+ " with Message="+message);
	}
}
