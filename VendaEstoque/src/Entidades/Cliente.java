package Entidades;

public class Cliente {
	private int codigoCliente;
	private String nome;
	
	public Cliente() {
	}

	public Cliente(int codigo, String nome) {
		this.codigoCliente = codigo;
		this.nome = nome;
	}

	public int getCodigo() {
		return codigoCliente;
	}

	public String getNome() {
		return nome;
	}
	
	public String toString() {
		return "Nome: " + nome + 
				"\nCodigo do Cliente: " + codigoCliente;
	}
}
