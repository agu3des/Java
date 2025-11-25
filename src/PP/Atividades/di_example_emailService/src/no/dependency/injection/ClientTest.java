package di_example_emailService.src.no.dependency.injection;

public class ClientTest {
	public static void main(String[] args) {
		
		Notification appE = new EmailService();
		appE.sendNotification("Ola Alex! Mostra um exemplo de DI no Email.", "alex@ifpb.edu.br");

		Notification appS = new SmsService();
		appS.sendNotification("Ola Alex! Mostra um exemplo de DI no Sms.", "alex@ifpb.edu.br");

	}
}
