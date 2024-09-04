package appconsole;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POO
 * Prof. Fausto Maranhão Ayres
 **********************************/

import modelo.Prateleira;
import modelo.Produto;
import regras_negocio.Fachada;

public class Listar {

	public Listar(){
		System.out.println("\n------------LISTAR-----------------");
		System.out.println("Listagem de produtos:");
		for(Produto p: Fachada.listarProdutos()) 
			System.out.println(p);

		System.out.println("\nListagem de prateleiras:");
		for(Prateleira pt: Fachada.listarPrateleiras()) 
			System.out.println(pt);
	}


	//  ***********************************************
	public static void main (String[] args)   
	//  ***********************************************
	{
		new Listar();

	}

}
