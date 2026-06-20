package sensor;

public class SensorCPU extends Sensor {

	public SensorCPU(int id, String tipo, String unidade, double leituraAtual, double limiteMinimo, double limiteMaximo) {
		super(id, tipo, unidade, leituraAtual, limiteMinimo, limiteMaximo);
	}

	public double lerDado() {
		return 0;
	}

}
