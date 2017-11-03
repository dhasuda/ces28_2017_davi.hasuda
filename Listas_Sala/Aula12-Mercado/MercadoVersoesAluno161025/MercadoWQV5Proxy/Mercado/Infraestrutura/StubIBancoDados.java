package Infraestrutura;


import java.util.List;

import Mercado.Cliente;
import Mercado.Produto;


// is it hard to generate this code automatically if you have the IBancoDados code?
public abstract class StubIBancoDados implements IBancoDados {

	// only the Infrastructure may call. it is not public
	Object remoteMethodCall(String type, List<Object> methodparams) {
		if (type.equals("selectCliente")){
			return selectCliente((Integer)methodparams.get(0));
		}else if (type.equals("selectProduto")){
			return selectProduto((Integer)methodparams.get(0));
		} else if (type.equals("processarPagamento")){
			processarPagamento((Cliente)methodparams.get(0),(double)methodparams.get(1));
		} else {
			System.out.println("ERROR: invalid remote method call to method "+ type + " with params " + methodparams);
		}
		return null;
	}
	
	
	
	// only the Infrastructure may create it. it is not public
	public StubIBancoDados() { 	}
	
		
	public abstract Cliente selectCliente(int id) ;

	public abstract Produto selectProduto(int id) ;

	public abstract void processarPagamento(Cliente cliente, double valor) ;

	// this operation is done now via event service
	//public abstract void registrarCliente(Cliente cliente); 

}
