package MercadoV1Facade.Aplicacao;

import MercadoV1Facade.Mercado.MercadoFacade;

public class Aplicacao {
	public static void main(String[] args) {
		MercadoFacade merc = new MercadoFacade();
		
		merc.registraComprador("ZE", 123);
		
		merc.compra(123, 223);
		merc.compra(123, 342);
		
		double valor = merc.fecharCompra(123);
		

	}
}
