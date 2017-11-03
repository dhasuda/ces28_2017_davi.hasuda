package MercadoV1Facade.Mercado;

import MercadoV1Facade.BancoDeDados.BancoDeDados;
import MercadoV1Facade.BancoDeDados.Cliente;
import MercadoV1Facade.BancoDeDados.Produto;
import MercadoV1Facade.Mercado.Mercado;

public class MercadoFacade {
	private Mercado mercado_;
	public MercadoFacade() {
		// 
		mercado_ = new Mercado();
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
		
}//MercadoFacade


	
