package sensor;

public class SensorEnergia extends Sensor {

	public SensorEnergia(int id, String tipo, String unidade, double leituraAtual, double limiteMinimo, double limiteMaximo) {
		super(id, tipo, unidade, leituraAtual, limiteMinimo, limiteMaximo);
	}

	public double lerDado() {
		double range = getLimiteMaximo() - getLimiteMinimo();
		double leitura = getLimiteMinimo() + Math.random() * range;
		setLeituraAtual(leitura);
		return leitura;
	}

}
