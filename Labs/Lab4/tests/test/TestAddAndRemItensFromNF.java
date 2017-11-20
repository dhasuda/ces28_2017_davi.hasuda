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

public class TestAddAndRemItensFromNF {
	Estoque estoque;
	BDProduto vendas;
	Compravel venda1, venda2;
	NotaFiscal nf;
	
	@Before
	public void setup(){
		estoque = mock(Estoque.class);
		vendas = mock(BDProduto.class);
		venda1 = new Produto("prod1", 19.19, "set", "Alimentacao");
		venda2 = new Produto("prod2", 19.19, "set", "Alimentacao");
		
		when(vendas.getCompravel("prod1")).thenReturn(venda1);
		when(vendas.getCompravel("prod2")).thenReturn(venda2);
		when(estoque.disponibilidadeDeProduto(venda1)).thenReturn(10);
		when(estoque.disponibilidadeDeProduto(venda2)).thenReturn(10);
		nf = new NotaFiscal(2, "prod1", vendas, estoque, "00000000000");
		
	}
	
	@Test
	public void RemoverUnicoItemDeVendaDaNotaFiscal() {
		nf.removeItem("prod1");
		//deve ser impossivel remover o ultimo item
		assertEquals(nf.getItemList().size(), 1);
	}
	
	@Test
	public void RemoverTodosItensDeVendaDaNotaFiscal(){
		nf.addItem("prod2", 3);
		assertEquals(nf.getItemList().size(), 2);
		nf.removeItem("prod1");
		assertEquals(nf.getItemList().size(), 1);
		
		//deve ser impossivel remover o ultimo item
		nf.removeItem("prod2");
		assertEquals(nf.getItemList().size(), 1);
	}
	
	@Test(expected = NullPointerException.class)
	public void tentandoCriarUmaNotaFiscalOndeAQuantEhMaiorQueOEstoque(){
		Compravel venda3 = new Produto("prod1", 19.19, "set", "Alimentacao");
		
		when(vendas.getCompravel("prod3")).thenReturn(venda3);
		when(estoque.disponibilidadeDeProduto(venda3)).thenReturn(1);
		NotaFiscal nf =
				new NotaFiscal(100100, "prod1", vendas, estoque, "00000000000");		
		fail();
	}
	

	@Test
	public void criandoUmItemDeVenda() {
		ItemVenda item = new ItemVenda(nf, venda1, 2);
		assertEquals(item.getVenda(), venda1);
	}
}
