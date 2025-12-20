package br.edu.infnet.brunowedleyapi.model.domain;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
	private List<ProdutoCardapio> produtos;
	
	public Pedido() {
		this.produtos = new ArrayList<>();
	}
	
	public void adicionarProduto(ProdutoCardapio produto) {
		produtos.add(produto);
	}
	
	public void mostrarPedido() {
		System.out.println("-------Produtos-------");
		for(ProdutoCardapio p : produtos) {
			p.imprimirDetalhes(true);
			System.out.println();
		}
	}
}
