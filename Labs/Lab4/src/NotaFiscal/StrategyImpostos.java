package NotaFiscal;

import java.util.List;
import java.util.Set;

import ItemVenda.ItemVenda;
import NotaFiscal.NotaFiscal;

public class StrategyImpostos {
	private BDTax bdTax = BDTax.getInstance();
	private List<ItemVenda> itemList;
	
	public StrategyImpostos(List<ItemVenda> itensVenda) {
		this.itemList = itensVenda;
		this.executarTaxacoes();
	}
	
	private void executarTaxacoes() {
		Taxador taxa = new Taxador();
		Set<Imposto> impostos = bdTax.getImpostos();
		
		for (ItemVenda item: itemList) {
			for(Imposto imposto : impostos) {
				taxa.visitarETaxar(item, imposto);
			}
			
		}
	}
}
