package CursoJava;

import java.util.Scanner;

public class DadosTeclado {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        /*String nome = scan.next(); //ler oq foi colocado e virar str
        int idade = scan.nextInt(); //inteiro
        double altura = scan.nextDouble(); //double*/
        
		/*
		 * System.out.println("Digite seu nome completo: "); 
		 * String nomeCompleto = scan.nextLine(); 
		 * System.out.println("Seu nome completo é: "+nomeCompleto);
		 * 
		 * System.out.println("Digite seu primeiro nome: "); 
		 * String primeiroNome = scan.next(); 
		 * System.out.println("Seu primeiro nome é: "+primeiroNome);
		 * 
		 * System.out.println("Digite sua idade: "); 
		 * int idade = scan.nextInt();
		 * System.out.println("Sua idade é: "+idade);
		 * 
		 * System.out.println("Digite sua altura: "); 
		 * double altura = scan.nextDouble();
		 * System.out.println("Sua altura é: "+altura);
		 */
        
        System.out.println("Digite seu primeiro nome, idade, altura, quantos filhos e se tem pet: ");
        
        String primeiroNome = scan.next();
        int idade = scan.nextInt();
        float altura = scan.nextFloat();
        byte qtdFilhos = scan.nextByte();
        boolean temPet = scan.nextBoolean();
        
        System.out.println("Você digitou os seguintes valores:");
        System.out.println("Primeiro Nome: "+primeiroNome);
        System.out.println("Idade: "+idade);
        System.out.println("Altura: "+altura);
        System.out.println("Quantidade de Filhos: "+qtdFilhos);
        System.out.println("Tem pet: "+temPet);
    }
}

