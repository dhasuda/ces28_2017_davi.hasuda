package NotaFiscal;

import java.util.List;

import BDProduto.Compravel;
import NotaFiscal.BDNF;

public class Imposto2 implements Imposto {
	BDNF bdnf = BDNF.getInstance();
	IImpostoData impostoData = new Imposto2Data();
	private double _aliquota;
	
	public double getAliquota(String categoriaTributaria) {
		_aliquota = 0.01;
		
		switch(categoriaTributaria){
		case "Automovel":
			_aliquota = 0.1;
			break;
			
		case "Eletrodomestico":
			_aliquota = 0.05;
			break;
		
		case "Alimentacao":
			_aliquota = 0.02;
			break;
		}
		
		return _aliquota;
	}
	
	public double calculoImposto(double preco, int quantidade,
			String categoriaTributaria, List<Compravel> subCompraveis) {
		/* Pode ser tao complicado quanto se queira... 
		 * Pode depender da lista de subCompraveis...
		 * E, ate mesmo, do BDNF
		 */
		double aliquota = getAliquota(categoriaTributaria);
		if (impostoData.getAcumulado() > 1000) {
			aliquota *= 2.0;
		}
		return preco * aliquota;
	}
	
	@Override
	public double getValorImposto(double preco, int quantidade,
			String categoriaTributaria, List<Compravel> subCompraveis) {
		impostoData.somarAcumulado(preco);
		return calculoImposto(preco, quantidade, categoriaTributaria, subCompraveis);
	}
}
