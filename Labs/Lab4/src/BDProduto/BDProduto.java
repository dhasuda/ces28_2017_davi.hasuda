package BDProduto;

public class BDProduto {
	
	private static BDProduto singleBDProduto = new BDProduto();
	
	private BDProduto() {}
	
	public static BDProduto getInstance() {
		return singleBDProduto;
	}
	
	public Compravel getCompravel(String nome) throws NullPointerException {
		return null;
	}
}
