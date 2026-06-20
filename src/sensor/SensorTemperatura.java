package sensor;

public class SensorTemperatura extends Sensor {

	public SensorTemperatura(int id, String tipo, String unidade, double leituraAtual, double limiteMinimo, double limiteMaximo) {
		super(id, tipo, unidade, leituraAtual, limiteMinimo, limiteMaximo);
	}

	public double lerDado() {
		return 0;
	}

}
