/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Persistencia de Objetos
 * Prof. Fausto Maranh�o Ayres
 **********************************/

import jakarta.persistence.EntityManager;
import regras_negocio.Fachada;

public class Cadastrar {
	protected static EntityManager manager;


	public Cadastrar(){
		try {
			Fachada.inicializar();
			Fachada.criarProduto("tv", 1000.0, 30);  //nome, preco e estoque
			Fachada.criarProduto("geladeira", 2000.0, 30);
			Fachada.criarProduto("fogao", 500.0, 30);
			System.out.println("Cadastrou produtos.");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		Fachada.finalizar();
		System.out.println("Fim do programa");
	}


	//=================================================
	public static void main(String[] args) {
		new Cadastrar();
	}
	//=================================================

}
