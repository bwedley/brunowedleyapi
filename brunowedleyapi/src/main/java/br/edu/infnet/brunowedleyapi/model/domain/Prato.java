package br.edu.infnet.brunowedleyapi.model.domain;

import java.util.Scanner;

public class Prato extends ProdutoCardapio{

	private boolean vegano;
	private int adicionais;
	private Categoria categoria;
	
	public Prato(String nome, double precoBase, String descricao, boolean vegano, int adicionais, Categoria categoria) {
		super(nome, precoBase, descricao, categoria);
		this.setVegano(vegano);
		this.setAdicionais(adicionais);
		
	}
		
	public Prato() {
		this("Prato exemplo", 99.00, "descrição exemplo", false, 2, Categoria.SOBREMESA);
	}
	
	@Override
	public double calcularPreco() {
		double preco = getPrecoBase();
		if(getAdicionais() > 0) {
			preco += getAdicionais() * 5;
		} 
	return preco;
	}
		

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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
	
	@Override
	public void imprimirDetalhes(boolean completo) {
		if(completo) {
			System.out.println("=======PRATO=======!");
			System.out.println("Prato: " + getNome());
			System.out.println("Descrição: " + getDescricao());
			System.out.println("Acompanhamentos: " + (getAdicionais() > 0 ? getAdicionais() : 0));
			System.out.println("Vegano? " + (isVegano() ? "sim" : "não"));
			System.out.println("Preço: " + calcularPreco());
		} else {
			super.imprimirDetalhes(false);
		}
	}
	
	public static Prato cadastrar(Scanner in) {
		System.out.println("Nome do prato: ");
		String nomePrato = in.nextLine();
		
		System.out.println("Descrição: ");
		String descPrato = in.nextLine();
				
		
		System.out.println("Preço: ");
		double precoPrato = in.nextDouble();
		in.nextLine();
		
		System.out.println("Vegano? (s/n)");
		boolean vegano = in.nextLine().equalsIgnoreCase("s");
		
		System.out.println("Quantidade de adicionais: ");
		int adicionais = in.nextInt();
		
		in.nextLine();
		
		System.out.println("Categoria do prato: ");
		System.out.println("1 - Entrada");
		System.out.println("2 - Prato Principal");
		System.out.println("Opção: ");
		int cat = in.nextInt();
		in.nextLine();
		
		Categoria categoria = (cat == 1) ? Categoria.ENTRADA : Categoria.PRATO_PRINCIPAL;
		return new Prato(nomePrato, precoPrato, descPrato, vegano, adicionais, categoria);
	
	}

	
//	public String toString() {
//		return "--- Prato ---" +
//		       "\nNome: " + getNome() +
//		       "\nDescrição: " + getDescricao() +
//		       "\nCategoria: " + categoria +
//		       "\nVegano: " + (vegano ? "Sim" : "Não") +
//		       "\nAcompanhamentos: " + adicionais +
//		       "\nPreço final: R$ " + calcularPreco();
//	}
}

