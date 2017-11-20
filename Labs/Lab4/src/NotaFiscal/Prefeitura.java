package NotaFiscal;

public class Prefeitura {
	static Prefeitura instance = new Prefeitura();
	static public Prefeitura getInstance(){
		return instance;
	}
	
	void recebeNovaNF(NotaFiscal nf){};
	
	private Prefeitura() {}//singleton
}
