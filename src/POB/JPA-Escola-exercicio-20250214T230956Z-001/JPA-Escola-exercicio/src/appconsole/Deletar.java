/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Prof. Fausto Maranh�o Ayres
 **********************************/


import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import Turma;

public class Deletar {
	private EntityManager manager;

	public Deletar() {
		try {
			manager = Util.conectarBanco();
			
			manager.getTransaction().begin();
			
			System.out.println("localizar turma 2023-2");
			TypedQuery<Turma> query = manager.createQuery("select t from Turma t where t.periodo = :per ", Turma.class);
			query.setParameter("per", "2023-2");
			Turma turma = query.getSingleResult();
			System.out.println(turma);
			
			System.out.println("Apagar os alunos da turma 2024-1 (sem apagar a turma)");
			
			turma.getAlunos().clear();
			
			manager.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("excecao=" + e.getMessage());
		}
		
		Util.fecharBanco();
		System.out.println("\nfim da aplica��o");

	}

	// =================================================
	public static void main(String[] args) {
		new Deletar();
	}
	// =================================================

}
