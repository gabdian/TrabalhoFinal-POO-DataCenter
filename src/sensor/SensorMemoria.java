package sensor;

public class SensorMemoria extends Sensor {

	public SensorMemoria(int id, String tipo, String unidade, double leituraAtual, double limiteMinimo, double limiteMaximo) {
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
