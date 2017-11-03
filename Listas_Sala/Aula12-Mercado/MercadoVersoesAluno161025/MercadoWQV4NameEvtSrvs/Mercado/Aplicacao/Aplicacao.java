package Aplicacao;

import Mercado.MercadoFacade; // (*) nao temos ativador externo
import BancoDeDados.BancoDeDados;//    ativamos comps aqui mesmo

import Infraestrutura.IMercado;
import Infraestrutura.FakeNameService; 


public class Aplicacao {

	public static void main(String[] args) {

		initSubsystems();
		//NameSrv NS = NameSrv.getInstance();
		FakeNameService NS = FakeNameService.getInstance();
		NS.printNames();
		IMercado mercado = (IMercado)NS.get("Mercado");
		int idCliente = mercado.registraNovoCliente("Ze", 123);
		mercado.adicionaProduto(idCliente, 223);
		mercado.adicionaProduto(idCliente, 342);
		mercado.processarPagamento(idCliente);
		
		createOtherBanco();
		mercado.setIBanco("BancoNovo");
		System.out.println("try old client:" );
		int idCliente2 = mercado.registraNovoCliente("Ze", 100);
		mercado.adicionaProduto(idCliente2, 100);
		mercado.adicionaProduto(idCliente2, 150);
		mercado.processarPagamento(idCliente2);

		// uncomente: o 1o cliente nao existe, e da erro.
		//mercado.processarPagamento(idCliente);	
	}

	// with a real component system, this would not be needed
	// an external activator would load and run the components
	public static void initSubsystems() {
		//NameSrv NS = NameSrv.getInstance();
		FakeNameService NS = FakeNameService.getInstance();
		// BancoDeDados is not a singleton. It also works.
		NS.set("Banco",new BancoDeDados());
		// Mercado is singleton
		NS.set("Mercado",MercadoFacade.getInstance());
		// Mercado can find Banco itself via the NS. using the default name
		NS.printNames();// just to check
		
	}

	public static void createOtherBanco() {
		//NameSrv NS = NameSrv.getInstance();
		FakeNameService NS = FakeNameService.getInstance();
		NS.set("BancoNovo",new BancoDeDados());
	}

}
