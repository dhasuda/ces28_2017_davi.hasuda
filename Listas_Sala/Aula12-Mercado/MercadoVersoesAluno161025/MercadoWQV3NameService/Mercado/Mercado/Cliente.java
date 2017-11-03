package Mercado;


public class Cliente {
	private int id;
	private String nome;
	private Carrinho carrinho;
	private Cliente(String nome, int id) {
		this.id = id;
		this.nome = nome;
	}
	public static Cliente create(String nome, int id) {
		return new Cliente(nome, id);
	}
	public void adicionarCarrinho(Carrinho c) {
		this.carrinho = c;
	}
	public Carrinho getCarrinho() {
		return carrinho;
	}
	public int getId() {
		return id;
	}
}