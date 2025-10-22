/**
 * IFPB - Curso SI - Disciplina de PERSISTENCIA DE OBJETOS
 * @author Prof Fausto Ayres
 */

import java.util.List;

import jakarta.persistence.LockModeType;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import modelo.Produto;


public class DAOProduto extends DAO<Produto> {

	@Override
	public Produto read(Object chave){
		try{
			String nome = (String) chave;
			TypedQuery<Produto> q = manager.createQuery("select p from Produto p where p.nome = :x", Produto.class);
			q.setParameter("x", nome);
			Produto prod = q.getSingleResult();
			return prod;
		}catch(NoResultException e){
			return null;
		}
	}

	public Produto readLock(Object chave){
		try{
			String nome = (String) chave;
			TypedQuery<Produto> q = manager.createQuery("select p from Produto p where p.nome = :x", Produto.class);

			q.setLockMode(LockModeType.PESSIMISTIC_WRITE);
			//******************************************

			q.setParameter("x", nome);
			Produto prod = q.getSingleResult();
			return prod;
		}catch(NoResultException e){
			return null;
		}
	}
	@Override
	public List<Produto> readAll(){
		//manager.clear();
		//*************
		TypedQuery<Produto> query;
		query = manager.createQuery("select p from Produto p LEFT JOIN FETCH p.vendas order by p.id",Produto.class);
		return  query.getResultList();
	}

}
