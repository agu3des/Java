package appconsole;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POO
 * Prof. Fausto Maranhão Ayres
 **********************************/

import regras_negocio.Fachada;

public class Cadastrar {

	public Cadastrar(){
		System.out.println("\n------------CADASTRAR-----------------");
		try {	
			Fachada.criarProduto("arroz", 3.0); 	
			Fachada.criarProduto("feijao", 5.0); 	
			Fachada.criarProduto("leite", 2.0); 	
			Fachada.criarProduto("carne", 30.0); 	
			Fachada.criarProduto("oleo", 10.0); 	
			Fachada.criarPrateleira(200);		
			Fachada.criarPrateleira(300);		
			Fachada.criarPrateleira(400);		
			System.out.println("cadastro concluido");
		}
		catch (Exception e) {
			System.out.println("==>"+ e.getMessage());
		}
	}


	//  ***********************************************
	public static void main (String[] args)   
	//  ***********************************************
	{
		new Cadastrar();

	}

}
