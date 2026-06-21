package dispositivo;
import sensor.*;

public class SistemaRefrigeracao implements Monitoravel {

	public void ligar() {
		if(SensorTemperatura.getLimiteMaximo() < limiteAual){

		}
	}

	public void desligar() {

	}

	public boolean verificarStatus() {

		return false;
	}

	/**
	 * @see dispositivo.Monitoravel#Monitoravel()
	 */
	public Monitoravel() {

	}

}
