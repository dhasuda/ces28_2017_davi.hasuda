package BDProduto;

public class Produto implements Compravel {
	private String nome;
	private double preco;
	
	Produto(String nome, double preco){
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
