package NotaFiscal;

import ItemVenda.ItemVenda;

public class Taxador implements PSVisitor{
	
	public void visitarETaxar(ItemVenda itemVenda, Imposto imposto) {
		itemVenda.setTaxacao(
				imposto.getValorImposto(
						itemVenda.getPreco(),
						itemVenda.getQuantidade(), 
						itemVenda.getCategoriaTributaria(),
						itemVenda.getListaSubCompraveis()));
	}
	
}
