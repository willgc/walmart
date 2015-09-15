package br.com.walmart.service;
 
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import br.com.walmart.dto.EntregaParam;
import br.com.walmart.dto.EntregaRotaParam;
import br.com.walmart.entity.Malha;
import br.com.walmart.exceptions.WException;
 
/**
 * Interface para operacoes do webservice
 * 
 * @author William.Galindo
 */

@WebService
@SOAPBinding(style = Style.RPC)
public interface WalmartServer {
    
	 /**
 	  * Inclui malhas.
	  * 
  	* @param A malha para ser adicionada.
	  * @return Malha
	  */
    @WebMethod public Malha incluir(Malha objeto) throws WException;
    /**
  	 * Carrega mapa de Malhas
  	 * 
  	 */
    @WebMethod public void carregarMalhas();
  	/**
  	 * Atualiza o mapa de malhas.
  	 * 
  	 * @param A malha para ser Atualizada.
  	 */
    @WebMethod public void atualizarMalhas(Malha malha);
    /**
  	 * Método responsável por calcular a rota de menor custo. Uma rota de menor
  	 * custo é aquela que o veículo de entrega percorre menos kilômetros,
  	 * consumindo menos combustível.
  	 * 
  	 * @param dto
  	 *            Contém as informações de entrega: ponto de origem, ponto de
  	 *            destino, autonomia do veículo usado para entrega e valor do
  	 *            litro de combustível usado pelo veículo de entrega.
  	 * 
  	 * @return O objeto <code>Rota</code> que contém as informações do menor
  	 *         caminho de entrega e o custo da entrega de acordo com a autonomia
  	 *         do veículo usado para entrega e o valor do combustível.
  	 * @throws WException
  	 *             Essa exceção é lançada quando um dos pontos, origem ou
  	 *             destino, não existem na malha.
  	 */
    @WebMethod public EntregaRotaParam calcularRotaMenorCusto(EntregaParam dto) throws WException;
    
}