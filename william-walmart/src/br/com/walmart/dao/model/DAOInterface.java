package br.com.walmart.dao.model;

import br.com.walmart.exceptions.WException;

/**
 * Super interface para o CRUD
 *
 * @author William.GAlindo 
 */

public interface DAOInterface<T,K> {

	/**
	 * insert
	 * 
	 * @param objeto
	 *            
	 * @throws WException
	 *             Caso ocorra alguma Exception.
	 */
	void insert(T entity);


	/**
	 * update
	 * 
	 * @param objeto
	 *            
	 * @throws WException
	 *             Caso ocorra alguma Exception.
	 */
	void update(T entity);


	/**
	 * delete
	 * 
	 * @param objeto
	 *            
	 * @throws WException
	 *             Caso ocorra alguma Exception.
	 */
	void delete (T entity);
	


	/**
	 * find By Id
	 * 
	 * @param Id Objeto a ser localizado
	 *            
	 * @throws WException
	 *             Caso ocorra alguma Exception.
	 */
	T findById(K id);
	
}
