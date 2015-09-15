package br.com.walmart.dao;

import javax.persistence.EntityManager;

import br.com.walmart.dao.model.DAOImpl;
import br.com.walmart.entity.Trecho;

public class TrechoDAOImpl extends DAOImpl<Trecho, Integer> implements TrechoDAO{

	public TrechoDAOImpl(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

}
