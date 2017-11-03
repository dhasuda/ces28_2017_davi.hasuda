package Mercado;

public class MercadoFacade {
	private static MercadoFacade    _theFacade = null;
	
	private Mercado mercado_;
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

