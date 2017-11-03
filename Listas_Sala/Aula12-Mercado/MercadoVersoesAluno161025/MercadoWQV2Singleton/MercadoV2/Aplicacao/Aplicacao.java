package Aplicacao;


import Mercado.MercadoFacade;


public class Aplicacao {
	public static void main(String[] args) {
		MercadoFacade merc = MercadoFacade.getMercado();
		
		merc.registraComprador("ZE", 123);
		
		merc.compra(123, 223);
		merc.compra(123, 342);
		
		double valor = merc.fecharCompra(123);
		

	}
}
