package com.natalino.lojaanime.entity;

import java.util.Objects;

public class Produtos {
	private Long id;
	private String nome;
	private String descrição;
	private Double preco;
	
	
	public Produtos() {
		
	}


	public Produtos(Long id, String nome, String descrição, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.descrição = descrição;
		this.preco = preco;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produtos other = (Produtos) obj;
		return Objects.equals(id, other.id);
	}


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


	public String getDescrição() {
		return descrição;
	}


	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}


	public Double getPreco() {
		return preco;
	}


	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	

}
