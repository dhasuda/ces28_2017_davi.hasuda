package BDProduto;

public class Item {
	private Compravel venda;
	private int quantidade;
	
	public Item(Compravel venda, int quantidade) {
		this.venda = venda;
		this.quantidade = quantidade;
	}
	
	public int getQuantidade() {
		return this.quantidade;
	}
	
	public Compravel getVenda() {
		return this.venda;
	}
	
	public double getPreco() {
		return this.venda.getPreco() * (double)this.quantidade;
	}
}
