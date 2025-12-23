package br.edu.infnet.brunowedleyapi.model.domain;

public abstract class ProdutoCardapio {
	
	private static int contadorId = 0; 
	private int id;
	private String nome;
	private double precoBase;
	private String descricao;
	private int quantidade;
	private Categoria categoria;
	
	public ProdutoCardapio(String nome, double precoBase, String descricao, int quantidade, Categoria categoria) {
		this.id = ++contadorId;
		System.out.println("Novo produto criado com ID: " + this.id);
		this.setNome(nome);
		this.setPrecoBase(precoBase);
		this.setDescricao(descricao);
		this.setQuantidade(quantidade);
		this.setCategoria(categoria);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	protected void imprimirDetalhes() {
		System.out.println("Produto: " + getNome());
		System.out.println("Preço: " + calcularPreco());
	}
	
	protected void imprimirDetalhes(boolean completo) {
		if(completo) {
			System.out.println("ID: " + getId());
			System.out.println("Produto: " + getNome());
			System.out.println("Descrição: " + getDescricao());
			System.out.println("Quantidade em estoque: " + getQuantidade());
//		System.out.println("Acompanhamentos: " + (getAdicionais() > 0 ? getAdicionais() : 0));
//		System.out.println("Vegano? " + (isVegano() ? "sim" : "não"));
			System.out.println("Preço: R$" + String.format("%.2f",calcularPreco()));
			
		} else {
			imprimirDetalhes();
		}
		
		
	}
	
	public String toString() {
		return "=======" + categoria + "=======" +
				"\nNome: " + nome + "\nDescrição: " + descricao +
				"\nPreco: R$" + String.format("%.2f",calcularPreco());
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


}
