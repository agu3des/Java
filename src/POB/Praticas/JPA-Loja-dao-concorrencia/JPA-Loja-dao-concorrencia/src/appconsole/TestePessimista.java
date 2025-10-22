/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Persistencia de Objetos
 * Prof. Fausto Maranh�o Ayres
 **********************************/

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.LockModeType;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import modelo.Produto;
import Venda;

public class TestePessimista {

	public TestePessimista() {
		EntityManagerFactory factory1 = Persistence.createEntityManagerFactory("hibernate-postgresql");
		EntityManagerFactory factory2 = Persistence.createEntityManagerFactory("hibernate-postgresql");
		EntityManager manager1 = factory1.createEntityManager();
		EntityManager manager2 = factory2.createEntityManager();

		Runnable tarefa1 = () -> {
			try {
				System.out.println("tarefa1 - inicio");
				manager1.getTransaction().begin();
				TypedQuery<Produto> q1 = manager1.createQuery("select p from Produto p where p.nome = :x",
						Produto.class);
				q1.setParameter("x", "tv");

				// ***********************************************
				q1.setLockMode(LockModeType.PESSIMISTIC_WRITE); // bloqueio no banco
				// ***********************************************

				Produto p1 = q1.getSingleResult();
				System.out.println("\ntarefa1 - leu produto " + p1);

				Venda v1 = new Venda("joao", p1);
				manager1.persist(v1);
				Thread.sleep(3000);

				manager1.getTransaction().commit();
				System.out.println("tarefa1 - comitou venda produto: " + p1);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			System.out.println("tarefa1 - fim\n");

		};

		Runnable tarefa2 = () -> {
			try {
				System.out.println("tarefa2 - inicio");
				manager2.getTransaction().begin();
				TypedQuery<Produto> q2 = manager2.createQuery("select p from Produto p where p.nome = :x",
						Produto.class);
				q2.setParameter("x", "tv");

				// ***********************************************
				q2.setLockMode(LockModeType.PESSIMISTIC_WRITE); // bloqueio no banco
				// ***********************************************

				Produto p2 = q2.getSingleResult();
				System.out.println("\ntarefa2 * leu produto " + p2);

				Venda v2 = new Venda("maria", p2);
				manager2.persist(v2);
				Thread.sleep(3000);

				manager2.getTransaction().commit();
				System.out.println("tarefa2 * comitou venda produto: " + p2);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			System.out.println("tarefa2 - fim\n");
		};

		// inicio
		Thread thread1 = new Thread(tarefa1);
		Thread thread2 = new Thread(tarefa2);
		thread1.start();
		thread2.start();

	}

	// =================================================
	public static void main(String[] args) {
		new TestePessimista();
	}
	// =================================================

}
