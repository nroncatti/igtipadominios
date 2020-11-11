package com.igti.dominio.app.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TABDOMINIO")
public class Generico {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigoDominio;
	private String  nomeTabelaFisico;
	private String  nomeLogico;
	private String 	nomeCodigoFisico;
	private String  nomeColunaFisco;

	public Generico() {
		
	}

	public Generico(Integer codigoDominio, String nomeTabelaFisico, String nomeLogico, String nomeCodigoFisico,
			String nomeColunaFisco) {
		
		this.codigoDominio = codigoDominio;
		this.nomeTabelaFisico = nomeTabelaFisico;
		this.nomeLogico = nomeLogico;
		this.nomeCodigoFisico = nomeCodigoFisico;
		this.nomeColunaFisco = nomeColunaFisco;
	}

	@Column(name="CODDOM", nullable=false, updatable=false, precision=5, scale=0)
	public Integer getCodigoDominio() {
		return codigoDominio;
	}
	
	@Column(name="NOMTABFISI", nullable=false, length=30)
	public String getNomeTabelaFisico() {
		return nomeTabelaFisico;
	}
	
	@Column(name="NOMTABLOGI", nullable=false, length=50)
	public String getNomeLogico() {
		return nomeLogico;
	}

	@Column(name="NOMCODFISI", nullable=false, length=50)
	public String getNomeCodigoFisico() {
		return nomeCodigoFisico;
	}
	
	@Column(name="NOMCOLUMFISI", nullable=false, length=50)
	public String getNomeColunaFisco() {
		return nomeColunaFisco;
	}

	public void setCodigoDominio(Integer codigoDominio) {
		this.codigoDominio = codigoDominio;
	}

	public void setNomeTabelaFisico(String nomeTabelaFisico) {
		this.nomeTabelaFisico = nomeTabelaFisico;
	}

	public void setNomeLogico(String nomeLogico) {
		this.nomeLogico = nomeLogico;
	}

	public void setNomeCodigoFisico(String nomeCodigoFisico) {
		this.nomeCodigoFisico = nomeCodigoFisico;
	}

	public void setNomeColunaFisco(String nomeColunaFisco) {
		this.nomeColunaFisco = nomeColunaFisco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoDominio == null) ? 0 : codigoDominio.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Generico other = (Generico) obj;
		if (codigoDominio == null) {
			if (other.codigoDominio != null)
				return false;
		} else if (!codigoDominio.equals(other.codigoDominio))
			return false;
		return true;
	}

}
