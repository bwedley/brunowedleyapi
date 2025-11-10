package br.edu.infnet.brunowedleyapi.model.domain;

public class Prato {
	public String nome;
	public double precoBase;
	public String descricao;
	public boolean vegano;
	public int adicionais;	
	
	private double calcularPreco() {
		double precoFinal = precoBase;
		if(adicionais > 0) {
			precoFinal += adicionais * 5;
		} 
	return precoFinal;
	}
	
	public void imprimirPrato() {
		System.out.println("Prato cadastrado com sucesso!");
		System.out.println("Prato: " + nome);
		System.out.println("Descrição: " + descricao);
		System.out.println("Adicionais: " + (adicionais > 0 ? adicionais : 0));
		System.out.println("Vegano? " + (vegano ? "sim" : "não"));
		System.out.println("Preço: " + calcularPreco());
	}
}

