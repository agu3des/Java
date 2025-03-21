/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Prof. Fausto Maranh�o Ayres
 **********************************/


import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import modelo.Aluno;
import Turma;

public class Alterar {
	private EntityManager manager;

	public Alterar() {
		try {
			manager = Util.conectarBanco();

			// --------------------------------------
			// transferir joao para a turma de paulo
			// --------------------------------------
			
			manager.getTransaction().begin();
			
			System.out.println("Localizando joao e paulo...");
			TypedQuery<Aluno> query;
			query = manager.createQuery("select a from Aluno a where a.nome='joao' ", Aluno.class);
			Aluno joao =  query.getSingleResult();
			System.out.println(joao);

			query = manager.createQuery("select a from Aluno a where a.nome='paulo' ", Aluno.class);
			Aluno paulo = query.getSingleResult();
			System.out.println(paulo);

			Turma turmapaulo = paulo.getTurma();
			Turma turmajoao = joao.getTurma();
			turmajoao.remover(joao);
			turmapaulo.adicionar(joao);
			joao.setTurma(turmapaulo);			//relacionamento bidirecional
			manager.getTransaction().commit();
			
			System.out.println("Transferencia concluida...");
			System.out.println("\nLocalizando joao e paulo...");
			query = manager.createQuery("select a from Aluno a where a.nome='joao' ", Aluno.class);
			joao =  query.getSingleResult();
			System.out.println(joao);

			query = manager.createQuery("select a from Aluno a where a.nome='paulo' ", Aluno.class);
			paulo = query.getSingleResult();
			System.out.println(paulo);

		} catch (Exception e) {
			System.out.println("excecao=" + e.getMessage());
		}
		
		Util.fecharBanco();
		System.out.println("\nfim da aplica��o");

	}

	// =================================================
	public static void main(String[] args) {
		new Alterar();
	}
	// =================================================

}
