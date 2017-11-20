package NotaFiscal;
import java.util.List;

import BDProduto.BDProduto;
import BDProduto.Compravel;
import ItemVenda.Estoque;
import ItemVenda.ItemVenda;

import java.util.ArrayList;
import java.util.Collections;

public class NotaFiscal {
	private int id;
	private Estoque estoque;
	private List<ItemVenda> itemList;
	private BDNF bdNF;
	private BDProduto bdProdutos;
	private String status;
	private BDTax bdTax;
	private String statusCliente = "nao validado ainda";
	private String CPF;
	private SPC spc;
	
	// Constructor
	public NotaFiscal(int quantidadeProduto, String nomeProduto, BDProduto vendas, Estoque estoque, String CPF) throws NullPointerException {
		this.estoque = estoque;
		this.status = "em elaboracao";
		this.bdNF = BDNF.getInstance();
		this.bdProdutos = vendas;
		this.bdTax = BDTax.getInstance();
		itemList = new ArrayList<ItemVenda>();
		this.CPF = CPF;
		this.spc = SPC.getInstance();
		try {
			Compravel venda = vendas.getCompravel(nomeProduto);
			if (estoque.disponibilidadeDeProduto(venda) >= quantidadeProduto) {
				ItemVenda newItem = new ItemVenda(this, venda, quantidadeProduto);
				estoque.retirarProduto(venda, quantidadeProduto);
				itemList.add(newItem);
			} else {
				throw new NullPointerException();
			}
		}
		catch (NullPointerException e){
			throw e;
		}

	} // End constructor
	
	
	public List<ItemVenda> getItemList() {
		return Collections.unmodifiableList(this.itemList);
	}
	
	private void taxar() {
		new StrategyImpostos(this.itemList);
	}
	
	public boolean addItem(String itemName, int quantidade) {
		if (this.status == "em elaboracao") {
			Compravel compra = bdProdutos.getCompravel(itemName);
			if(compra == null) throw new NullPointerException();
			
			if (estoque.disponibilidadeDeProduto(compra) >= quantidade) {
				estoque.retirarProduto(compra, quantidade);
				ItemVenda newItem = new ItemVenda(this, compra, quantidade);
				itemList.add(newItem);
				return true;
			}
		}
		return false;
	}
	
	public int getId() {
		return this.id;
	}
	
	void setId(int id) {
		this.id = id;
	}
	
	public boolean removeItem(String toRemove) {
		if (this.status == "em elaboracao") {
			if (itemList.size() > 1) {
				int count = 0;
				for (ItemVenda item: itemList) {
					if (item.getVenda().getNome().equals(toRemove)) {
						estoque.devolverProduto(item.getVenda(), item.getQuantidade());
						itemList.remove(count);
						return true;
					}
					count ++;
				}
			}
		}
		return false;
	}
	
	public double getPreco() {
		double total = 0;
		for (ItemVenda item : itemList) {
			total += item.getPreco();
		}
		return total;
	}
	
	public double getPrecoTaxado() {
		double total = 0;
		for (ItemVenda item : itemList) {
			total += item.getPrecoTaxado();
		}
		return total;
	}

	public void validar() throws Exception {
		try {
			if(this.statusCliente == "validado") {
				if (this.status == "em elaboracao") {
					bdNF.validarNF(this);
				}else
					throw new Exception("A nota fiscal nao pode ser validada novamente pelo Banco de Dados.\n");
			} else if (this.statusCliente == "nao validado ainda") { 
				throw new Exception("Cliente ainda nao validado.\n");
			} else { 
				throw new Exception("O cliente foi invalidado, e a nota fiscal nao podera ser validada.\n");
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void validarCliente() throws Exception {
		try {
			if (this.statusCliente == "nao validado ainda") {
				statusCliente = spc.validarCPF(CPF);
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	void setStatus(String status) {
		this.status = status;
	}
	
	String getStatus() {
		return this.status;
	}
	
	void setStatusCliente(String statusCliente) {
		this.statusCliente = statusCliente;
	}
	
	public String printNF() {
		String message = new String();
		message = status + "\n";
		if (this.status == "em elaboracao") {
			message+="ID ainda não definido\n";
		}

		if(this.status == "validada"){
			message+="ID: " + Integer.toString(id) + "\n";
		}
		for (ItemVenda item : itemList) {
			message+=item.toString()+"\n";
		}
		message += "Total: "+Double.toString(getPreco())+"\n";
		this.taxar();
		double totalTax = getPrecoTaxado();
		//truncate
		totalTax = Math.round(100*totalTax)/100.0;
		
		message += "Total Taxado: "+Double.toString(totalTax)+"\n";
		
		return message;
	}
	
}