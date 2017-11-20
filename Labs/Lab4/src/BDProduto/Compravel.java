package BDProduto;

import java.util.List;

public interface Compravel {
	public String getNome();
	public double getPreco();
	public String getSetorResponsavel();
	public String getCategoriaTributaria();
	public List<Compravel> getListaSubCompraveis();
	public void setTaxacao(double taxacao);
	public double getImposto();
}
