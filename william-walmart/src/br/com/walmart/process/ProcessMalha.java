package br.com.walmart.process;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import br.com.walmart.entity.Malha;
import br.com.walmart.entity.Ponto;
import br.com.walmart.entity.Trecho;

/**
 * Classe para processar uma malha
 *
 * @author William.Galindo
 */
public final class ProcessMalha {

	public ProcessMalha() {
	}

	/**
	 * representa <code>String</code> de uma malha
	 *
	 */
	private static final Pattern FORMATO_MALHA_VALIDO = Pattern
			.compile("(.\\s+.\\s+\\d+\\s*\n?)+");

	/**
	 * Factory Method para criacao de uma malha.
	 * 
	 * @param nome
	 *            
	 * @param malha
	 *            Malha.
	 *            <pre>
	 *            A B 10
	 *            B D 15
	 *            A C 20
	 *            C D 30
	 *            B E 50
	 *            D E 30
	 *            </pre>
	 * @return Malha
	 */
	public static Malha processar(String nome, String malha) {
		Map<String, Ponto> pontos = new HashMap<String, Ponto>();
		String[] aresta = null;
		String origem = null;
		String destino = null;
		Malha malhaObject = null;

		if (parametrosValidos(nome, malha)) {
			malhaObject = criarMalha(nome);
			String[] linhas = malha.split("\n");
			double distancia = 0d;
			for (String linha : linhas) {
				aresta = linha.split("\\s+");
				origem = aresta[0];
				destino = aresta[1];
				distancia = Double.parseDouble(aresta[2]);

				Ponto pontoOrigem = criarPonto(origem, malhaObject, pontos);
				pontos.put(origem, pontoOrigem);
				Ponto pontoDestino = criarPonto(destino, malhaObject, pontos);
				pontos.put(destino, pontoDestino);

				Trecho trecho = pontoOrigem.obterTrecho(destino);
				if (trecho == null) {
					pontoOrigem.addTrecho(criarTrecho(pontoOrigem, pontoDestino, distancia));
				} else {
					trecho.setDistancia(distancia);
				}
			}

			for (Ponto ponto : pontos.values()) {
				malhaObject.addPonto(ponto);
			}
		}

		return malhaObject;
	}

	/**
	 * Verifica se os parametros s�o validos
	 * 
	 * @param nome Nome da malha. 
	 * 
	 * @param malha Malha
	 * 
	 * @return <code>true</code> se param validos
	 */
	private static boolean parametrosValidos(String nome, String malha) {
		if (nome == null || malha == null || nome.length() == 0
				|| malha.length() == 0
				|| !FORMATO_MALHA_VALIDO.matcher(malha).matches()) {

			return false;
		}

		return true;
	}

	/**
	 * Factory Method Trecho.
	 * 
	 * @param pontoOrigem Ponto de origem do trecho.
	 * 
	 * @param pontoDestino Ponto de destino do trecho.
	 * 
	 * @param distancia Distancia entre o ponto de origem e ponto de destino.
	 * 
	 * @return A instância do objeto Trecho com os parâmetros especificados.
	 */
	private static Trecho criarTrecho(Ponto pontoOrigem, Ponto pontoDestino,
			double distancia) {
		Trecho trecho = new Trecho();
		trecho.setPontoOrigem(pontoOrigem);
		trecho.setPontoDestino(pontoDestino);
		trecho.setDistancia(distancia);
		return trecho;
	}

	/**
	 * Factory Method para o objeto Ponto.
	 * 
	 * @param ponto Nome do ponto.
	 * 
	 * @param malhaObject Malha a qual o ponto pertence.
	 * 
	 * @param pontos Mapa com todos os pontos criados.
	 * 
	 * @return A instancia do ponto com nome especificados ou um novo ponto.
	 */
	private static Ponto criarPonto(String ponto, Malha malhaObject,
			Map<String, Ponto> pontos) {
		Ponto pontoObject = pontos.get(ponto);

		if (pontoObject == null) {
			pontoObject = new Ponto();
			pontoObject.setNome(ponto);
			pontoObject.setMalha(malhaObject);
		}

		return pontoObject;
	}

	/**
	 * Factory Method para Malha.
	 * 
	 * @param nome Nome malha.
	 * 
	 * @return Uma Malha.
	 */
	private static Malha criarMalha(String nome) {
		Malha malha = new Malha();
		malha.setNome(nome);
		malha.setHoraInclusao(new Date());
		malha.setHoraAtualizacao(new Date());
		return malha;
	}

}
