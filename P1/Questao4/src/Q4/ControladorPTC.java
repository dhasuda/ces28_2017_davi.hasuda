package Q4;

import java.util.concurrent.TimeUnit;

public class ControladorPTC {
	private Sensor sensor;
	private Datacenter dataCenter;
	private PainelCondutor painelCond;

	public ControladorPTC(Sensor sensor, Datacenter dataCenter, PainelCondutor painelCond) {
		super();
		this.sensor = sensor;
		this.dataCenter = dataCenter;
		this.painelCond = painelCond;
	}

	public void run() {

		double velocidade = sensor.getVelocidade();
		boolean isCruzamento = sensor.isCruzamento();

		// checa se o trem esta com velocidade acima do permitido no cruzamento
		if (isCruzamento && (velocidade > 100)) {
			boolean result = enviaMsgPrioritariaPainel("Velocidade alta", painelCond);
			if (result == false) {
				diminuiVelocidade(20);
			}
		}

		// checa se o trem esta lento demais no cruzamento
		if (isCruzamento && (velocidade < 20)) {
			boolean result = enviaMsgPrioritariaPainel("Velocidade Baixa", painelCond);
			if (result == false) {
				aumentaVelocidade(20);
			}
		}

		else {
			enviaMsgDatacenter(new Double(velocidade), dataCenter);
			enviaMsgNormalPainel(new Double(velocidade), painelCond);
		}

	}

	public boolean enviaMsgPrioritariaPainel(String msg, PainelCondutor condutor) {
		boolean result = condutor.imprimeAviso(msg, 1);
		if (result == false) {
			try {
				TimeUnit.SECONDS.sleep(10);
				result = condutor.imprimeAviso(msg, 1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public void enviaMsgNormalPainel(Object msg, PainelCondutor condutor) {
		condutor.imprimeAviso(msg.toString(), 1);
	}

	public void enviaMsgDatacenter(Object msg, Datacenter datacenter) {
		datacenter.gerarRelatorio(msg.toString());
	};

	public void diminuiVelocidade(double valor) {
		this.painelCond.diminuiVelocidadeTrem(valor);
	};

	public void aumentaVelocidade(double valor) {
		this.painelCond.aceleraVelocidadeTrem(valor);
	};

}
