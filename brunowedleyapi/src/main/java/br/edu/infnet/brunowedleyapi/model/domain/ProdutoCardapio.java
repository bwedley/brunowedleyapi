package br.edu.infnet.brunowedleyapi.model.domain;

public abstract class ProdutoCardapio {
	
	private String nome;
	private double precoBase;
	private String descricao;
	private Categoria categoria;
	
	public ProdutoCardapio(String nome, double precoBase, String descricao, Categoria categoria) {
		this.setNome(nome);
		this.setPrecoBase(precoBase);
		this.setDescricao(descricao);
		this.setCategoria(categoria);
	}
	
	public abstract double calcularPreco();
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		if(nome == null || nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Nome do produto é obrigatório!");
		}
 		this.nome = nome;
	}
	
	public double getPrecoBase() {
		return precoBase;
	}
	public void setPrecoBase(double precoBase) {
		if(precoBase < 0) {
			throw new IllegalArgumentException("Preço não pode ser negativo");
		}
		this.precoBase = precoBase;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		if(descricao == null || descricao.trim().isEmpty()) {
			throw new IllegalArgumentException("Descrição do produto é obrigatória!");
		}
		this.descricao = descricao;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		if(categoria == null) {
			throw new IllegalArgumentException("Categoria do produto é obrigatória!");
		}
		this.categoria = categoria;
	}

	public enum Categoria {
		ENTRADA,
		PRATO_PRINCIPAL,
		BEBIDA,
		SOBREMESA
	}
	
	public void imprimirDetalhes() {
		System.out.println("Produto: " + getNome());
		System.out.println("Preço: " + calcularPreco());
	}
	
	public void imprimirDetalhes(boolean completo) {
		if(completo) {
			System.out.println("Produto: " + getNome());
			System.out.println("Descrição: " + getDescricao());
//		System.out.println("Acompanhamentos: " + (getAdicionais() > 0 ? getAdicionais() : 0));
//		System.out.println("Vegano? " + (isVegano() ? "sim" : "não"));
			System.out.println("Preço: " + calcularPreco());
			
		} else {
			imprimirDetalhes();
		}
		
		
	}
	
	public String toString() {
		return "=======" + categoria + "=======" +
				"\nNome: " + nome + "\nDescrição: " + descricao +
				"\nPreco: " + calcularPreco();
	}
}
