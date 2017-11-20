package NotaFiscal;

public class Imposto2Data implements IImpostoData {
	private double acumulado = 0;
	
	public double getAcumulado() {
		return this.acumulado;
	}

	public void somarAcumulado(double soma) {
		this.acumulado += soma;
	}

}
