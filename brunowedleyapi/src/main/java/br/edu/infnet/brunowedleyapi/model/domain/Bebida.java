package br.edu.infnet.brunowedleyapi.model.domain;

import java.util.Scanner;

import br.edu.infnet.brunowedleyapi.utils.ValidacoesUtil;

public class Bebida extends ProdutoCardapio{
	private boolean alcoolica;
	public Bebida(String nome, double precoBase, String descricao, int quantidade, boolean alcoolica) {
		super(nome, precoBase, descricao, quantidade, Categoria.BEBIDA);
		this.setAlcoolica(alcoolica);
	}
	
	@Override
	public double calcularPreco() {
		return getPrecoBase();
	}
	public boolean isAlcoolica() {
		return alcoolica;
	}
	public void setAlcoolica(boolean alcoolica) {
		this.alcoolica = alcoolica;
	}
	
	public static Bebida cadastrar(Scanner in) {
//		System.out.println("Nome da bebida: ");
//		String nomeBebida = in.nextLine();
//		
//		System.out.println("Descrição: ");
//		String descBebida = in.nextLine();
//		
//		System.out.println("Preço: ");
//		double precoBebida = in.nextDouble();
//		in.nextLine();
//		
//		System.out.println("Alcoólica? (s/n)");
//		boolean alcoolica = in.nextLine().equalsIgnoreCase("s");
		
		String nomeBebida = ValidacoesUtil.validarStringObrigatoria(in, "Nome da bebida:");
		String descBebida = ValidacoesUtil.validarStringObrigatoria(in, "Descrição: ");
		
		double precoBebida;
		while(true) {
			try {
				precoBebida = ValidacoesUtil.validarDoublePositivo(in,  "Preço: ");
				break;
			} catch (IllegalArgumentException e) {
				System.out.println("Erro: " + e.getMessage());
				continue;
			}
		}
		
		int qtdeEstoque = ValidacoesUtil.validarIntPositivo(in, "Quantidade em estoque: ");
		boolean alcoolica = ValidacoesUtil.validarBoolean(in, "É alcoólica? ");
		
		return new Bebida(nomeBebida, precoBebida, descBebida, qtdeEstoque, alcoolica);
	
	}
	
	@Override
	public void imprimirDetalhes(boolean completo) {
		super.imprimirDetalhes(completo);
		if(completo) {
			System.out.println("Alcoólica? " + (alcoolica ? "sim" : "não"));
		}
	}

}
