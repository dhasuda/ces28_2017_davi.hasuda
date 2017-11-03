package Infraestrutura;


import java.util.List;
import java.util.Arrays;
import static java.util.Arrays.asList;

import Mercado.Cliente;
import Mercado.Produto;


// is it hard to generate this code automatically if you have the IBancoDados code?
public class ProxyIBancoDados implements IBancoDados {

	StubIBancoDados _banco;
	
	// only the Infrastructure may create it. it is not public
	ProxyIBancoDados(StubIBancoDados banco ) {
		_banco = banco;
		stabilishConnectionWithRemoteActualClass();
		
	}
	
	private void stabilishConnectionWithRemoteActualClass() {
		// do nothing because it is fake!!!
		// but, if real, we would not have pointer to the stub
		// we would have a network endpoint (IP + port + remote object identifier)
		// and we would have to stabilish a conection!
	}
	
	public Cliente selectCliente(int id) {
		// hide network code here if the actual BD is remote
		// obviously I could call directly the method, but this remotemethodcall
		// is just to fake some kind of protocol.
		// in the realworld we would not have a pointer to the stub
		return (Cliente)_banco.remoteMethodCall("selectCliente", asList((Object)id) );
	}

	public Produto selectProduto(int id) {
		// hide network code here if the actual BD is remote
		// obviously I could call directly the method, but this remotemethodcall
		// is just to fake some kind of protocol. 
		// in the realworld we would not have a pointer to the stub
		return (Produto)_banco.remoteMethodCall("selectProduto", asList((Object)id) );
	}

	public void processarPagamento(Cliente cliente, double valor) {
		// hide network code here if the actual BD is remote
		// obviously I could call directly the method, but this remotemethodcall
		// is just to fake some kind of protocol.
		// in the realworld we would not have a pointer to the stub
		_banco.remoteMethodCall("processarPagamento", asList((Object)cliente, valor) );
	}

	// this operation is done now via event service
	//public abstract void registrarCliente(Cliente cliente); 

}
