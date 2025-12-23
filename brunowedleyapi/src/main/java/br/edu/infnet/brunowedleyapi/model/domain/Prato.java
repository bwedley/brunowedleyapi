package br.edu.infnet.brunowedleyapi.model.domain;

import java.util.Scanner;

import br.edu.infnet.brunowedleyapi.utils.ValidacoesUtil;

public class Prato extends ProdutoCardapio{

	private boolean vegano;
	
	public Prato(String nome, double precoBase, String descricao, boolean vegano, int quantidade, Categoria categoria) {
		super(nome, precoBase, descricao, quantidade, categoria);
		this.setVegano(vegano);
		
	}
		
	public Prato() {
		this("Prato exemplo", 99.00, "descrição exemplo", false, 2, Categoria.SOBREMESA);
	}
	
	@Override
	public double calcularPreco() {
		double preco = getPrecoBase();
		return preco;
	}
		
	public boolean isVegano() {
		return vegano;
	}

	public void setVegano(boolean vegano) {
		this.vegano = vegano;
	}

	
	@Override
	public void imprimirDetalhes(boolean completo) {
		super.imprimirDetalhes(completo);
		if(completo) {
			System.out.println("Vegano? " + (vegano ? "sim" : "não"));
		}
	}
	
	public static Prato cadastrar(Scanner in) {
		
		String nomePrato = ValidacoesUtil.validarStringObrigatoria(in, "Nome do prato:");
		String descPrato = ValidacoesUtil.validarStringObrigatoria(in, "Descrição: ");
		
		double precoPrato;
		while(true) {
			try {
				precoPrato = ValidacoesUtil.validarDoublePositivo(in,  "Preço: ");
				break;
			} catch (IllegalArgumentException e) {
				System.out.println("Erro: " + e.getMessage());
				continue;
			}
		}
		
		boolean vegano = ValidacoesUtil.validarBoolean(in, "É vegano? ");
		int qtdeEstoque = ValidacoesUtil.validarIntPositivo(in, "Quantidade em estoque: ");
		
		System.out.println("Categoria do prato: ");
		System.out.println("1 - Entrada");
		System.out.println("2 - Prato Principal");
		
		int opcaoCat = ValidacoesUtil.validarOpcao(in, "Opção", 1, 2);
		Categoria categoria = (opcaoCat == 1) ? Categoria.ENTRADA : Categoria.PRATO_PRINCIPAL;
		return new Prato(nomePrato, precoPrato, descPrato, vegano, qtdeEstoque, categoria);
	
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

