/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Prof. Fausto Maranh�o Ayres
 **********************************/


import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import modelo.Aluno;
import Turma;

public class Consultar {
	protected EntityManager manager;

	public Consultar() {
		try {
			manager = Util.conectarBanco();
			
			TypedQuery<Aluno> query1 ;
			TypedQuery<Turma> query2 ;
			List<Aluno> alunos;
			List<Turma> turmas;
			String jpql;

			System.out.println("\n---quais os alunos da turma 2023-1 ?");
			jpql = "select a from Aluno a where a.turma.periodo='2023-1' ";
			query1 = manager.createQuery(jpql, Aluno.class);
			alunos = query1.getResultList();
			for (Aluno a : alunos)
				System.out.println(a);
			
			System.out.println("\n---quais os alunos sem turma ?");
			jpql = "select a from Aluno a where a.turma is null";
			query1 = manager.createQuery(jpql, Aluno.class);
			alunos = query1.getResultList();
			for (Aluno a : alunos)
				System.out.println(a);
			
			System.out.println("\n---quais as turmas que tem aluno com media 10 ?");
			jpql = "select t from Turma t JOIN t.alunos a where a.media = 10";
			query2 = manager.createQuery(jpql, Turma.class);
			turmas = query2.getResultList();
			for (Turma t : turmas)
				System.out.println(t);

			System.out.println("\n---qual a turma do aluno 20211370002 ?");
			jpql = "select t from Turma t JOIN t.alunos a where a.matricula = '20211370002'";
			query2 = manager.createQuery(jpql, Turma.class);
			turmas = query2.getResultList();
			for (Turma t : turmas)
				System.out.println(t);
			
			System.out.println("\n---quais as turmas que tem dois alunos");
			jpql = "select t from Turma t where size(t.alunos) = 2";
			query2 = manager.createQuery(jpql, Turma.class);
			turmas = query2.getResultList();
			for (Turma t : turmas)
				System.out.println(t);
			
			System.out.println("\n---quais as turmas que nao tem alunos");
			jpql = "select t from Turma t where t.alunos is empty";
			query2 = manager.createQuery(jpql, Turma.class);
			turmas = query2.getResultList();
			for (Turma t : turmas)
				System.out.println(t);
			
		} catch (Exception e) {
			System.out.println("excecao=" + e.getMessage());
		}
		Util.fecharBanco();
		System.out.println("\nfim da aplica��o");
	}

	// =================================================
	public static void main(String[] args) {
		new Consultar();
	}
}
