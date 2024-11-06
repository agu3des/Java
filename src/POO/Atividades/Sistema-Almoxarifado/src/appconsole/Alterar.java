package appconsole;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POO
 * Prof. Fausto Maranhão Ayres
 **********************************/

import regras_negocio.Fachada;

public class Alterar {

	public Alterar(){
		System.out.println("\n------------INSERIR/REMOVER-------------");
		try{
			Fachada.inserirProdutoPrateleira(1, "arroz");
			Fachada.inserirProdutoPrateleira(1, "feijao");
			Fachada.inserirProdutoPrateleira(2, "leite");	
			Fachada.inserirProdutoPrateleira(3, "carne");	
			Fachada.removerProdutoPrateleira("carne");
			System.out.println("alteração concluida");
		}
		catch (Exception e) {
			System.out.println("==>"+ e.getMessage());
		}
	}


	//  ***********************************************
	public static void main (String[] args)   
	//  ***********************************************
	{
		new Alterar();

	}

}
