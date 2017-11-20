package NotaFiscal;

import java.util.List;

import BDProduto.Compravel;
import NotaFiscal.BDNF;

public class Imposto1 implements Imposto {
	BDNF bdnf = BDNF.getInstance();
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
		return preco * getAliquota(categoriaTributaria);
	}
	
	@Override
	public double getValorImposto(double preco, int quantidade,
			String categoriaTributaria, List<Compravel> subCompraveis) {
		
		return calculoImposto(preco, quantidade, categoriaTributaria, subCompraveis);
	}
}
