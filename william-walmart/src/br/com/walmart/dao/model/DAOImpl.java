package br.com.walmart.dao.model;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * implementação do DAOInterface com CRUD 
 *
 * @author William.Galindo
 */

public abstract class DAOImpl<T,K> implements DAOInterface<T,K> {

	private static final Logger LOGGER = LoggerFactory.getLogger(DAOImpl.class);
	
	protected EntityManager em;
	
	private Class<T> entityClass;
	
	//construtor
	@SuppressWarnings("all")
	public DAOImpl(EntityManager entityManager){
		this.em = entityManager;
		this.entityClass = (Class) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	};
	
	
	
	@Override
	public void insert(T entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}

	@Override
	public void delete(T entity) {
		em.getTransaction().begin();
		em.remove(entity);
		em.getTransaction().commit();
	}

	@Override
	public void update(T entity) {
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
	}

	@Override
	public T findById(K id) {
		return em.find(entityClass, id);
	}

	protected static Logger getLogger() {
		return LOGGER;
	}
	
	

}
