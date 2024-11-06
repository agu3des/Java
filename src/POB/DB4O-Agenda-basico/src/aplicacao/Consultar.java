package aplicacao;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.query.Candidate;
import com.db4o.query.Evaluation;
import com.db4o.query.Predicate;
import com.db4o.query.Query;

import modelo.Aluno;
import modelo.Pessoa;
import modelo.Telefone;


public class Consultar {
	private ObjectContainer manager;

	public Consultar(){
		manager = Util.conectarBanco();
		consultar();
		Util.desconectar();
		
		System.out.println("\n\n aviso: feche sempre o plugin OME antes de executar aplicação");
	}

	public void consultar(){
		Query q;
		
		System.out.println("\n---listar pessoas em ordem alfabetica");
		q = manager.query();
		q.constrain(Pessoa.class);  
		q.descend("nome").orderAscending();
		List<Pessoa> pessoas = q.execute();
		for(Pessoa p: pessoas)
			System.out.println(p);
	
		System.out.println("\n---listar pessoas que nasceram no mes 02");
		q = manager.query();
		q.constrain(Pessoa.class);  
		q.descend("dtnascimento").constrain("/02/").contains();
		q.descend("nome").orderAscending();
		pessoas = q.execute();
		for(Pessoa p: pessoas)
			System.out.println(p);
	
		System.out.println("\n---listar pessoas com 2 telefones (filtro)");
		q = manager.query();
		q.constrain(Pessoa.class);  
		q.constrain(new Filtro1(2));
		pessoas = q.execute();
		for(Pessoa p: pessoas)
			System.out.println(p);
		
		System.out.println("\n---listar telefones fixos");
		q = manager.query();
		q.constrain(Telefone.class);  
		q.descend("numero").constrain("3").startsWith(true);
		List<Telefone> telefones = q.execute();
		for(Telefone t: telefones)
			System.out.println(t);
		
		System.out.println("\n---Total de pessoas");
		q = manager.query();
		q.constrain(Pessoa.class);  
		int cont = q.execute().size();
		System.out.println(cont);
		
		//-------------------------------------------
		// Consulta envolvendo Aluno
		//-------------------------------------------
		
		System.out.println("\n---listar telefones somente de alunos");
		q = manager.query();
		q.constrain(Telefone.class);  
		q.descend("pessoa").constrain(Aluno.class);
		telefones = q.execute();
		for(Telefone t: telefones)
			System.out.println(t);
		
		System.out.println("\n---listar alunos com nota 10 (filtro)");
		q = manager.query();
		q.constrain(Aluno.class);  
		q.constrain(new Filtro2());
		List<Aluno> alunos = q.execute();
		for(Aluno a: alunos)
			System.out.println(a);
		
	}
	
	public static void main(String[] args) {
		new Consultar();
	}
}

//classe interna 
class Filtro1 implements Evaluation {
	private int n;
	public Filtro1(int n) {
		this.n = n;
	}
	
	public void evaluate(Candidate candidate) {
		//obter cada objeto da classe Pessoa que esta no banco
		Pessoa p = (Pessoa) candidate.getObject();
		
		if(p.getTelefones().size()==n) 
			candidate.include(true); 	//incluir objeto no resultado da consulta
		else		
			candidate.include(false);	//excluir objeto do resultado da consulta
	}
}

class Filtro2 implements Evaluation {
	public void evaluate(Candidate candidate) {
		//obter cada objeto da classe Pessoa que esta no banco
		Aluno a = (Aluno) candidate.getObject();
		
		if(a.getNota() == 10.0) 
			candidate.include(true); 	//incluir objeto no resultado da consulta
		else		
			candidate.include(false);	//excluir objeto do resultado da consulta
	}
}
