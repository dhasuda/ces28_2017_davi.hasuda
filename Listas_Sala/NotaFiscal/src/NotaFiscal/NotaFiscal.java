package NotaFiscal;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import BDCliente.BDCliente;
import BDCliente.Cliente;
import BDCliente.VerificadorCPF;
import BDProduto.BDProduto;
import BDProduto.Item;
import BDProduto.Compravel;

public class NotaFiscal {
	private int id;
	private Cliente cliente;
	private List<Item> itemList;
	private BDProduto bdProdutos;
	
	// Constructor
	public NotaFiscal(int id, String cpf, int quantidadeProduto, String nomeProduto, BDCliente cadastro, VerificadorCPF verificador, BDProduto vendas) throws NullPointerException {
		this.bdProdutos = vendas;
		itemList = new ArrayList<Item>();
		
		this.id = id;
		
		try {
			cliente = cadastro.getCliente(cpf);
		}
		catch (NullPointerException e){
			throw e;
		}
		try {
			Compravel venda = vendas.getCompravel(nomeProduto);
			Item newItem = new Item(venda, quantidadeProduto);
			itemList.add(newItem);
		}
		catch (NullPointerException e){
			throw e;
		}
		if (!verificador.CPFValido(cpf)) {
			throw new NullPointerException();
		}
	} // End constructor
	
	public Cliente getCliente() {
		return this.cliente;
	}
	
	public List<Item> getItemList() {
		return Collections.unmodifiableList(this.itemList);
	}
	
	public void addItem(String itemName, int quantidade) {
		Compravel compra = bdProdutos.getCompravel(itemName);
		Item newItem = new Item(compra, quantidade);
		itemList.add(newItem);
	}
	
	public int getId() {
		return this.id;
	}
	
	public boolean removeItem(String toRemove) {
		if (itemList.size() > 1) {
			int count = 0;
			for (Item item: itemList) {
				if (item.getVenda().getNome().equals(toRemove)) {
					//Item removedItem = new Item(item.getVenda(), item.getQuantidade());
					itemList.remove(count);
					return true;
				}
				count ++;
			}
		}
		return false;
		
		//		if (itemList.size() > 1) {
//			return itemList.remove(toRemove);
//		}
//		return false;
	}
	
	public double getPreco() {
		double total = 0;
		for (Item item : itemList) {
			total += item.getPreco();
		}
		return total;
	}
	
}