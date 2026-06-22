package sensor;

public class SensorTemperatura extends Sensor {

	public SensorTemperatura(int id, String tipo, String unidade, double leituraAtual, double limiteMinimo, double limiteMaximo) {
		super(id, tipo, unidade, leituraAtual, limiteMinimo, limiteMaximo);
	}

	@Override
	public double lerDado() {
		double range = getLimiteMaximo() - getLimiteMinimo();
		double leitura = getLimiteMinimo() + Math.random() * range;
		setLeituraAtual(leitura);
		return leitura;
	}

}
