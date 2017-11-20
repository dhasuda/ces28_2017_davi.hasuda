package NotaFiscal;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class BDTax {
	private static BDTax bdTax = new BDTax();
	Set<Imposto> impostos = new HashSet<Imposto>();
	
	private BDTax(){
		this.impostos.add(new Imposto1());
	}//singleton
	
	public static BDTax getInstance() {
		return bdTax;
	}
	
	public Set<Imposto> getImpostos(){
		return Collections.unmodifiableSet(impostos);
	}
}
