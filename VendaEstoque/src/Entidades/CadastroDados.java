package Entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroDados {
	Scanner input = new Scanner(System.in);
	Loja loja = new Loja();

	public CadastroDados() {
	}

	public void ImprimeMenu() {
		System.out.println();
		System.out.println("BEM VINDO A LOJA SHOSTNERS CABLE");
		System.out.println("========================================================");
		System.out.println("========================= MENU =========================");
		System.out.println("========================================================");
		System.out.println();
		System.out.println("1. Listar todos os produtos cadastrados\r\n"
				+ "2. Listar os produtos disponíveis no estoque\r\n"
				+ "3. Listar todos os produtos esgotados no estoque\r\n"
				+ "4. Aumentar a quantidade de produtos no estoque\r\n" + "5. Cadastrar um cliente\r\n"
				+ "6. Listar os clientes cadastrados\r\n" + "7. Cadastrar vendas\r\n" + "8. Listar todas as vendas\r\n"
				+ "9. Listar compras de um determinado cliente\r\n" + "10. Cadastrar Produtos\r\n"
				+ "11. Verificar informacoes de determinada Venda\r\n" + "12. Encerrar Menu\r\n");
	}

	public void cadastroAutoClienteEProdutos() {
		loja.cadastrarCliente(968, "Gabriel");
		loja.cadastrarCliente(969, "vitor");
		loja.adicionarProdutos(123, "CCE", "NotBook", 500, 50);
		loja.adicionarProdutos(122, "Acer", "NotBook", 1590.90, 50);
		loja.adicionarProdutos(124, "Azus", "NotBook", 1000, 0);
	}

	// Cadastrar Produtos;
	public void cadastroDeProdutoInput() {
		for (String verificarCadastroDeProduto = "sim"; verificarCadastroDeProduto.equalsIgnoreCase("sim");) {
			System.out.print("Digite o Codigo para este produto: ");
			int codigoProduto = input.nextInt();

			System.out.print("Digite a marca deste produto: ");
			String marca = input.next();

			System.out.print("Digite o nome para este produto: ");
			String nome = input.next();

			System.out.print("Digite o preco de Venda para este produto: ");
			double precoVenda = input.nextDouble();
			System.out.print("Digite a quantidade em estoque: ");
			int quantidadeDoProduto = input.nextInt();

			loja.adicionarProdutos(codigoProduto, marca, nome, precoVenda, quantidadeDoProduto);

			System.out.println("Caso deseje cadastrar algum novo produto digite sim");
			verificarCadastroDeProduto = input.next();
		}
	}

	// Adicionar Produtos
	public void adicionarQuantidadeDeProdutoInput() {
		System.out.println("Digite o Codigo do produto a ser adicionado");
		int testeCodigoAdicionar = input.nextInt();
		System.out.println("Digite a quantidade de Produtos a serem adicionadas");
		int adicionarQuantidadeNoEstoque = input.nextInt();

		int verificadorProduto = 0;
		for (Produto testeCodigo : loja.produto) {
			if (testeCodigo.getCodigo() == testeCodigoAdicionar) {
				loja.addQuantidadeDeProdutos(testeCodigo, adicionarQuantidadeNoEstoque);
				System.out.println("Quantidade Adicionada Com Sucesso");
				verificadorProduto++;
			}
		}

		if (verificadorProduto == 0)
			System.out.println("Produto nao Encontrado no Estoque");
	}

	// Listagem de Produtos;
	public void listarProdutosCadastradosImput() {
		loja.listarProdutosCadastrados();
	}

	// Listar Produtos disponiveis no estoque;
	public void listarProdutosDisponiveisNoEstoqueInput() {
		loja.listarProdutoDisponivelNoEstoque();
	}

	// Listar Produtos Esgotados no Estoque;
	public void listarProdutosEsgotadosInput() {
		loja.listarProdutosEsgotados();
	}

	// Cadastro de Clientes;
	public void cadastroDeClienteImput() {
		System.out.println("Cadastro de  Cliente: ");
		for (String verificarCadastroCliente = "sim"; verificarCadastroCliente.equalsIgnoreCase("sim");) {
			System.out.println("Digite o Codigo do cliente: ");
			int codigoCliente = input.nextInt();

			System.out.println("Digite o nome deste Cliente: ");
			String nome = input.next();

			loja.cadastrarCliente(codigoCliente, nome);

			System.out.println("Se desejar cadastrar mais algum cliente digite sim");
			verificarCadastroCliente = input.next();
		}
	}

	// Listagem de Clientes;
	public void listarClienteInput() {
		loja.listarClienteCadastrados();
	}

	// Cadastro de Vendas;
	public void cadastroDasVendasInput() {
		int codigoVenda = 100;
		for (String verificarCadastroVendas = "sim"; verificarCadastroVendas.equalsIgnoreCase("sim");) {

			// Lista de itens de uma venda;
			List<Item> itemVenda = new ArrayList<>();

			// Cadastro dos itens de uma venda;
			int verificaSeAddProduto = 0;
			int verificaAchaProduto = 0;
			for (String verificarVenda = "sim"; verificarVenda.equalsIgnoreCase("sim");) {

				System.out.println("Digite o Codigo do produto a ser Vendido");
				int codigoProduto = input.nextInt();

				// Verifica se o produto esta no estoque e faz o cadastro de um item na venda
				for (int x = 0; x < loja.produto.size(); x++) {
					if ((loja.produto.get(x).getCodigo() == codigoProduto)) {
						verificaAchaProduto++;
						if ((loja.produto.get(x).getQuantidadeDoProduto() > 0)) {
							System.out.println("Digite a quantidade de itens deste produto: ");
							int quantidadeItensVendidos = input.nextInt();
							if (loja.produto.get(x).getQuantidadeDoProduto() >= quantidadeItensVendidos) {
								itemVenda.add(new Item(loja.produto.get(x), quantidadeItensVendidos));
								verificaSeAddProduto++;
							}
							
						}else {
							System.out.println("Quantidade de produtos indisponivel no estoque");
							break;
						}

					}	
				}

				if(verificaAchaProduto == 0)
					System.out.println("Produto inexistente no sistema");;
				
				// verifica se quer mais algum item
				System.out.println("Deseja cadastrar mais algum item, digite sim para continuar: ");
				verificarVenda = input.next();

			}
			// Verifica Cadastro de Cliente;
			System.out.println("Digite o codigo do cliente");
			int codigoCliente = input.nextInt();
			int verificadorCliente = 0;
			//LEMBRAR DA DATA _'OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO;
			//Date d= new Date();
			//String dataVenda = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
			for (Cliente cliente : loja.cliente) {
				if ((cliente.getCodigo() == codigoCliente) && (verificaSeAddProduto > 0)) {
					loja.cadastrarVenda(codigoVenda, cliente, itemVenda);
					loja.venda.get(loja.venda.size() - 1).setQuantidadeItensVendidos(itemVenda.size());
					verificadorCliente++;
					codigoVenda++;
				}
			}

			if (verificadorCliente == 0) {
				System.out.println(
						"Cliente ainda nao cadastrado, digite sim para cadastrar o cliente e volte ao Item Venda ou nao realiza a venda");

				if (verificaSeAddProduto == 0)
					System.out.println("Venda Nao Concluida ");

				String verificarCadastro = input.next();
				if (verificarCadastro.equalsIgnoreCase("sim"))
					cadastroDeClienteImput();
				else
					System.out.println("E preciso cadastrar um cliente para realizar uma venda");
			}

			System.out.println("Deseja Continuar Adiiconando Vendas, digite sim para continuar:");
			verificarCadastroVendas = input.next();
		}
	}

	// Listagem das vendas
	public void listarVendasInput() {
		loja.listarVendas();
	}

	// Verificar Informacoes da Venda;
	public void verificarInformacoesDeUmaVendaInput() {
		System.out.println("Deseja saber o informacoes de alguma venda, digite sim para continuar");
		String verificarInformacoesDaVenda = input.next();
		if (verificarInformacoesDaVenda.equalsIgnoreCase("sim")) {
			// Verifica Codigo Venda
			System.out.println("Digite o codigo da venda");
			int codigoTesteVenda = input.nextInt();
			int contarCodigoVenda = 0;
			for (int i = 0; i < loja.venda.size(); i++) {
				// Procura o codigo na lista, e printa quando encontrar
				if (loja.venda.get(i).getCodigoVenda() == codigoTesteVenda) {
					loja.venda.get(i).imprimir();
					contarCodigoVenda++;
				}
					
			}
			
			if(contarCodigoVenda == 0)
				System.out.println("Nao ha venda com esse codigo");
		}
	}

	// Listagem de Cliente Por Venda;
	public void listaClientePorVendaInput() {
		System.out.println("Digite o codigo do cliente a ser verificado");
		int codigoVerificarCliente = input.nextInt();
		loja.listarVendaCliente(codigoVerificarCliente);
		
		System.out.println("===================");
	}

}
