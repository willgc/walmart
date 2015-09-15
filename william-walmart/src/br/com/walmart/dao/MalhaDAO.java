package br.com.walmart.dao;

import java.util.List;

import br.com.walmart.dao.model.DAOInterface;
import br.com.walmart.entity.Malha;
import br.com.walmart.exceptions.WException;

public interface MalhaDAO extends DAOInterface<Malha, Integer> {

	/**
	 * Metodo para verificar duplicidade de uma malha
	 * 
	 * @param objeto Malha para verficar duplicidade 
	 * 
	 * @throws WException Caso exista
	 */
	public void verificarDuplicidade(Malha objeto) throws WException;
	/**
	 * Metodo para listar as malhas
	 * 
	 * @return List das Malha
	 */
	public List<Malha> listMalhas();
	
}
