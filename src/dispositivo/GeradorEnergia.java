package dispositivo;

public class GeradorEnergia implements Monitoravel {

	private boolean ligado;

	public GeradorEnergia() {
		this.ligado = false;
	}

	@Override
	public void ligar() {
		this.ligado = true;
	}

	@Override
	public void desligar() {
		this.ligado = false;
	}

	@Override
	public boolean verificarStatus(){
		return this.ligado;
	}

	public void monitorarRedeEletrica(boolean temEnergiaNaRede) {
		if(!temEnergiaNaRede && ligado){
			System.out.println("ALERTA CRÍTICO: queda na rede elétrica");
			ligar();
		} else if (temEnergiaNaRede && !ligado) {
			desligar();
		}
	}

}
