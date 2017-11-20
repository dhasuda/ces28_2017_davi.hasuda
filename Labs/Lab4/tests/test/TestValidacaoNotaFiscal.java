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

public class TestValidacaoNotaFiscal {
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
	

	@Test(expected = NullPointerException.class)
	public void adicionandoUmItemNaoRegistradoNoBD() {
		//ao adicionar um produto nao registrado, a nota fiscal deve recusar
		nf.addItem("produto666", 1);
	}
	
	@Test(expected = NullPointerException.class)
	public void criandoNotaFiscalComItemNaoRegistradoNoBD(){
		//deve ser impossivel
		NotaFiscal nf2 = new NotaFiscal(2, "prod666", vendas, estoque, "000000000");
	}
	

	@Test
	public void testandoAValidacaoDaNota(){
		try {
			nf.validarCliente();
			nf.validar();
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testandoOIdDeDiferentesNotasValidadas(){
		NotaFiscal nf2 = new NotaFiscal(2, "prod1", vendas, estoque, "000000000");
		try {
			nf.validarCliente();
			nf.validar();
			nf2.validarCliente();
			nf2.validar();
		} catch (Exception e) {
			fail();
		}
		assertTrue(nf.getId()!=nf2.getId());
	}
	

	@Test
	public void checandoImpressaoDaNotaFinalizadaComMaisDeUmItem(){
		nf.addItem("prod2", 3);
		try{
			nf.validarCliente();
			nf.validar();
		}catch(Exception e){
			fail();
		}
		
		String esperado = "validada\nID: 1\nprod1 2 19.19\nprod2 3 10.0\nTotal: 68.38\nTotal Taxado: 72.15\n";
		String real = nf.printNF();
		assertTrue(esperado.equals(real));
	}
	
	@Test(expected = Exception.class)
	public void tentandoValidarNotaAntesDeValidarCliente() throws Exception{
		nf.validar();
	}
	
	
	@Test
	public void criandoUmItemDeVenda() {
		ItemVenda item = new ItemVenda(nf, venda1, 2);
		assertEquals(item.getVenda(), venda1);
	}
}
