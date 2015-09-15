package br.com.walmart.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
*
* @author William.Galindo
*/

@Entity
@Table(name = "TB_TRECHO")
public class Trecho implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_TRECHO")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "ID_PONTO_ORIGEM")
	private Ponto pontoOrigem;

	@ManyToOne
	@JoinColumn(name = "ID_PONTO_DESTINO")
	private Ponto pontoDestino;

	@Column(name = "DISTANCIA")
	private Double distancia;


	/**
	 * @return ID TRECHO
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @return pontoOrigem
	 */
	public Ponto getPontoOrigem() {
		return pontoOrigem;
	}

	/**
	 * @param set pontoOrigem
	 */
	public void setPontoOrigem(Ponto pontoOrigem) {
		this.pontoOrigem = pontoOrigem;
	}

	/**
	 * @return pontoDestino
	 */
	public Ponto getPontoDestino() {
		return pontoDestino;
	}

	/**
	 * @param set pontoDestino
	 */
	public void setPontoDestino(Ponto pontoDestino) {
		this.pontoDestino = pontoDestino;
	}

	/**
	 * @return distancia trecho
	 */
	public Double getDistancia() {
		return distancia;
	}

	/**
	 * @param set distancia
	 */
	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Trecho [pontoOrigem=" + pontoOrigem + ", pontoDestino="
				+ pontoDestino + ", distancia=" + distancia + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((distancia == null) ? 0 : distancia.hashCode());
		result = prime * result
				+ ((pontoDestino == null) ? 0 : pontoDestino.hashCode());
		result = prime * result
				+ ((pontoOrigem == null) ? 0 : pontoOrigem.hashCode());
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
		Trecho other = (Trecho) obj;
		if (pontoDestino == null) {
			if (other.pontoDestino != null)
				return false;
		} else if (!pontoDestino.equals(other.pontoDestino))
			return false;
		if (pontoOrigem == null) {
			if (other.pontoOrigem != null)
				return false;
		} else if (!pontoOrigem.equals(other.pontoOrigem))
			return false;
		return true;
	}

}
