package appconsole;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POO
 * Prof. Fausto Maranhão Ayres
 **********************************/

import regras_negocio.Fachada;

public class Apagar {

	public  Apagar(){
		System.out.println("\n------------APAGAR-----------------");
		try {
			Fachada.apagarProduto("arroz"); 
			System.out.println("arroz apagado");
		}
		catch (Exception e) {
			System.out.println("==>"+ e.getMessage());
		}
	}

	//  ***********************************************
	public static void main (String[] args)   
	//  ***********************************************
	{
		new Apagar();

	}

}
