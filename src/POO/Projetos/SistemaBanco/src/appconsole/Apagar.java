package appconsole;


import regras_negocio.Fachada;

public class Apagar {

	public Apagar() {
		try {
//			//teste para: saldo != 0 /  apagar conta e não apagar o correntista
//			Fachada.apagarConta(4);
			
			//remover correntistas associados
			Fachada.apagarConta(5);
			
			
			System.out.println("Apagou");

		} catch (Exception e) {
			System.out.println("--->" +e.getMessage());
		}
	}

	public static void main(String[] args) {
		new Apagar();
	}
}
