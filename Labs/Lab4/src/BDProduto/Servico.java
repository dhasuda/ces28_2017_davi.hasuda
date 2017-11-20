package BDProduto;

import java.util.Collections;
import java.util.List;

public class Servico implements Compravel {
	private String nome;
	private double preco;
	private String setor;
	private String categoriaTributaria;
	private List<Compravel> subCompraveis;
	private double imposto;
	
	Servico(String nome, double preco, String setor, String categoriaTributaria){
		this.nome = nome;
		this.preco = preco;
		this.setor = setor;
		this.categoriaTributaria = categoriaTributaria;
	}
	
	void addSubCompravel(Compravel compravel) {
		subCompraveis.add(compravel);
	}
	
	void removeSubCompravel(Compravel compravel) {
		subCompraveis.remove(compravel);
	}
	
	@Override
	public String getNome() {
		return this.nome;
	}

	@Override
	public double getPreco() {
		return this.preco;
	}
	
	@Override
	public String getSetorResponsavel() {
		return this.setor;
	}
	
	@Override
	public String getCategoriaTributaria() {
		return this.categoriaTributaria;
	}

	@Override
	public List<Compravel> getListaSubCompraveis() {
		return Collections.unmodifiableList(subCompraveis);
	}

	@Override
	public void setTaxacao(double imposto) {
		this.imposto = imposto;
	}
	
	@Override
	public double getImposto() {
		return this.imposto;
	}
}
