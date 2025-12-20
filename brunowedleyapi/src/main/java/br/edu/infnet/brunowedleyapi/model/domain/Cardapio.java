package br.edu.infnet.brunowedleyapi.model.domain;


import java.util.ArrayList;
import java.util.List;

public class Cardapio {
	private List<ProdutoCardapio> produtos;
	
	public Cardapio() {
		this.produtos = new ArrayList<>();
	}
	
	public void adicionarProduto(ProdutoCardapio produto) {
		if(produto == null) {
			throw new IllegalArgumentException("Produto inválido...");
		}
		produtos.add(produto);
	}
	
	public void listarProdutos() {
		if(produtos.isEmpty()) {
			System.out.println("Nenhum produto cadastrado!");
			return;
		}
		
		System.out.println("=======CARDÁPIO=======");
		for (ProdutoCardapio produto : produtos) {
			produto.imprimirDetalhes(true);
			System.out.println("=====================");
		}
	}
	
	public void listarProdutosCategoria() {
		if(produtos.isEmpty()) {
			System.out.println("Nenhum produto cadastrado");
			return;
		}
		
		for(ProdutoCardapio.Categoria cat : ProdutoCardapio.Categoria.values()) {
			//boolean para fazer com que apenas a categoria com produtos cadastrados apareça na listagem
			boolean produtoCadastrado = false;
			for(ProdutoCardapio p : produtos) {
				if(p.getCategoria() == cat) {
					if(!produtoCadastrado) {
						System.out.println("=======" + cat + "=======");
						produtoCadastrado = true;
					}
					p.imprimirDetalhes(true);
					System.out.println("=====================");
				}
			}
		}
	}
}
