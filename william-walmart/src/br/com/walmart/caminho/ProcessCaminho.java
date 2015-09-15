package br.com.walmart.caminho;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.walmart.dto.EntregaParam;
import br.com.walmart.dto.EntregaRotaParam;
import br.com.walmart.entity.Malha;
import br.com.walmart.entity.Ponto;
import br.com.walmart.entity.Trecho;
import br.com.walmart.exceptions.WException;

/**
 * Calculador do menor caminho
 *
 * @author William.Galindo
 */
public class ProcessCaminho {

	/**
	 * Calcula o menor caminho dos pontos especificados
	 * 
	 * @param malha
	 *            
	 * @param dto
	 *            
	 * @return O objeto RotaEntrega 
	 * 
	 * @throws WException
	 *             
	 */
	public static EntregaRotaParam ProcessMenorCaminho(Malha malha,
			EntregaParam dto) throws WException {

		EntregaRotaParam rota = new EntregaRotaParam();
		rota.setAutonomia(dto.getAutonomia());
		rota.setValor(dto.getValorCombustivel());

		Ponto origem = obterPonto(malha, dto.getOrigem());
		Ponto destino = obterPonto(malha, dto.getDestino());

		return calcularMenorCaminhoEntrePontos(origem, destino, malha, rota);
	}

	/**
	 * Reupera o ponto com o nome especificado da malha de pontos especificada.
	 * 
	 * @param malha 
	 * 
	 * @param nomePonto 
	 * 
	 * @return O ponto 
	 * 
	 * @throws WException 
	 */
	private static Ponto obterPonto(Malha malha, String nomePonto)
			throws WException {
		Ponto ponto = malha.obterPonto(nomePonto);
		
		if (ponto == null) {
			throw new WException("O ponto '" + nomePonto
					+ "' especificado não existente!");
		}
		
		return ponto;
	}

	/**
	 * Calcula o menor caminho entre dois pontos.
	 * 
	 * @param origem
	 * 
	 * @param destino 
	 * 
	 * @param malha 
	 * 
	 * @return A rota 
	 * 
	 * @throws WException 
	 */
	private static EntregaRotaParam calcularMenorCaminhoEntrePontos(Ponto origem,
			Ponto destino, Malha malha, EntregaRotaParam rota) throws WException {

		List<Ponto> visitados = new ArrayList<Ponto>(malha.getPontos());
		Map<Ponto, Double> distancias = criarMapaDistancias(malha.getPontos());
		Map<Ponto, Ponto> antecessores = new HashMap<Ponto, Ponto>();

		visitados.remove(origem);
		distancias.put(origem, 0d);
		antecessores.put(destino, null);

		calcularDistanciasAntecessores(origem, distancias, antecessores);
		while (!visitados.isEmpty()) {
			Ponto pontoMenorDistancia = recuperarPontoMenorDistancia(distancias, visitados);
			
			if (pontoMenorDistancia == null) {
				throw new WException("Não existe rota da origem '" + origem + "' para o destino '" + destino);
			}
			
			calcularDistanciasAntecessores(pontoMenorDistancia, distancias,
					antecessores);
			visitados.remove(pontoMenorDistancia);
		}

		rota.setDistanciaRota(distancias.get(destino));
		Ponto precedente = destino;
		do {
			rota.getRota().add(precedente.getNome());
			precedente = antecessores.get(precedente);
		} while (precedente != null);

		return rota;
	}
	
	/**
	 * Calcula a menor estimativa dos pontos especificados.
	 * 
	 * @param lista de todos os pontos.
	 * 
	 * @param mapa com as distancias entre os pontos
	 * 
	 * @return ponto com a menos distancia  
	 */
	private static Ponto recuperarPontoMenorDistancia(Map<Ponto, Double> distancias,
			List<Ponto> visitados) {
		double maiorDistancia = Double.MAX_VALUE;
		Ponto candidato = null;
		for (Ponto visitado : visitados) {
			double distancia = distancias.get(visitado);
			if (distancia < maiorDistancia) {
				maiorDistancia = distancia;
				candidato = visitado;
			}
		}
		return candidato;
	}
	
	/**
	 * Calcula a distancia do ponto especificado para os seus trechos.
	 * 
	 * @param ponto 
	 * 
	 * @param distancias 
	 * 
	 * @param precedentes 
	 */
	private static void calcularDistanciasAntecessores(Ponto ponto,
			Map<Ponto, Double> distancias, Map<Ponto, Ponto> precedentes) {

		for (Trecho trecho : ponto.getTrechos()) {
			Ponto outroPonto = trecho.getPontoDestino();

			Double distanciaAtual = distancias.get(ponto)
					+ trecho.getDistancia();
			Double distanciaAnterior = distancias.get(outroPonto);

			if (distanciaAtual < distanciaAnterior) {
				distancias.put(outroPonto, distanciaAtual);
				precedentes.put(outroPonto, ponto);
			}
		}
	}

	/**
	 * Inicializa o mapa de distancias com o maior valor.
	 * 
	 * @param pontos Pontos que a serem inseridos no mapa.
	 * 
	 * @return Um mapa com todos os pontos e a maior distancia possível
	 */
	private static Map<Ponto, Double> criarMapaDistancias(List<Ponto> pontos) {
		Map<Ponto, Double> distancias = new HashMap<Ponto, Double>();
		for (Ponto ponto : pontos) {
			distancias.put(ponto, Double.MAX_VALUE);
		}
		return distancias;
	}

}
