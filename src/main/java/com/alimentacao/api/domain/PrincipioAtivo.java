package com.alimentacao.api.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;


import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.*;
import jakarta.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "principio_ativo")
public class PrincipioAtivo implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Uma descricao é requerida")
	@Column(name = "descricao", nullable = false)
	private String descricao;

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

	@Override
	public String toString() {
		return "PrincipioAtivo [id=" + id + ", descricao=" + descricao + "]";
	}	
}