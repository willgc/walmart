package br.com.walmart.dto;

import java.io.Serializable;

/**
 * Objeto entrega.
 * 
 * @author William.Galindo
 */
public class EntregaParam implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String malha;

	private String origem;
	
	private String destino;

	private double autonomia;
	
	private double valorCombustivel;
	
	/**
	 * @return malha
	 */
	public String getMalha() {
		return malha;
	}

	/**
	 * @param set malha
	 */
	public void setMalha(String malha) {
		this.malha = malha;
	}

	/**
	 * @return origem
	 */
	public String getOrigem() {
		return origem;
	}

	/**
	 * @param set origem
	 */
	public void setOrigem(String origem) {
		this.origem = origem;
	}

	/**
	 * @return destino
	 */
	public String getDestino() {
		return destino;
	}

	/**
	 * @param set destino.
	 */
	public void setDestino(String destino) {
		this.destino = destino;
	}
	
	/**
	 * @return autonomia
	 */
	public double getAutonomia() {
		return autonomia;
	}

	/**
	 * @param set autonomia
	 */
	public void setAutonomia(double autonomia) {
		this.autonomia = autonomia;
	}

	/**
	 * @return valor Combustivel.
	 */
	public double getValorCombustivel() {
		return valorCombustivel;
	}

	/**
	 * @param set valor Combustivel
	 */
	public void setValorCombustivel(double valorCombustivel) {
		this.valorCombustivel = valorCombustivel;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ParametrosEntrega [malha=" + malha + ", origem=" + origem
				+ ", destino=" + destino + ", autonomiaVeiculo="
				+ autonomia + ", valorLitroCombustivel="
				+ valorCombustivel + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(autonomia);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((destino == null) ? 0 : destino.hashCode());
		result = prime * result + ((malha == null) ? 0 : malha.hashCode());
		result = prime * result + ((origem == null) ? 0 : origem.hashCode());
		temp = Double.doubleToLongBits(valorCombustivel);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntregaParam other = (EntregaParam) obj;
		if (Double.doubleToLongBits(autonomia) != Double
				.doubleToLongBits(other.autonomia))
			return false;
		if (destino == null) {
			if (other.destino != null)
				return false;
		} else if (!destino.equals(other.destino))
			return false;
		if (malha == null) {
			if (other.malha != null)
				return false;
		} else if (!malha.equals(other.malha))
			return false;
		if (origem == null) {
			if (other.origem != null)
				return false;
		} else if (!origem.equals(other.origem))
			return false;
		if (Double.doubleToLongBits(valorCombustivel) != Double
				.doubleToLongBits(other.valorCombustivel))
			return false;
		return true;
	}

}
