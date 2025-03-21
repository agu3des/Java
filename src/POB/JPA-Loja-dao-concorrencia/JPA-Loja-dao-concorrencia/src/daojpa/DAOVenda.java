/**
 * IFPB - Curso SI - Disciplina de PERSISTENCIA DE OBJETOS
 * @author Prof Fausto Ayres
 */

import java.util.List;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import modelo.Venda;


public class DAOVenda extends DAO<Venda> {

	@Override
	public Venda read(Object chave){
		try{
			Integer id = (Integer) chave;
			TypedQuery<Venda> q = manager.createQuery("select v from Venda v where v.id = :x", Venda.class);
			q.setParameter("x", id);
			Venda v = q.getSingleResult();
			return v;
		}catch(NoResultException e){
			return null;
		}
	}


	@Override
	public List<Venda> readAll(){
		//manager.clear();
		//*************
		TypedQuery<Venda> query = manager.createQuery("select v from Venda v LEFT JOIN FETCH v.produto order by v.id",Venda.class);
		return  query.getResultList();
	}
}
