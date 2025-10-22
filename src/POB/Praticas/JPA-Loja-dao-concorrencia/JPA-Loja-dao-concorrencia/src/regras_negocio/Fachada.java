/**IFPB - Curso SI - Disciplina de PERSISTENCIA DE OBJETOS
 * @author Prof Fausto Ayres
 */

import java.util.List;

import DAO;
import DAOProduto;
import DAOVenda;
import jakarta.persistence.OptimisticLockException;
import modelo.Produto;
import Venda;

public class Fachada {
	private static DAOProduto daoproduto = new DAOProduto();
	private static DAOVenda daovenda = new DAOVenda();

	public static void inicializar() {
		DAO.open();
	}

	public static void finalizar() {
		DAO.close();
	}

	public static Produto criarProduto(String nome, double preco, int estoque) throws Exception {
		DAO.begin();
		Produto p = daoproduto.read(nome);
		if (p != null) {
			DAO.rollback();
			throw new Exception("produto ja existe");
		}

		p = new Produto(nome, preco, estoque);
		daoproduto.create(p);
		DAO.commit();
		return p;
	}

	public static Produto reporProduto(String nome, int estoque) throws Exception {
		DAO.begin();
		Produto p = daoproduto.read(nome);
		if (p == null) {
			DAO.rollback();
			throw new Exception("produto nao existe");
		}

		p.setEstoque(estoque);
		//daoproduto.update(p);
		DAO.commit();
		return p;
	}

	public static Venda criarVendaOtimista(String vendedor, String nome) throws Exception {
		try {
			DAO.begin();
			Produto p = daoproduto.read(nome); // sem bloqueio

			if (p == null) {
				DAO.rollback();
				throw new Exception("produto nao existe");
			}

			if (p.getEstoque() == 0) { // considera-se o estique lido inicialmente
				DAO.rollback();
				throw new Exception("produto com estoque esgotado");
			}

			Venda v = new Venda(vendedor, p);
			p.baixarEstoque();
			daovenda.create(v);

			Thread.sleep(4000); // pausa no processamento 4 seg
			DAO.commit();
			return v;
		} catch (Exception e) {
			if (e.getCause() instanceof OptimisticLockException) {
				throw new Exception("transa��o cancelada  -  produto alterado na outra transacao ");
			} else {
				throw e;
			}
		}
	}

	public static Venda criarVendaPessimista(String vendedor, String nome) throws Exception {
		try {
			DAO.begin();
			Produto p = daoproduto.readLock(nome);

			if (p == null) {
				DAO.rollback();
				throw new Exception("produto nao existe");
			}

			if (p.getEstoque() == 0) {
				DAO.rollback();
				throw new Exception("produto com estoque esgotado");
			}

			Venda v = new Venda(vendedor, p);
			daovenda.create(v); // criar venda e baixar estoque do produto
			Thread.sleep(4000); // pausa no processamento 4 seg
			DAO.commit();

			System.out.println("comitou=" + p);
			return v;
		} catch (Exception e) {
			if (e.getCause() instanceof org.hibernate.StaleObjectStateException) {
				throw new Exception("transa��o cancelada ");
			}
			else {
				throw e;
			// timeout gerado pelo postgresql
			// if(ex.getMessage().contains("canceling statement due to lock timeout"))
			// return new Exception("lock-timeout do postgres expirado - venda cancelada");
			}
		}
	}

	public static Produto localizarProduto(String nome) {
		return daoproduto.read(nome);
	}

	public static List<Produto> listarProdutos() {
		// a leitura deve ser transacional devido a concorrencia
		DAO.begin();
		List<Produto> result = daoproduto.readAll();
		DAO.commit();

		return result;
	}

	public static List<Venda> listarVendas() {
		// a leitura deve ser transacional devido a concorrencia
		DAO.begin();
		List<Venda> result = daovenda.readAll();
		DAO.commit();

		return result;
	}

}
