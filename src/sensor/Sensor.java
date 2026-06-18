package sensor;

public abstract class Sensor {

	private int id;

	private String tipo;

	private String unidade;

	private double leituraAtual;

	private double limiteMinimo;

	private double limiteMaximo;

	public abstract double lerDado();

	public boolean verificarAlerta() {
		return false;
	}

}
