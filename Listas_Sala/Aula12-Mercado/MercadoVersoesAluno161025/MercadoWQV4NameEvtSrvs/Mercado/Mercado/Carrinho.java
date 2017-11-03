package Mercado;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class Carrinho {
	List<Produto> listaDeCompas;
	private Carrinho() {
		listaDeCompas = new ArrayList<>();
	}
	public static Carrinho create() {
		return new Carrinho();
	}
	public void adicionar(Produto p) {
		listaDeCompas.add(p);
	}
	public double getTotal() {
		double total = 0;
		for (Iterator<Produto> p = listaDeCompas.iterator(); p.hasNext();) {
			Produto produto = (Produto) p.next();
			System.out.println("Valor do item: " + produto.getPreco());
			total += produto.getPreco();
		}
		return total;
	}
}