/**IFPB - Curso SI - Disciplina de PERSISTENCIA DE OBJETOS
 * @author Prof Fausto Ayres
 */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

import jakarta.persistence.NoResultException;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import modelo.Pessoa;


public class DAOPessoa extends DAO<Pessoa>{

	public Pessoa read(Object chave){
		try {
			String nome = (String) chave;
			TypedQuery<Pessoa> q = manager.createQuery("select p from Pessoa p where p.nome=:n",Pessoa.class);
			q.setParameter("n",nome);
			return q.getSingleResult();	
		}catch(NoResultException e){
			return null;
		}
	}

	//  //pode-se sobrescrever o metodo readAll da classe DAO para ordenar o resultado 
	public List<Pessoa> readAll(){
		TypedQuery<Pessoa> query = manager.createQuery("select p from Pessoa p order by p.nome",Pessoa.class);
		return  query.getResultList();
	}


	//--------------------------------------------
	//  consultas
	//--------------------------------------------
	public  List<Pessoa> readAll(String caracteres) {
		TypedQuery<Pessoa> q = manager.createQuery
				("select p from Pessoa p where p.nome like :x  order by p.nome",Pessoa.class);
		q.setParameter("x", "%"+caracteres+"%");
		return q.getResultList();
	}

	public  List<Pessoa>  readByNTelefones(int n) {
		TypedQuery<Pessoa> q = manager.createQuery
				("select p from Pessoa p where SIZE(p.telefones) = :x",Pessoa.class);
		q.setParameter("x", n);
		return q.getResultList(); 
	}

	public  boolean  temTelefoneCelular(String nome) {
		try{
			Query q = manager.createQuery
					("select count(t) from Pessoa p join p.telefones t where p.nome = :x and t.numero like :y");
			q.setParameter("x", nome);
			q.setParameter("y", "9%"); //inicia com 9
			long cont = (Long) q.getSingleResult();
			return cont>0;	
		}catch(NoResultException e){
			return false;
		}
	}

	public  boolean  temTelefoneFixo(String nome) {
		try{
			TypedQuery<Pessoa> q = manager.createQuery
					("select p from Pessoa p join p.telefones t where p.nome = :x and t.numero like :y",Pessoa.class);
			q.setParameter("x", nome);
			q.setParameter("y", "3%"); //prefixo 3
			List<Pessoa> lista = q.getResultList();
			if (lista.size()>0)	return true;
			else			return false;
		}catch(NoResultException e){
			return false;
		}
	}

	//--------------------------------------------
	//  trigger de Pessoa
	//--------------------------------------------

	// CALCULO DA IDADE
	@PostLoad 
	@PostPersist 
	@PostUpdate
	public void calcularIdade(Pessoa p) {
		LocalDate nascimento = LocalDate.parse(p.getDtNascimento(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		LocalDate hoje = LocalDate.now();
		long anos = ChronoUnit.YEARS.between(nascimento, hoje);
		p.setIdade((int)anos);
		System.out.println("===>idade calculada = " + p.getNome() + "/"+ p.getIdade() );
	}

}

