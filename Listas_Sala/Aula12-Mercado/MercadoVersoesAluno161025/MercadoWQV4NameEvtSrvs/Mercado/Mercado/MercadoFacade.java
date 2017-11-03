package Mercado;

import Infraestrutura.IBancoDados;
import Infraestrutura.IMercado;

public class MercadoFacade implements IMercado {
	private static MercadoFacade    _theFacade = null;
	
	private static Mercado mercado_;
	private MercadoFacade() {
		// 
		mercado_ = new Mercado();
	}
	
	public static MercadoFacade    getMercado() {
		if (_theFacade == null) {
			_theFacade = new MercadoFacade();
		}
	        	return _theFacade;       
	   	 }
	
	public static Mercado getInstance() {
		return mercado_;
	}
	
	public void registraComprador(String name, int id) {
			mercado_.registraComprador(name, id);
		}
		// realizar uma compra
	public void compra(int cliId, int prodId) {
		mercado_.compra(cliId, prodId);
	}
		// fechar compra
	public double fecharCompra(int cliId) {
		return mercado_.fecharCompra(cliId);
	}

	@Override
	public int registraNovoCliente(String nome, int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void adicionaProduto(int idCliente, int idProduto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processarPagamento(int idCliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IBancoDados setIBanco(String nomebanco) {
		// TODO Auto-generated method stub
		return null;
	}
		
}//MercadoFacade

