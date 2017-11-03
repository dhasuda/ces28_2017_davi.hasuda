package MercadoV1Facade.Mercado;

import MercadoV1Facade.BancoDeDados.BancoDeDados;
import MercadoV1Facade.BancoDeDados.Cliente;
import MercadoV1Facade.BancoDeDados.Produto;
import MercadoV1Facade.Mercado.Carrinho;


public class Mercado {

		private BancoDeDados banco_; 
		public Mercado() {
			banco_ = new BancoDeDados();
		}
		
		public void registraComprador(String name, int id) {
			// 	registrar comprador
			Cliente cliente = Cliente.create(name, id);
			Carrinho car = Carrinho.create();
			cliente.adicionarCarrinho(car);
			banco_.registrarCliente(cliente);
		}
		// realizar uma compra
		public void compra(int cliId, int prodId) {
			Cliente cliente = banco_.selectCliente(cliId);
			Produto produto = banco_.selectProduto(prodId);
			cliente.getCarrinho().adicionar(produto);
		}
		// fechar compra
		public double fecharCompra(int cliId) {
			Cliente cliente = banco_.selectCliente(cliId);
			double valor = cliente.getCarrinho().getTotal();
			banco_.processarPagamento(cliente, valor);
			return valor;
		}
		
	}//Mercado


