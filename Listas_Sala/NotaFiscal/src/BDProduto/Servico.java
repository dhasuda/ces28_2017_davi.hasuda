package BDProduto;

public class Servico implements Compravel {
	private String nome;
	private double preco;
	
	Servico(String nome, double preco){
		this.nome = nome;
		this.preco = preco;
	}
	
	@Override
	public String getNome() {
		return this.nome;
	}

	@Override
	public double getPreco() {
		return this.preco;
	}

}
