package br.com.walmart.dao;

import javax.persistence.EntityManager;

import br.com.walmart.dao.model.DAOImpl;
import br.com.walmart.entity.Ponto;

public class PontoDAOImpl extends DAOImpl<Ponto, Integer> implements PontoDAO {

	public PontoDAOImpl(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

}
