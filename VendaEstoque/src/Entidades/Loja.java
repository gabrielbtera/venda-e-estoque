package Entidades;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Loja {
	Scanner input = new Scanner(System.in);
	Item item = new Item();
	List<Cliente> cliente = new ArrayList<>();
	List<Venda> venda = new ArrayList<>();
	List<Produto> produto = new ArrayList<>();
	Date d= new Date();
	private String dataVenda = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);

	public Loja() {
	}

	// Cadastro e Listagem dos Produtos
	public void adicionarProdutos(int codigoProduto, String marca, String nome, double precoVenda,
			int quantidadeDoProduto) {
		int z = 0;
		for (Produto x : produto)
			if (codigoProduto == x.getCodigo()) {
				z++;
				break;
			}
		if (z == 0) {
			produto.add(new Produto(codigoProduto, marca, nome, precoVenda, quantidadeDoProduto));
			System.out.println("Produto com Codigo " + codigoProduto + " Realizado Com Sucesso");
		} else
			System.out.println("Codigo do Produto ja existe no sitema, Cadastro nao Realizado");

	}

	public void listarProdutosCadastrados() {
		System.out.println("Produtos disponiveis na loja:\n");
		if (produto.size() == 0) {
			System.out.println("Ainda nao ha produtos cadastrados");
		} else
			for (Produto x : produto) {
				if (x.getQuantidadeDoProduto() > 0) {
					System.out.println(x + "\nProduto Disponivel no estoque");
					System.out.println("\n==================================");
				} else {
					System.out.println(x + "\nProduto Indisponivel no estoque");
					System.out.println("\n==================================");
				}
			}
	}

	public void listarProdutoDisponivelNoEstoque() {
		System.out.println("Produtos Disponiveis:\n");
		for (Produto x : produto) {
			if (x.getQuantidadeDoProduto() > 0) {
				System.out.println(x + "\nProduto Disponivel no estoque");
				System.out.println("\n==================================");
			}
		}
	}

	public void listarProdutosEsgotados() {
		System.out.println("Produtos esgotados:\n");
		for (Produto x : produto) {
			if (x.getQuantidadeDoProduto() == 0) {

				System.out.println(x);
				System.out.println("\n==================================");
			}
		}
	}

	public void addQuantidadeDeProdutos(Produto produto, int addQuantidade) {
		produto.addQuantidadeDoProduto(addQuantidade);
	}

	// Cadastrar clientes
	public void cadastrarCliente(int codigoCliente, String nome) {
		int y = 0;
		for (Cliente x : cliente)
			if (codigoCliente == x.getCodigo()) {
				y++;
				break;
			}

		if (y == 0) {
			cliente.add(new Cliente(codigoCliente, nome));
			System.out.println("Cadastro de " + nome + " Realizado com Sucesso");

		} else
			System.out.println("Codigo do cliente ja existe no sitema, Cadastro Nao Realizado");
	}

	public void listarClienteCadastrados() {
		if (cliente.size() == 0) {
			System.out.println("Ainda nao ha clientes cadastrados, se deseja cadastrar digite sim ");
		} else
			for (Cliente x : cliente) {
				System.out.println(x + "\n");

			}
	}

	// Adicionar vendas
	public void cadastrarVenda(int codigo, Cliente cliente, List<Item> item) {
		venda.add(new Venda(codigo, cliente,  dataVenda, item));
	}

	// Listar Vendas
	public void listarVendas() {
		for (Venda x : venda) {
			System.out.println(x);
		}
	}

	// listar vendas por clientes
	public void listarVendaCliente(int codigoDoCliente) {
		int contaVenda = 0;
		for (Cliente testeCliente : cliente) {
			if (testeCliente.getCodigo() == codigoDoCliente)
				for (Venda testeVenda : venda) {
					if (testeVenda.getCliente().getCodigo() == codigoDoCliente) {
						System.out.println(testeVenda);
						contaVenda++;
					}
				}
		}
		if (contaVenda == 0)
			System.out.println("Nao ha vendas para este cliente");
	}

}
