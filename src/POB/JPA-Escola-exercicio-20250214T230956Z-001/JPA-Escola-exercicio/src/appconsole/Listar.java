/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Prof. Fausto Maranh�o Ayres
 **********************************/

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import modelo.Aluno;
import Turma;

public class Listar {
	private EntityManager manager;

	public Listar() {
		try {
			manager = Util.conectarBanco();

			System.out.println("\nListagem de alunos:");
			TypedQuery<Aluno> query = manager.createQuery("select a from Aluno a order by a.matricula", Aluno.class);
			List<Aluno> resultados1 = query.getResultList();
			for (Aluno a : resultados1) {
				System.out.println(a);
			}

			System.out.println("\nListagem de turmas:");
			TypedQuery<Turma> query1 = manager.createQuery("select t from Turma t order by t.id", Turma.class);
			List<Turma> resultados2 = query1.getResultList();
			for (Turma t : resultados2) {
				System.out.println(t);
			}

		} catch (Exception e) {
			System.out.println("excecao=" + e.getMessage());
		}
		Util.fecharBanco();

	}

	// =================================================
	public static void main(String[] args) {
		new Listar();
	}
	// =================================================

}
