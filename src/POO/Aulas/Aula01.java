/*
import java.awt.Desktop;
import java.net.URI;
import java.net.URL;


public class Browser {
	public static void main(String[] args) {
		try {
	           URI uri = new URL("https://www.ifpb.edu.br/joaopessoa").toURI();

	           Desktop.getDesktop().browse(uri);
	       }
	       catch (Exception e) {
	           System.out.println("problema na url");
	       }
	}
}


import java.util.Scanner;

public class Amigo {
	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		System.out.println("Qual é o seu nome?");
		String nome1 = teclado.nextLine();
		System.out.println(nome1+", de quem vc é amigo?");
		String nome2 = teclado.nextLine();
		System.out.println(nome1 +" é amigo de "+ nome2);
		teclado.close();

	}

}*/

/* import javax.swing.JOptionPane;
public class Amigo2 {
	public static void main(String[] args){
		String nome1 = JOptionPane.showInputDialog( //onde usava teclado usa diretamente o windows
		"Qual é o seu nome?");
		String nome2 = JOptionPane.showInputDialog(
		nome1 + ", de quem vc é amigo?");
		JOptionPane.showMessageDialog(null,
		nome1 +" é amigo de "+ nome2);
	}
}*/

/*public static void main(...) {
	int a=2; //a é global
	if (a > 0) {
		int b=3; //b é local
		a=4;
		System.out.println(a+b); //7
	}
	System.out.println(a); //4
	System.out.println(b); //inacessível
}*/
