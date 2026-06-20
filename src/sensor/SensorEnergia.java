package sensor;

public class SensorEnergia extends Sensor {

	public SensorEnergia(int id, String tipo, String unidade, double leituraAtual, double limiteMinimo, double limiteMaximo) {
		super(id, tipo, unidade, leituraAtual, limiteMinimo, limiteMaximo);
	}

	public double lerDado() {
		return 0;
	}

}
