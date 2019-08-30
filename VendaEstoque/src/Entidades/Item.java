package Entidades;

public class Item {

	private Produto produto;
	private int quantidadeVendida;
	
	public Item() {
	}

	public Item(Produto produto, int quantidadeVendida) {
		this.produto = produto;
		this.quantidadeVendida = quantidadeVendida;
	}

	public int getQuantidadeVendida() {
		return quantidadeVendida;
	}

	public Produto getProduto() {
		return produto;
	}
	
	public void removerQuantidadeEstoque() {
		produto.setQuantidadeDoProduto(produto.getQuantidadeDoProduto() - quantidadeVendida);
	}

	
	public String toString() {
		return "" + produto + 
				"\nQuantidade Vendida: " + getQuantidadeVendida() + 
				"\n";
	}
}
