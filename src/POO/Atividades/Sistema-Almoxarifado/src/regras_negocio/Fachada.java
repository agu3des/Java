/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POO - Programação Orientada a Objetos
 * Prof. Fausto Ayres
 *
 */
package regras_negocio;

import java.util.ArrayList;

import modelo.Prateleira;
import modelo.Produto;
import repositorio.Repositorio;

public class Fachada {
	private static Repositorio repositorio = new Repositorio();

	private Fachada() {}

	public static ArrayList<Produto> listarProdutos() {
		return repositorio.getProdutos();
	}
	public static ArrayList<Prateleira> listarPrateleiras() {
		return repositorio.getPrateleiras();
	}

	public static void criarProduto(String nome, double preco) throws Exception {
		Produto p = repositorio.localizarProduto(nome);
		if (p != null)
			throw new Exception("criar produto - produto ja cadastrado:" + nome);

		if (preco <= 0)
			throw new Exception("criar produto - preco invalido");

		p = new Produto(nome, preco);
		repositorio.adicionar(p);
		repositorio.salvarObjetos();
	}

	public static void criarPrateleira(double tam) throws Exception {
		if (tam <= 0)
			throw new Exception("criar prateleira - tamanho invalido");

		int id = repositorio.gerarIdPrateleira();
		Prateleira p = new Prateleira(id, tam);
		repositorio.adicionar(p);
		repositorio.salvarObjetos();
	}

	public static void inserirProdutoPrateleira(int id, String nome) throws Exception {
		Prateleira pt = repositorio.localizarPrateleira(id);
		if (pt == null)
			throw new Exception("inserir produto  - prateleira inexistente:" + id);

		Produto p = repositorio.localizarProduto(nome);
		if (p == null)
			throw new Exception("inserir produto  - produto inexistente:" + nome);

		if (p.getPrateleira() != null)
			throw new Exception(
					"inserir produto  - produto " + nome + " ja tem prateleira " + p.getPrateleira().getId());

		pt.adicionar(p); // bidirecional
		repositorio.salvarObjetos();
	}

	public static void removerProdutoPrateleira(String nome) throws Exception {
		Produto p = repositorio.localizarProduto(nome);
		if (p == null)
			throw new Exception("remover produto  - produto inexistente:" + nome);

		Prateleira pt = p.getPrateleira(); // acessa a Prateleira do produto
		if (pt == null)
			throw new Exception("remover produto - produto sem prateleira:" + nome);

		pt.remover(p); // remove os dois lados
		repositorio.salvarObjetos();
	}

	public static void apagarProduto(String nome) throws Exception {
		nome = nome.trim();
		Produto p = repositorio.localizarProduto(nome);
		if (p == null)
			throw new Exception("apagar produto - produto inexistente:" + nome);

		Prateleira pt = p.getPrateleira();
		if (pt != null)
			pt.remover(p); // remove os dois lados

		repositorio.remover(p);
		repositorio.salvarObjetos();
	}

	public static void apagarPrateleira(int id) throws Exception {
		Prateleira pt = repositorio.localizarPrateleira(id);
		if (pt == null)
			throw new Exception("apagar prateleira - prat. inexistente:" + id);

		if (!pt.getProdutos().isEmpty())
			throw new Exception("apagar prateleira -  prateleira nao esta vazia:" + id);

		for (Produto p : pt.getProdutos()) {
			p.setPrateleira(null);
		}
		repositorio.remover(pt);
		repositorio.salvarObjetos();
	}

	public static void esvaziarPrateleira(int id) throws Exception {
		//falta implementar
	}

	/*******************************
	 * CONSULTAS AVANÇADAS
	 *******************************/

	public static ArrayList<Prateleira> listarPrateleirasVazias() {
		ArrayList<Prateleira> lista = new ArrayList<>();
		for (Prateleira pt : repositorio.getPrateleiras())
			if (pt.getTotalProdutos() == 0)
				lista.add(pt);
		
		return lista;
	}

	public static ArrayList<Produto> listarProdutosSemPrateleira() {
		ArrayList<Produto> lista = new ArrayList<Produto>();
		for (Produto p : repositorio.getProdutos())
			if (p.getPrateleira() == null)
				lista.add(p);

		return lista;
	}

	public static ArrayList<Prateleira> listarPrateleirasNProdutos(int n) {
		ArrayList<Prateleira> lista = new ArrayList<Prateleira>();
		for (Prateleira pt : repositorio.getPrateleiras())
			if (pt.getTotalProdutos() == n)
				lista.add(pt);

		return lista;
	}

	public static Prateleira obterPrateleiraDoProduto(String nome) throws Exception {
		Produto p = repositorio.localizarProduto(nome);
		if (p == null)
			throw new Exception("produto inexistente:" + nome);

		return p.getPrateleira();
	}

}// classe
