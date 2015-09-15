package br.com.walmart.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.walmart.dao.model.DAOImpl;
import br.com.walmart.entity.Malha;
import br.com.walmart.exceptions.WException;

public class MalhaDAOImpl extends DAOImpl<Malha, Integer> implements MalhaDAO{

	public MalhaDAOImpl(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void verificarDuplicidade(Malha malha) throws WException {
		TypedQuery<Malha> query = em.createQuery("from Malha m where m.nome = :nome", Malha.class);
		query.setParameter("nome", malha.getNome());
		Malha result = query.getSingleResult();
		if (result != null) {
			throw new WException("Malha '" + malha.getNome() + ", Encontrada!");
		}
		
	}

	@Override
	public List<Malha> listMalhas() {
		TypedQuery<Malha> query = em.createQuery("from Malha", Malha.class);
		return query.getResultList();
	}

}
