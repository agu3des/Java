import java.util.Arrays;

public class Array{
	public static void main(String args[]){
		int[] numeros = new int[4] ;
		numeros[0] = 8;
		numeros[1] = 2;
		numeros[2] = 9;
		numeros[3] = 2;
		//int[] numeros = {8,2,9,2};
		System.out.println(numeros.length);
		System.out.println(numeros[0]);
		System.out.println(numeros[3]);
		System.out.println(numeros[2]);
		
		for(int i=0; i < numeros.length; i++)
			System.out.println(numeros[i]); //for tradicional
		for(int n : numeros)
			System.out.println(n); //for-each
		
		int[] numbers = {8, 5, 30};
		for(int i=0; i<numbers.length; i++)
			numbers[i] = 2*numbers[i];
		for(int n : numbers)
			System.out.println(n); //limitado
		
		System.out.println(Arrays.toString(numeros));
		Arrays.sort(numeros);
		System.out.println(Arrays.toString(numeros));
	}
}