package Entidades;

public class Produto {
	private int codigoProduto;
	private String marca;
	private String nome;
	private double precoVenda;
	private int quantidadeDoProduto;
	
	public Produto() {
	}

	public Produto(int codigoProduto,String marca, String nome, double precoVenda, int quantidadeDoProduto) {
		this.codigoProduto = codigoProduto;
		this.marca = marca;
		this.nome = nome;
		this.precoVenda = precoVenda;
		this.quantidadeDoProduto = quantidadeDoProduto;
	}

	public int getCodigo() {
		return codigoProduto;
	}

	public String getMarca() {
		return this.marca;
	}
	public String getNome() {
		return nome;
	}

	public double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public int getQuantidadeDoProduto() {
		return quantidadeDoProduto;
	}
	
	public void setQuantidadeDoProduto(int quantidade) {
		this.quantidadeDoProduto = quantidade;
	}

	public void addQuantidadeDoProduto(int quantidadeAdicionada) {
		this.quantidadeDoProduto += quantidadeAdicionada;
	}
	
	
	
	public String toString() {
		return "Codigo do Produto: " + codigoProduto + 
				"\nMarca do Produto: " + marca +
				"\nNome do Produto: " + nome + 
				"\nPreco de Venda: " + precoVenda + 
				"\nQuantidade em estoque do Produto: " + quantidadeDoProduto;
	}
	
	
}
