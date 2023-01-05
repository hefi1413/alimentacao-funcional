package com.alimentacao.api.domain;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@SuppressWarnings("serial")
@Entity
@Table(name = "indicacoes")
public class Indicacoes implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Um ID principio ativo é requerido")
	@OneToMany
	@JoinColumn(name = "idativo_fk")
	private PrincipioAtivo principioAtivo;
	
	@NotNull(message = "Um ID doenca é requerido")
	@OneToMany
	@JoinColumn(name = "iddoencas_fk")
	private Doencas doencas;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PrincipioAtivo getPrincipioAtivo() {
		return principioAtivo;
	}

	public void setPrincipioAtivo(PrincipioAtivo principioAtivo) {
		this.principioAtivo = principioAtivo;
	}

	public Doencas getDoencas() {
		return doencas;
	}

	public void setDoencas(Doencas doencas) {
		this.doencas = doencas;
	}
	
	@Override
	public String toString() {
		return "Sinonimos [id=" + id + ", PrincipioAtivo=" + principioAtivo+ ", Doencas=" + doencas +"]";
	}
}
