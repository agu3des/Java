package di_example_emailService.src.no.dependency.injection;

/**
 * Classe contém a lógica para enviar uma mensagem de e-mail para o endereço de e-mail do destinatário.
 * @author alexs
 *
 */
public class EmailService implements Notification {
	
	@Override
	public void sendNotification(String message, String receiver){
		// Neste ponto teríamos a lógica (conjunto de instruções) para enviar um email
		System.out.println("Email sent to "+receiver+ " with Message="+message);
	}
}
