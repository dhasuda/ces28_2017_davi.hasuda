package Infraestrutura;

public interface IMercado {
	public int registraNovoCliente(String nome, int id) ;

	public void adicionaProduto(int idCliente, int idProduto);

	public void processarPagamento(int idCliente) ;

	public IBancoDados setIBanco(String nomebanco) ;
}
