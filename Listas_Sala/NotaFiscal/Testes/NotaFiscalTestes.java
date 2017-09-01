import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

import BDCliente.BDCliente;
import BDCliente.Cliente;
import BDProduto.Compravel;
import NotaFiscal.NotaFiscal;
import BDProduto.BDProduto;
import BDProduto.Item;
import BDCliente.VerificadorCPF;

public class NotaFiscalTestes {

	BDProduto BDProdutoD;
	BDCliente BDClienteD;
	VerificadorCPF verificadorCPFD;
	Cliente clienteD;
	Compravel vendaD;
	Item itemD;
	BDProduto produtoD;
	
	@Before
	public void setUp() {
		// Dummies
			BDProdutoD = mock(BDProduto.class);
			BDClienteD = mock(BDCliente.class);
			verificadorCPFD = mock(VerificadorCPF.class);
			clienteD = mock(Cliente.class);
			vendaD = mock(Compravel.class);
			itemD = mock(Item.class);
			produtoD = mock(BDProduto.class);
	}
	
	
	@Test
	public void testaNotaFiscalMock() {		
		when(BDProdutoD.getCompravel("venda teste")).thenReturn(vendaD);
		when(BDClienteD.getCliente("000")).thenReturn(clienteD);
		when(verificadorCPFD.CPFValido("000")).thenReturn(true);
		when(clienteD.getNome()).thenReturn("cliente teste");
		when(vendaD.getNome()).thenReturn("venda teste");
		when(vendaD.getPreco()).thenReturn(19.0);
		when(itemD.getPreco()).thenReturn(38.0);
		when(itemD.getQuantidade()).thenReturn(2);
		when(itemD.getVenda()).thenReturn(vendaD);
		when(produtoD.getCompravel("venda teste")).thenReturn(vendaD);
		
		NotaFiscal nf = new NotaFiscal(1, "000", 2, "venda teste", BDClienteD, verificadorCPFD, BDProdutoD);
		
		assertNotNull(nf);
		assertEquals(nf.getPreco(), 38.0, 0);
		assertFalse(nf.removeItem("venda teste"));
		assertEquals(nf.getId(), 1);
		
		Compravel venda2 = mock(Compravel.class);
		when(BDProdutoD.getCompravel("item2")).thenReturn(venda2);
		when(venda2.getNome()).thenReturn("item2");
		when(venda2.getPreco()).thenReturn(22.0);
		
		nf.addItem("item2", 3);
		assertEquals(nf.getPreco(), 104.0, 0);
		assertTrue(nf.removeItem("item2"));
		assertEquals(nf.getPreco(), 38.0, 0);
		
	}
	
	@Test (expected = NullPointerException.class)
	public void testaExceptionNotaFiscalCPFInvalido() {
		when(verificadorCPFD.CPFValido("001")).thenReturn(false);
		
		NotaFiscal nf = new NotaFiscal(1, "001", 2, "venda teste", BDClienteD, verificadorCPFD, BDProdutoD);
	}
	
	@Test (expected = NullPointerException.class)
	public void testaExceptionNotaFiscalClienteInvalido() {
		when(verificadorCPFD.CPFValido("000")).thenReturn(true);
		when(BDClienteD.getCliente("000")).thenThrow(new NullPointerException());
		
		NotaFiscal nf = new NotaFiscal(1, "000", 2, "venda teste", BDClienteD, verificadorCPFD, BDProdutoD);
	}
	
	@Test (expected = NullPointerException.class)
	public void testaExceptionNotaFiscalCompravelInvalido() {
		when(verificadorCPFD.CPFValido("000")).thenReturn(true);
		when(BDProdutoD.getCompravel("venda teste")).thenThrow(new NullPointerException());
		
		NotaFiscal nf = new NotaFiscal(1, "000", 2, "venda teste", BDClienteD, verificadorCPFD, BDProdutoD);
	}
}
