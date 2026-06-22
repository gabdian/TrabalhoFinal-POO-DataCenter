package sensor;

public abstract class Sensor {

	private int id;

	private String tipo;

	private String unidade;

	private double leituraAtual;

	private double limiteMinimo;

	private double limiteMaximo;

	public Sensor(int id, String tipo, String unidade, double leituraAtual, double limiteMinimo, double limiteMaximo) {
		this.id = id;
		this.tipo = tipo;
		this.unidade = unidade;
		this.leituraAtual = leituraAtual;
		this.limiteMinimo = limiteMinimo;
		this.limiteMaximo = limiteMaximo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public double getLeituraAtual() {
		return leituraAtual;
	}

	public void setLeituraAtual(double leituraAtual) {
		this.leituraAtual = leituraAtual;
	}

	public double getLimiteMinimo() {
		return limiteMinimo;
	}

	public void setLimiteMinimo(double limiteMinimo) {
		this.limiteMinimo = limiteMinimo;
	}

	public double getLimiteMaximo() {
		return limiteMaximo;
	}

	public void setLimiteMaximo(double limiteMaximo) {
		this.limiteMaximo = limiteMaximo;
	}

	public abstract double lerDado();

	public boolean verificarAlerta() {
		return leituraAtual < limiteMinimo || leituraAtual > limiteMaximo;
	}

	public boolean verificarLimites() {
		return leituraAtual >= limiteMinimo && leituraAtual <= limiteMaximo;
	}
}
