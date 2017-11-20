package NotaFiscal;

import java.util.List;

import BDProduto.Compravel;

public interface Imposto {
	double getAliquota(String categoriaTributaria);
	double calculoImposto(double preco, int quantidade,
			String categoriaTributaria, List<Compravel> subCompraveis);
	public double getValorImposto(double preco, int quantidade,
			String categoriaTributaria, List<Compravel> subCompraveis);
}
