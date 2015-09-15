package br.com.walmart.bo;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.walmart.dao.MalhaDAO;
import br.com.walmart.dao.MalhaDAOImpl;
import br.com.walmart.entity.Malha;
import br.com.walmart.exceptions.WException;

public class MalhaBO implements MalhaDAO{

	private MalhaDAO dao;
	
	public MalhaBO(EntityManager em) {
		dao = new MalhaDAOImpl(em);
	}
	
	@Override
	public void insert(Malha entity) {
		dao.insert(entity);
	}

	@Override
	public void update(Malha entity) {
		dao.update(entity);
	}

	@Override
	public void delete(Malha entity) {
		dao.delete(entity);
	}

	@Override
	public Malha findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public void verificarDuplicidade(Malha objeto) throws WException {
		dao.verificarDuplicidade(objeto);
	}

	@Override
	public List<Malha> listMalhas() {
		return dao.listMalhas();
	}

}
