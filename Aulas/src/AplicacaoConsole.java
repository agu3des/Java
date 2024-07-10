
/*
 * IFPB - TSI - POO - PROJETO1
 *  
 * Aplica��o console para testar a classe Tradutor
 * 
 */
import java.util.ArrayList;
import java.util.Scanner;

public class AplicacaoConsole {
	private Tradutor tradutor;
	private Scanner teclado;
	private String palavra;
	private ArrayList<String> palavras; // posicoes adivinhadas

	public AplicacaoConsole() {
		try {
			tradutor = new Tradutor();
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		teclado = new Scanner(System.in);

		//loop de leituras
		int opcao=0;
		do {
			System.out.println("********************************");
			System.out.println("0 - sair");
			System.out.println("1 - traduzir para portugues");
			System.out.println("2 - traduzir para ingles");
			System.out.println("********************************");
			System.out.println("\ndigite a opcao: " );
			opcao = Integer.parseInt(teclado.nextLine());

			switch (opcao) {
			case 0: {} break;
			case 1: 
				try {
					System.out.println("\ndigite uma palavra em ingles: " );
					palavra = teclado.nextLine();
					palavras = tradutor.toPortugues(palavra);
					if (palavras.size() > 0) 
						System.out.println("traducao =" + palavras.toString());
					else 
						System.out.println("palavra nao encontrada no dicionario");

				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2: 
				try {
					System.out.println("\ndigite uma palavra em portugues: " );
					palavra = teclado.nextLine();
					palavras = tradutor.toIngles(palavra);
					if (palavras.size() > 0) 
						System.out.println("traducao =" + palavras.toString());
					else 
						System.out.println("palavra nao encontrada no dicionario");
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			default:
				System.out.println("opcao incorreta: " + opcao);
			}
		}while (opcao != 0);

		teclado.close();
		System.out.println("fim do programa");
	}

	public static void main(String[] args) {
		AplicacaoConsole app = new AplicacaoConsole();
	}
}
