package dispositivo;

public class Nobreak implements Monitoravel {

	private boolean ligado;
	private double nivelBateria;

	public Nobreak() {
		this.ligado = false;
		this.nivelBateria = 100.0;
	}

	@Override
	public void ligar() {
		this.ligado = true;
		System.out.println("Nobreak ligado. Fornecendo energia pelas baterias.");
	}

	@Override
	public void desligar() {
		this.ligado = false;
		System.out.println("Nobreak desligado. Retornando ao modo recarga");
	}

	@Override
	public boolean verificarStatus() {
		return this.ligado;
	}

	public void assumirCarga(boolean houveFalhaEletrica){
		if(houveFalhaEletrica && !ligado) {
			if (nivelBateria > 0) {
				ligar();
			} else {
				System.out.println("FALHA CRÍTICA: Nobreak sem carga nas baterias.");
			}
		}else if(!houveFalhaEletrica && ligado) {
			desligar();
		}
	}

	public double getNivelBateria() {
		return nivelBateria;
	}
}
