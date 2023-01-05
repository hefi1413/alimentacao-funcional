package com.alimentacao.api.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;


import jakarta.persistence.Entity;
import jakarta.validation.constraints.*;
import jakarta.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "alimentos")
public class Alimentos implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Uma descricao é requerida")
	@Column(name = "descricao", nullable = false)
	private String descricao;

	@Column(name = "resumo", nullable = false)
	private String resumo;
	
	@Column(name = "imagem", nullable = false)
	private String imagem;
	
	@NotNull(message = "Um principio ativo é requerido")
	@OneToOne
	@JoinColumn(name = "idativo_fk")
	private PrincipioAtivo principioAtivo;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getimagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	public PrincipioAtivo getPrincipioAtivo() {
		return principioAtivo;
	}

	public void setPrincipioAtivo(PrincipioAtivo principioAtivo) {
		this.principioAtivo = principioAtivo;
	}	

	@Override
	public String toString() {
		return "Alimentos [id=" + id + ", descricao=" + descricao + "imagem=" + imagem + "PrincipioAtivo=" + principioAtivo + "]";
	}	
}