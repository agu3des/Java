package aplicacao;

/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.query.Query;

import modelo.Autor;
import modelo.Livro;

public class Deletar {
	private ObjectContainer manager;

	public Deletar() {
		manager = Util.conectarBanco();
		apagar();	//ok
		Util.desconectar();

		System.out.println("\n\n aviso: feche sempre o plugin OME antes de executar aplicação");
	}
	
	public void apagar() {
		// apagar livro "c" 
		Query q = manager.query();
		q.constrain(Livro.class);
		q.descend("titulo").constrain("c");
		List<Livro> resultados = q.execute();

		if (resultados.size() > 0) {
			Livro c = resultados.get(0);
			
			//remover o livro dos seus autores
			for(Autor a : c.getAutores()) {
				a.remover(c);
				manager.store(a);
				
				//apagar o autor que esta orfao
				if(a.getLivros().isEmpty())
					manager.delete(a);
			}
			
			manager.delete(c);		//apagar o livro
			manager.commit();
			System.out.println("apagou livro e os autores orfaos");
		} else
			System.out.println("inexistente");
	}

	
	// =================================================
	public static void main(String[] args) {
		new Deletar();
	}
}
