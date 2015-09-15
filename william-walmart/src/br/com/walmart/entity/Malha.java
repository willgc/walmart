package br.com.walmart.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author William.Galindo
 *
 */

@Entity
@Table(name = "TB_MALHA")
public class Malha implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_MALHA")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(name = "NOME")
	private String nome;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATETIME_INCLUSAO")
	private Date horaInclusao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATETIME_ULTIMA_INCLUSAO")
	private Date horaAtualizacao;

	@OneToMany
	private List<Ponto> pontos = new ArrayList<Ponto>();

	/**
	 * @return id malha
	 */
	public Long getId() {
		return id;
	}


	/**
	 * @return nome malha 
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param set nome malha
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return horaInclusao
	 */
	public Date getHoraInclusao() {
		return horaInclusao;
	}

	/**
	 * @param  set horaInclusao
	 */
	public void setHoraInclusao(Date horaInclusao) {
		this.horaInclusao = horaInclusao;
	}

	/**
	 * @return horaAtualizacao
	 */
	public Date getHoraAtualizacao() {
		return horaAtualizacao;
	}

	/**
	 * @param set horaAtualizacao
	 */
	public void setHoraAtualizacao(Date horaAtualizacao) {
		this.horaAtualizacao = horaAtualizacao;
	}

	/**
	 * @return pontos malha
	 */
	public List<Ponto> getPontos() {
		return pontos;
	}

	/**
	 * @param set pontos  
	 */
	public void setPontos(List<Ponto> pontos) {
		this.pontos = pontos;
	}
	
	/**
	 * @param ponto
	 * @return true apoenas se o ponto é da malha.
	 */
	public boolean contemPonto(Ponto ponto) {
		return getPontos().contains(ponto);
	}
	
	/**
	 * 
	 * @param ponto 
	 */
	public void addPonto(Ponto ponto) {
		getPontos().add(ponto);
	}
	
	/**
	 * @param nomePonto 
	 * @return Retorna o ponto 
	 */
	public Ponto obterPonto(String nomePonto) {
		for (Ponto ponto : getPontos()) {
			if (ponto.getNome().equals(nomePonto)) {
				return ponto;
			}
		}
		
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Malha [id=" + id + ", nome=" + nome + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
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

	/*
	 * (non-Javadoc)
	 * 
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
		Malha other = (Malha) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}

