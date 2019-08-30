package Entidades;

import java.util.Scanner;

public class MenuPrincipal {

	public static void main(String[] args) {
		Scanner dado =  new Scanner(System.in);
		CadastroDados cadastro = new CadastroDados();
		System.out.println("Cliente e produtos Ja Cadastrados\n");
		cadastro.cadastroAutoClienteEProdutos();
		
		cadastro.ImprimeMenu();
		String decisao = "";
		int numeroOperacao;
		while(decisao != "nao") {
			System.out.println("Digite o numero do correspondente a operacao");
			numeroOperacao = dado.nextInt();
			if(numeroOperacao == 1) {
				System.out.println("......................................");
				cadastro.listarProdutosCadastradosImput();
			}if(numeroOperacao == 2) {
				System.out.println("......................................");
				cadastro.listarProdutosDisponiveisNoEstoqueInput();
			}if(numeroOperacao == 3) {
				System.out.println("......................................");
				cadastro.listarProdutosEsgotadosInput();
			}if (numeroOperacao == 4) {
				System.out.println("......................................");
				cadastro.adicionarQuantidadeDeProdutoInput();
			}if (numeroOperacao == 5) {
				System.out.println("......................................");
				cadastro.cadastroDeClienteImput();
			}if (numeroOperacao == 6) {
				System.out.println("......................................");
				cadastro.listarClienteInput();
			}if (numeroOperacao == 7) {
				System.out.println("......................................");
				cadastro.cadastroDasVendasInput();
			}if (numeroOperacao == 8) {
				System.out.println("......................................");
				cadastro.listarVendasInput();
			}if(numeroOperacao == 9) {
				System.out.println("......................................");
				cadastro.listaClientePorVendaInput();;
			}if(numeroOperacao == 10) {
				System.out.println("......................................");
				cadastro.cadastroDeProdutoInput();
			}if(numeroOperacao == 11) {
				System.out.println("......................................");
				cadastro.verificarInformacoesDeUmaVendaInput();
			}if(numeroOperacao == 12) {
				System.out.println("......................................");
				decisao = "nao";
			}
			
		}
		
		System.out.println("========================================================");
		System.out.println("============== OBRIGADO PELA PREFERENCIA ================");
		System.out.println("========================================================");
		dado.close();
		//cadastro.cadastroAutoClienteEProdutos();
		
		//cadastro.listarClienteInput();
	}

}
