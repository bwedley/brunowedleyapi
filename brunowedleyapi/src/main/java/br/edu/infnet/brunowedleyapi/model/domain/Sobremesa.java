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
			precoSobremesa = ValidacoesUtil.validarDoublePositivo(in,  "Preço: ");
			try {
				new Prato().setPrecoBase(precoSobremesa);
				break;
			} catch (IllegalArgumentException e) {
				System.out.println("Erro: " + e.getMessage());
			}
		}
		boolean diet = ValidacoesUtil.validarBoolean(in, "É diet? ");
		
		
		return new Sobremesa(nomeSobremesa, precoSobremesa, descSobremesa, diet);
		
	}
	
	
	public void imprimirDetalhes(boolean completo) {
		if(completo) {
			System.out.println("Nome: " + getNome());
			System.out.println("Descrição: " + getDescricao());
			System.out.println("Diet: " + (diet ? "Sim" : "Não"));
			System.out.println("Preço: " + calcularPreco());
				
		} else {
			super.imprimirDetalhes(false);
		}
		
	}

}
