package MercadoV1Facade.BancoDeDados;

import java.util.HashMap;
import java.util.Map;

import MercadoV1Facade.BancoDeDados.Cliente;
import MercadoV1Facade.BancoDeDados.Produto;

public class BancoDeDados {
	Map<Integer, Produto> produtosById;
	Map<Integer, Cliente> clientesById;
	public BancoDeDados() {
		produtosById = new HashMap<>();
		clientesById = new HashMap<>();
		for (int i = 0; i < 500; i++) {
			produtosById.put(new Integer(i), Produto.create("Produto #" + i, i, (double)(i*3 + 1)));
		}
	}
	public Cliente selectCliente(int id) {
		return clientesById.get(new Integer(id));
	}
	public Produto selectProduto(int id) {
		return produtosById.get(new Integer(id));
	}
	public void processarPagamento(Cliente cliente, double valor) {
		System.out.println("(Pagamento processado) Cliente: " + cliente.getId() + ", Valor: " + valor);
	}
	public void registrarCliente(Cliente cliente) {
		clientesById.put(cliente.getId(), cliente);
	}
}