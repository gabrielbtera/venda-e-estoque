package Entidades;


import java.util.ArrayList;
import java.util.List;
public class Venda {

	//private Item item1;
	private int codigoVenda;
	private Cliente cliente;
	private String dataVenda;
	private int quantidadeProdutosVendidos;
	List<Item> item = new ArrayList<>();

	public Venda() {
	}

	public Venda(int codigoVenda, Cliente cliente, String dataVenda, List<Item> item) {
		this.codigoVenda = codigoVenda;
		this.cliente = cliente;
		this.dataVenda = dataVenda;
		this.item = item;
		estoque();

	}

	public Cliente getCliente() {
		return cliente;
	}

	public String getDataVenda() {
		return dataVenda;
	}

	public int getCodigoVenda() {
		return codigoVenda;
	}

	public int getQuantidadeItensVendidos() {
		return quantidadeProdutosVendidos;
	}

	public void setQuantidadeItensVendidos(int quantidadeProdutosVendidos) {
		this.quantidadeProdutosVendidos = quantidadeProdutosVendidos;
	}

	/*
	 * public void addNaVenda(Item item, int quantidadeVendida, List<Produto>
	 * produto) { this.item.add(new Item(produto, quantidadeVendida)); }
	 */

	public double valorTotalVenda() {
		double vendaTotal = 0;
		for (int x = 0; x < quantidadeProdutosVendidos; x++) {
			vendaTotal += item.get(x).getQuantidadeVendida() * item.get(x).getProduto().getPrecoVenda();
		}
		return vendaTotal;
	}

	public void estoque() {
		for (Item x : item)
			x.removerQuantidadeEstoque();
	}

	/*
	 * public String listarTodasAsVendas() { for (Item x : item) { return "Nome: " +
	 * x.getProduto().getNome() + "\nQuantidade vendida: " +
	 * x.getQuantidadeVendida(); } return "==============";
	 * 
	 * }
	 */

	public void imprimir() {
		if (item.size() > 0) {
			System.out.println("Nome Cliente: " + cliente.getNome() + "\n" + "Codigo cliente: " + cliente.getCodigo() + " \nData Venda: " + dataVenda);
			for (Item x : item)
				System.out.println(x);
		}else 
			System.out.println("Nao ha itens");
	}

	public String toString() {
		return "Cliente: " + cliente.getNome() + "\nData da venda: " + dataVenda + "\nCodigo da Venda: " + codigoVenda
				+ "\nQuantidade de itens Vendidos: " + quantidadeProdutosVendidos +
				"\nValor Total da Venda: R$" + valorTotalVenda();
	}
	// gabriel_btera@outlook.com
}
