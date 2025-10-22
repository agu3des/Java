/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Persistencia de Objetos
 * Prof. Fausto Maranh�o Ayres
 **********************************/

import java.util.List;

import jakarta.persistence.EntityManager;
import modelo.Produto;
import Venda;
import regras_negocio.Fachada;

public class Listar {
	protected static EntityManager manager;

	public Listar(){
		Fachada.inicializar();

		System.out.println("-----------listagem de Produtos-----------");
		List<Produto> produtos = Fachada.listarProdutos();
		for (Produto p : produtos) {
			System.out.println(p);
		}

		System.out.println("\n-----------listagem de Vendas-----------");
		List<Venda> vendas = Fachada.listarVendas();
		for (Venda v : vendas) {
			System.out.println(v);
		}

		Fachada.finalizar();
		System.out.println("FIM");
	}

	//=================================================
	public static void main(String[] args) {
		new Listar();
	}
	//=================================================

}
