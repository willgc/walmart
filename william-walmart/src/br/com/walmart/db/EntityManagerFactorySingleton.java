package br.com.walmart.db;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Retorna instancia do Entity Manager
 *
 * @author William.Galindo
 */
public class EntityManagerFactorySingleton {

	private static EntityManagerFactory factory;
	
	private EntityManagerFactorySingleton(){
		super();
	};
	
	/**
	 * Factory Method
	 * @return Uma unica instancia de EntityManager
	 */
	public static EntityManagerFactory getInstance(){
		if (factory == null){
			factory = Persistence.createEntityManagerFactory("CLIENT_ORACLE");
		}
		return factory;
	}
}
