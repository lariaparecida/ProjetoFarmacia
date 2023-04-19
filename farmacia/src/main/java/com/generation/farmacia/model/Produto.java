package com.generation.farmacia.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produtos")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O atributo 'nome do produto' é obrigatório!")
	@Size(min = 5, max = 100, message = "O atributo 'nome do produto' deve conter no mínimo 5 e no máximo 100 caracteres")
	private String nome;
	
	@NotNull(message = "O atributo 'preço do produto' é obrigatório!")
	@DecimalMin(value = "0.01", message = "O atributo 'preço do produto' deve ser um número decimal positivo, a partir de R$ 0.01 !")
	private BigDecimal preco;
	
	@UpdateTimestamp
	private LocalDateTime data1aInsercao;
	
	@ManyToOne
	@JsonIgnoreProperties("produto") 
	private Categoria categoria; 

	//G&S Produto
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public LocalDateTime getData1aInsercao() {
		return data1aInsercao;
	}

	public void setData1aInsercao(LocalDateTime data1aInsercao) {
		this.data1aInsercao = data1aInsercao;
	}

	//
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	

}
