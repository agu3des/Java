/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Persistencia de Objetos
 * Prof. Fausto Maranh�o Ayres
 **********************************/

import jakarta.persistence.EntityManager;
import regras_negocio.Fachada;

public class ReporEstoque {
	protected static EntityManager manager;


	public ReporEstoque(){
		try {
			Fachada.inicializar();
			int estoque=30;
			Fachada.reporProduto("tv", estoque);
			Fachada.reporProduto("geladeira", estoque);
			Fachada.reporProduto("fogao", estoque);
			System.out.println(" estoques atualizados para " + estoque);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		Fachada.finalizar();

	}


	//=================================================
	public static void main(String[] args) {
		new ReporEstoque();
	}
	//=================================================

}
