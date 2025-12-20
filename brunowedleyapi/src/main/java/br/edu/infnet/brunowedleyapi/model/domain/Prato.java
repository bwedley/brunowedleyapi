package br.edu.infnet.brunowedleyapi.model.domain;

import java.util.Scanner;

import br.edu.infnet.brunowedleyapi.utils.ValidacoesUtil;

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
		final double acompanhamento = 5.00;
		double preco = getPrecoBase();
		if(getAdicionais() > 0) {
			preco += getAdicionais() * acompanhamento;
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
		
		String nomePrato = ValidacoesUtil.validarStringObrigatoria(in, "Nome do prato:");
		String descPrato = ValidacoesUtil.validarStringObrigatoria(in, "Descrição: ");
		
		double precoPrato;
		while(true) {
			precoPrato = ValidacoesUtil.validarDoublePositivo(in,  "Preço: ");
			try {
				new Prato().setPrecoBase(precoPrato);
				break;
			} catch (IllegalArgumentException e) {
				System.out.println("Erro: " + e.getMessage());
			}
		}
		
		boolean vegano = ValidacoesUtil.validarBoolean(in, "É vegano? ");
		int adicionais = ValidacoesUtil.validarIntPositivo(in, "Quantidade de adicionais: ");
		
		System.out.println("Categoria do prato: ");
		System.out.println("1 - Entrada");
		System.out.println("2 - Prato Principal");
		
		int opcaoCat = ValidacoesUtil.validarOpcao(in, "Opção", 1, 2);
		Categoria categoria = (opcaoCat == 1) ? Categoria.ENTRADA : Categoria.PRATO_PRINCIPAL;
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

