package br.edu.infnet.brunowedleyapi.model.domain;

import java.util.Scanner;

import br.edu.infnet.brunowedleyapi.utils.ValidacoesUtil;

public class Sobremesa extends ProdutoCardapio{
	private boolean diet;

	public Sobremesa(String nome, double precoBase, String descricao, boolean diet) {
		super(nome, precoBase, descricao, Categoria.SOBREMESA);
		this.setDiet(diet);
		
	}

	@Override
	public double calcularPreco() {
		return getPrecoBase();
	}

	public boolean isDiet() {
		return diet;
	}

	public void setDiet(boolean diet) {
		this.diet = diet;
	}
	
	public String toString() {
		return super.toString() + "\nDiet: " + (diet ? "Sim" : "Não");
	}
	
	public static Sobremesa cadastrar(Scanner in) {
//		System.out.println("Nome da sobremesa: ");
//		String nomeSobremesa = in.nextLine();
//		
//		System.out.println("Descrição: ");
//		String descSobremesa = in.nextLine();
//		
//		System.out.println("Preço: ");
//		double precoSobremesa = in.nextDouble();
//		in.nextLine();
//		
//		System.out.println("Diet? (s/n)");
//		boolean diet = in.nextLine().equalsIgnoreCase("s");
		
		String nomeSobremesa = ValidacoesUtil.validarStringObrigatoria(in, "Nome do prato:");
		String descSobremesa = ValidacoesUtil.validarStringObrigatoria(in, "Descrição: ");
		
		double precoSobremesa;
		while(true) {
			try {
				precoSobremesa = ValidacoesUtil.validarDoublePositivo(in,  "Preço: ");
				break;
			} catch (IllegalArgumentException e) {
				System.out.println("Erro: " + e.getMessage());
				continue;
			}
		}
		boolean diet = ValidacoesUtil.validarBoolean(in, "É diet? ");
		
		
		return new Sobremesa(nomeSobremesa, precoSobremesa, descSobremesa, diet);
		
	}
	
	@Override
	public void imprimirDetalhes(boolean completo) {
		super.imprimirDetalhes(completo);
		if(completo) {
			System.out.println("Diet? " + (diet ? "sim" : "não"));
		}
		
	}

}
