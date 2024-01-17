package com.generation.GameStore.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity 
@Table(name="tb_categoria")
public class Categorias {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String genero;
	
	@Size(max=300, message="A descrição deve ter no máximo 300 caracteres")
	private String descricao;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categorias", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("categorias")
	private List<Produtos> produtos;

	public Long getId() {
		return id;
	}

	public String getGenero() {
		return genero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Produtos> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produtos> produtos) {
		this.produtos = produtos;
	}
}
