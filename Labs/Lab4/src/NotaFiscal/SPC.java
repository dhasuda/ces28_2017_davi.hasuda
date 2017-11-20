package NotaFiscal;

import java.util.HashSet;
import java.util.Set;

public class SPC {
	private static SPC _spc = new SPC();
	private Set<String> CPFs = new HashSet<String>();
	
	static SPC getInstance() {
		return _spc;
	}
	
	String validarCPF(String cpf) throws Exception {
		if (isOK(cpf)) {
			return "validado";
		}
		return "invalido";
	}
	
	boolean isOK(String cpf) {
		return true;
	}
}
