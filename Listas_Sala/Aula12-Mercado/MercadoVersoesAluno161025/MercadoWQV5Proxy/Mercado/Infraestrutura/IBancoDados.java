package Infraestrutura;


import Mercado.Cliente;
import Mercado.Produto;

// isso é o que o programador deve fornecer ao framework.
// com a interface, o framework deve gerar o proxy e o stub
public interface IBancoDados {

	public abstract Cliente selectCliente(int id);

	public abstract Produto selectProduto(int id);

	public abstract void processarPagamento(Cliente cliente, double valor);

	//public abstract void registrarCliente(Cliente cliente);

}
