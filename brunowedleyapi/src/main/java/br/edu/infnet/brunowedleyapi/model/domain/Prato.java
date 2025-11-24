package br.edu.infnet.brunowedleyapi.model.domain;

public class Prato {
	private String nome;
	private double precoBase;
	private String descricao;
	private boolean vegano;
	private int adicionais;
	private Categoria categoria; 
	
	
	public Prato(String nome, double precoBase, String descricao, boolean vegano, int adicionais, Categoria categoria) {
		this.setNome(nome);
		this.setPrecoBase(precoBase);
		this.setDescricao(descricao);
		this.setVegano(vegano);
		this.setAdicionais(adicionais);
		this.setCategoria(categoria);
	}
	
	public Prato() {
		
	}
	
	private double calcularPreco() {
		double precoFinal = getPrecoBase();
		if(getAdicionais() > 0) {
			precoFinal += getAdicionais() * 5;
		} 
	return precoFinal;
	}
	
	public enum Categoria {
		ENTRADA,
		PRATO_PRINCIPAL,
		BEBIDA,
		SOBREMESA
	}
	
	public void imprimirPrato() {
		System.out.println("Prato cadastrado com sucesso!");
		System.out.println("Prato: " + getNome());
		System.out.println("Descrição: " + getDescricao());
		System.out.println("Adicionais: " + (getAdicionais() > 0 ? getAdicionais() : 0));
		System.out.println("Vegano? " + (isVegano() ? "sim" : "não"));
		System.out.println("Preço: " + calcularPreco());
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isVegano() {
		return vegano;
	}

	public void setVegano(boolean vegano) {
		this.vegano = vegano;
	}

	public int getAdicionais() {
		return adicionais;
	}

	public void setAdicionais(int adicionais) {
		this.adicionais = adicionais;
	}

	public double getPrecoBase() {
		return precoBase;
	}

	public void setPrecoBase(double precoBase) {
		this.precoBase = precoBase;
	}
	
	public String toString() {
		return "--- Prato ---" +
		       "\nNome: " + nome +
		       "\nDescrição: " + descricao +
		       "\nCategoria: " + categoria +
		       "\nVegano: " + (vegano ? "Sim" : "Não") +
		       "\nAdicionais: " + adicionais +
		       "\nPreço final: R$ " + calcularPreco();
	}
}

