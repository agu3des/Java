/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Prof. Fausto Maranh�o Ayres
 **********************************/

import jakarta.persistence.EntityManager;
import modelo.Aluno;
import Turma;

public class Cadastrar {
	private EntityManager manager;

	public Cadastrar() {
		try {
			manager = Util.conectarBanco();
			System.out.println("Cadastrando alunos e turmas...");
			
			Aluno a1, a2, a3, a4, a5, a6;
			a1 = new Aluno("20211370001", "joao", 7.5);
			a2 = new Aluno("20211370002", "jose", 8.0);
			a3 = new Aluno("20211370003","maria", 10.0);
			a4 = new Aluno("20211370004", "pedro", 6.0);
			a5 = new Aluno("20211370005", "paulo", 10.0);
			a6 = new Aluno("20211370006", "ana", 8.0);
			
			Turma t1, t2, t3;
			t1 = new Turma("2023-1");
			t2 = new Turma("2023-2");
			t3 = new Turma("2024-1");

			t1.adicionar(a1);
			t1.adicionar(a2);
			t2.adicionar(a3);
			t2.adicionar(a4);
			t3.adicionar(a5);
			
			manager.getTransaction().begin();
			manager.persist(t1);
			manager.getTransaction().commit();

			manager.getTransaction().begin();
			manager.persist(t2);
			manager.getTransaction().commit();
			
			manager.getTransaction().begin();
			manager.persist(t3);
			manager.getTransaction().commit();
			
			manager.getTransaction().begin();
			manager.persist(a6);
			manager.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("excecao=" + e.getMessage());
		}

		Util.fecharBanco();
		System.out.println("\nfim da aplica��o");
	}

	// =================================================
	public static void main(String[] args) {
		new Cadastrar();
	}
	// =================================================

}
