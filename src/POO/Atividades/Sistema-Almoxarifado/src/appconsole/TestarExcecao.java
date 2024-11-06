package appconsole;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POO
 * Prof. Fausto Maranh�o Ayres
 **********************************/

import regras_negocio.Fachada;

public class TestarExcecao {

	public static void main (String[] args)  {
		
		System.out.println("\n------------Teste das excecoes do sistema-----------------");
		try {
			Fachada.criarProduto("aaa", 10.0); 
			Fachada.criarProduto("aaa", 10.0); //ja existe
			System.out.println("teste 1 falhou: nao gerou excecao - criar produto");
		}catch (Exception e) {
			System.out.println("1ok==>"+ e.getMessage());
		}
		try {
			Fachada.criarProduto("bbb", 0.0); //preco invalido
			System.out.println("teste 2 falhou: nao gerou excecao - criar produto");
		}catch (Exception e) {
			System.out.println("2ok==>"+ e.getMessage());
		}
	
		try {
			Fachada.criarProduto("ccc", 1.0);
			Fachada.inserirProdutoPrateleira(1, "ccc");	
			Fachada.inserirProdutoPrateleira(1, "ccc");	//ja existe
			System.out.println("teste 3 falhou:  nao gerou excecao - inserir produto");
		}catch (Exception e) {
			System.out.println("3ok==>"+ e.getMessage());
		}
		try {
			Fachada.criarProduto("ddd", 5.0); 
			Fachada.inserirProdutoPrateleira(1, "ddd");	
			Fachada.removerProdutoPrateleira("ddd");	
			Fachada.removerProdutoPrateleira("ddd");	//inexistente
			System.out.println("teste 4 falhou:  nao gerou excecao - remover produto");
		}catch (Exception e) {
			System.out.println("4ok==>"+ e.getMessage());
		}
		try {
			Fachada.criarProduto("eee", 5.0); 
			Fachada.apagarProduto("eee");	
			Fachada.apagarProduto("eee");	//inexistente
			System.out.println("teste 5 falhou:  nao gerou excecao - apagar produto");
		}catch (Exception e) {
			System.out.println("5ok==>"+ e.getMessage());
		}
		
		//apagar dados usados neste teste
		try {Fachada.apagarProduto("aaa");} catch (Exception e) {}
		try {Fachada.apagarProduto("ccc");} catch (Exception e) {}
		try {Fachada.apagarProduto("ddd");} catch (Exception e) {}
	
	}
}
