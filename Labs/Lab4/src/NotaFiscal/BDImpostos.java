package NotaFiscal;

public class BDImpostos {
	private BDImpostos impostosSingleton = null;
	
	private BDImpostos() {}
	public BDImpostos getBDImpostos() {
		if (impostosSingleton == null) {
			impostosSingleton = new BDImpostos();
		}
		return impostosSingleton;
	}
	
}
