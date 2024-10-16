package calculator;

import java.util.Scanner;

public class CalculatorTeste {
	private calculator calculadora;
	private Scanner scanner;

	public calculatorTeste() {
		calculadora = new calculator();
		
		scanner = new Scanner(System.in);
		
		System.out.println("\ndigite um numero: " );
		double n1 = scanner.nextInt();
		System.out.println("\ndigite um numero: " );
		double n2 = scanner.nextInt();
		calculadora.soma(n1,n2);
		
		scanner.close();
	}

	public static void main(String[] args) {
		calculatorTeste app = new calculatorTeste();
	}
}