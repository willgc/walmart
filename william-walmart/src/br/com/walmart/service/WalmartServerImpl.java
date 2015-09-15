package br.com.walmart.service;
 
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;

import br.com.walmart.bo.MalhaBO;
import br.com.walmart.caminho.ProcessCaminho;
import br.com.walmart.db.EntityManagerFactorySingleton;
import br.com.walmart.dto.EntregaParam;
import br.com.walmart.dto.EntregaRotaParam;
import br.com.walmart.entity.Malha;
import br.com.walmart.exceptions.WException;
/**
 * 
 * @author William.Galindo
 */
@WebService(endpointInterface = "br.com.walmart.service.WalmartServer")
public class WalmartServerImpl extends WalmartServiceAbstract implements WalmartServer {

	private Map<String, Malha> mapaMalhas = new HashMap<String, Malha>();
	private EntityManager em;
	private MalhaBO bo;
	
	@Override
	@WebMethod
	public Malha incluir(Malha objeto) throws WException {
		em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		bo = new MalhaBO(em);
		bo.insert(objeto);
		atualizarMalhas(objeto);
		return objeto;
		
	}

	@Override
	@WebMethod
	public void carregarMalhas() {
		try {
			List<Malha> malhas = bo.listMalhas();
			if (malhas.isEmpty()) {
				getLogger().warn("Nenhuma malha foi carregada!");
			} else {
				for (Malha malha : malhas) {
					atualizarMalhas(malha);
				}
			}
		} catch (Exception e) {
			getLogger().error(e.getMessage(), e);
		}
	}

	@Override
	@WebMethod
	public void atualizarMalhas(Malha malha) {
		mapaMalhas.put(malha.getNome(), malha);
		
	}

	@Override
	@WebMethod
	public EntregaRotaParam calcularRotaMenorCusto(EntregaParam dto) throws WException {
		if (mapaMalhas.containsKey(dto.getMalha())) {
			return ProcessCaminho.ProcessMenorCaminho(mapaMalhas.get(dto.getMalha()), dto);
		}
		
		throw new WException("Malha '" + dto.getMalha() + "' Não Encontrada!");
	}
         
}

