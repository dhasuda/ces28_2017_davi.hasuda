package test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import BDProduto.BDProduto;
import BDProduto.Compravel;
import BDProduto.Produto;
import ItemVenda.Estoque;
import ItemVenda.ItemVenda;
import NotaFiscal.NotaFiscal;

public class TestePrintNotaFiscal {
	Estoque estoque;
	BDProduto vendas;
	Compravel venda1, venda2;
	NotaFiscal nf;
	
	@Before
	public void setup(){
		estoque = mock(Estoque.class);
		vendas = mock(BDProduto.class);
		venda1 = new Produto("prod1", 19.19, "set", "Alimentacao");
		venda2 = new Produto("prod2", 10, "set", "Automovel");
		
		when(vendas.getCompravel("prod1")).thenReturn(venda1);
		when(vendas.getCompravel("prod2")).thenReturn(venda2);
		when(estoque.disponibilidadeDeProduto(venda1)).thenReturn(10);
		when(estoque.disponibilidadeDeProduto(venda2)).thenReturn(10);
		nf = new NotaFiscal(2, "prod1", vendas, estoque, "00000000000");
		
	}
	
	@Test
	public void checandoImpressaoDaNotaNaoFinalizada(){
		String esperado = "em elaboracao\nID ainda não definido\nprod1 2 19.19\nTotal: 38.38\nTotal Taxado: 39.15\n";
		String real = nf.printNF();
		assertTrue(esperado.equals(real));
	}
	
	@Test
	public void checandoImpressaoDaNotaNaoFinalizadaComMaisDeUmItem(){
		nf.addItem("prod2", 3);
		String esperado = "em elaboracao\nID ainda não definido\nprod1 2 19.19\nprod2 3 10.0\nTotal: 68.38\nTotal Taxado: 72.15\n";
		String real = nf.printNF();
		assertTrue(esperado.equals(real));
	}
	
	
	
}
