package NotaFiscal;

import ItemVenda.ItemVenda;

public interface PSVisitor {
	void visitarETaxar(ItemVenda itemVenda, Imposto imposto);
}
