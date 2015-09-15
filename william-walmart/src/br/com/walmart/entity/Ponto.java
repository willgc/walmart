package br.com.walmart.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 *
 * @author William.Galindo
 */

@Entity
@Table(name = "TB_PONTO")
public class Ponto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_PONTO")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name = "NOME")
	private String nome;

	@ManyToOne
	@JoinColumn(name = "ID_MALHA")
	private Malha malha;

	@OneToMany
	private List<Trecho> trechos = new ArrayList<Trecho>();



	/**
	 * @return ID_PONTO
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * @return nome Ponto
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param set nome Ponto
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return malha
	 */
	public Malha getMalha() {
		return malha;
	}

	/**
	 * @param set malha
	 */
	public void setMalha(Malha malha) {
		this.malha = malha;
	}

	/**
	 * @return trechos
	 */
	public List<Trecho> getTrechos() {
		return trechos;
	}

	/**
	 * @param  set trechos
	 */
	public void setTrechos(List<Trecho> trechos) {
		this.trechos = trechos;
	}
	
	/**
	 * 
	 * @param trecho 
	 * @return true se o trecho esta no ponto 
	 */
	public boolean contemTrecho(Trecho trecho) {
		return getTrechos().contains(trecho);
	}

	/**
	 * Método add um trecho
	 * 
	 * @param trecho
	 */
	public void addTrecho(Trecho trecho) {
		getTrechos().add(trecho);
	}

	/**
	 * Método para Obeter trecho
	 * 
	 * @param nome do destino
	 * @return trecho or nul caso nao encontrado.
	 */
	public Trecho obterTrecho(String destino) {
		for (Trecho trecho : trechos) {
			if (trecho.getPontoDestino().getNome().equals(destino)) {
				return trecho;
			}
		}
		
		return null;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Ponto [id=" + id + ", nome=" + nome + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Ponto other = (Ponto) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
	
}
