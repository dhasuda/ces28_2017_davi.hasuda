package BDCliente;

public class Cliente {
	private String nome;
	private String cpf;
//	private String endereco;
//	private String telefone;
	
	Cliente(String nome, String cpf, String endereco, String telefone) {
		this.nome = nome;
		this.cpf = cpf;
//		this.endereco = endereco;
//		this.telefone = telefone;
	}
	
	public String getCPF() {
		return this.cpf;
	}
	
	public String getNome() {
		return this.nome;
	}
}
