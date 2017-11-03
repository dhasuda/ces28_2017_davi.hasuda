package Infraestrutura;


import Mercado.Cliente;
import Mercado.Produto;

public interface IBancoDados {

	public abstract Cliente selectCliente(int id);

	public abstract Produto selectProduto(int id);

	public abstract void processarPagamento(Cliente cliente, double valor);

	public abstract void registrarCliente(Cliente cliente);

}
