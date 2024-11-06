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


public class Alterar {
	private ObjectContainer manager;

	public Alterar(){
		manager = Util.conectarBanco();
		atualizar();
		Util.desconectar();
		System.out.println("\n\n aviso: feche sempre o plugin OME antes de executar aplicação");
	}

	public void atualizar(){
		// Alteração1: 
		// decrementar a quantidade de exemplares do livro java
		//*******************************************************
		Query q1 = manager.query();
		q1.constrain(Livro.class);  				
		q1.descend("titulo").constrain("java");		 
		List<Livro> resultados1 = q1.execute(); 

		if(resultados1.size()>0) {
			Livro java = resultados1.get(0);
			//alterar a quantidade de exemplares
			int numero = java.getExemplares();
			java.setExemplares(numero-1);
			
			//atualizar livro no banco
			manager.store(java);
			manager.commit();
			System.out.println("alterou quantidade livro java");
		}
		else
			System.out.println("nao encontrado java");

		
		
		// Alteração2: 
		// remover autor "antonio" do livro  "php" (e vice-versa)
		//*******************************************************
		Query q4 = manager.query();
		q4.constrain(Livro.class);  				
		q4.descend("titulo").constrain("php");		 
		List<Livro> resultados4 = q4.execute(); 

		if(resultados4.size() > 0) {
			Livro php = resultados4.get(0);

			//localizar antonio dentro do livro
			Autor antonio = php.localizar("antonio");	//dentro do livro
			if(antonio != null) {
				//remover antonio do livro e vice-versa
				php.remover(antonio);
				
				//salvar objetos no banco
				manager.store(php);
				manager.store(antonio);
				manager.commit();
				
				//verificar se antonio ficou orfao e apaga-lo
				if(antonio.getLivros().isEmpty()) {
					manager.delete(antonio);
					manager.commit();
				}
				
				//verificar se php ficou orfao e apaga-lo
				if(php.getAutores().isEmpty()) {
					manager.delete(php);
					manager.commit();
				
				}
				System.out.println("removeu antonio de php");
			}
		}
		else
			System.out.println("livro inexistente php");

	}



	//=================================================
	public static void main(String[] args) {
		new Alterar();
	}
}

