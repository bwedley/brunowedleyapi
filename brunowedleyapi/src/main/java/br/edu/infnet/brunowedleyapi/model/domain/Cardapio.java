package br.edu.infnet.brunowedleyapi.model.domain;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.infnet.brunowedleyapi.model.domain.ProdutoCardapio.Categoria;
import br.edu.infnet.brunowedleyapi.utils.ValidacoesUtil;

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
	
	public boolean removerProdutoPorId(int id) {
		return produtos.removeIf(produto -> produto.getId() == id);
	}
	
	//Aqui a opção por remover produto com o método abaixo foi unicamente pra poder recuperar o nome
	//já que na função anterior o retorno é booleano.
	public ProdutoCardapio removerProdutoId(int id) {
		for(int i = 0; i < produtos.size(); i++) {
			if(produtos.get(i).getId() == id) {
				return produtos.remove(i);
			}
		}
		return null;
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
	
	public void listarProdutosPorCategoria(Scanner in) {
		int opcaoCat;
		
		do {
			System.out.println("Escolha a categoria que deseja exibir:");
			System.out.println("1 - Entrada");
			System.out.println("2 - Prato Principal");
			System.out.println("3 - Bebida");
			System.out.println("4 - Sobremesa");
			System.out.println("0 - Voltar");
			
			opcaoCat = ValidacoesUtil.validarOpcao(in, "Opção", 0, 4);
			
			if(opcaoCat == 0) {
				System.out.println("Voltando...");
				break;
			}
			
			Categoria categoriaEscolhida = Categoria.values()[opcaoCat - 1];
			System.out.println("Produtos da categoria " + categoriaEscolhida + ": ");
			
			boolean verificaProdutoExistente = false;
			
			for(ProdutoCardapio produto : produtos) {
				if(produto.getCategoria() == categoriaEscolhida) {
					produto.imprimirDetalhes(true);
					System.out.println("=====================");
					verificaProdutoExistente = true;
				}
			}
			
			if (!verificaProdutoExistente) {
				System.out.println("Nenhum produto encontrado.");
			}
			
		} while(opcaoCat != 0);
		
		
	}
	
	public void listarCategorias() {
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
	
	public ProdutoCardapio listarProdutoPorId(int id) {
		for(ProdutoCardapio produto : produtos) {
			if(produto.getId() == id) {
				produto.imprimirDetalhes(true);
				return produto;
			}
		}
		System.out.println("Id digitado não existente.");
		return null;
	}
}
