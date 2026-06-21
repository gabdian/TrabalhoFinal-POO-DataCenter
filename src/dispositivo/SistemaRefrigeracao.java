package dispositivo;


public class SistemaRefrigeracao implements Monitoravel {

	private boolean ligado;
	private double limiteTemperatura;

	public SistemaRefrigeracao(double limiteTemperatura) {
		this.ligado = false;
		this.limiteTemperatura = limiteTemperatura;
	}

	@Override
	public void ligar() {
		this.ligado = true;
		System.out.println("Sistema de refrigeração do Data Center ativado.");
	}

	@Override
	public void desligar() {
		this.ligado = false;
		System.out.println("Sistema de refrigeração do Data Center desligado.");
	}

	@Override
	public boolean verificarStatus() {
		return this.ligado;
	}

	public void avaliarTemperatura(double temperaturaAtual) {
		if(temperaturaAtual < limiteTemperatura && !ligado) {
			System.out.println("ALERTA: Temperatura: "  + temperaturaAtual + "°C) Está acima do limite maximo.");
			ligar();
		} else if (temperaturaAtual <= limiteTemperatura && ligado) {
			desligar();
		}
	}

}
