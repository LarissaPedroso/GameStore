package com.generation.GameStore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity 
@Table(name="tb_produto")
public class Produtos {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=2, max=50, message = "O nome do produto deve ter no mínimo 2 caracteres e no máximo 50")
	@NotBlank(message = "Atributo nome é obrigatório")
	private String nome;
	
	@Size(max=1000, message = "A descrição deve ter no máximo 1000")
	private String descricao;
	
	private Double preco;
	
	@Size(max = 10)
	private String dataLancamento;
	
	@Size(min=1, max=255, message = "O nome do desenvolvedor deve ter no mínimo 1 caractere e no máximo 255")
	private String desenvolvedor;
	
	@Size(max=1, message = "O rate deve ter no máximo 1 caracter")
	private int rate;
	
	@ManyToOne
	@JsonIgnoreProperties("produtos")
	private Categorias categorias;
	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public double getPreco() {
		return preco;
	}

	public String getDataLancamento() {
		return dataLancamento;
	}

	public String getDesenvolvedor() {
		return desenvolvedor;
	}

	public int getRate() {
		return rate;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public void setDataLancamento(String dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public void setDesenvolvedor(String desenvolvedor) {
		this.desenvolvedor = desenvolvedor;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public Categorias getCategorias() {
		return categorias;
	}

	public void setCategorias(Categorias categorias) {
		this.categorias = categorias;
	}
}
