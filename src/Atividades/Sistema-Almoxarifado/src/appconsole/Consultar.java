package appconsole;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POO
 * Prof. Fausto Maranhão Ayres
 **********************************/

import modelo.Prateleira;
import modelo.Produto;
import regras_negocio.Fachada;

public class Consultar {

	public Consultar(){
		System.out.println("\n------------CONSULTAS AVANÇADAS-----------------");

		System.out.println("\nListagem de prateleiras vazias:");
		for(Prateleira pt: Fachada.listarPrateleirasVazias()) 
			System.out.println(pt);


		System.out.println("\nListagem de prateleiras com 2 produtos:");
		for(Prateleira pt: Fachada.listarPrateleirasNProdutos(2)) 
			System.out.println(pt);


		System.out.println("\nListagem de produtos sem prateleira");
		for(Produto p: Fachada.listarProdutosSemPrateleira())
			System.out.println(p.getNome());
	}


	//  ***********************************************
	public static void main (String[] args)   
	//  ***********************************************
	{
		new Consultar();

	}

}
