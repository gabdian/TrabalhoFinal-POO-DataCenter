package dispositivo;

import java.util.LinkedList;
import java.util.Queue;

public class SistemaAlerta implements Monitoravel {

	private boolean ligado;
	private Queue<String> filaAlertas;

	public SistemaAlerta() {
		this.ligado = false;
		this.filaAlertas = new LinkedList<>();
	}

	@Override
	public void ligar() {
		this.ligado = true;
		System.out.println("Sistema de Alerta ligado. Notificando equipe dae infraestrutura");
	}

	@Override
	public void desligar() {
		this.ligado = false;
		System.out.println("Sistema de Alerta desligado.");
	}

	@Override
	public boolean verificarStatus() {
		return this.ligado;
	}

	public void emitirAlertaCriticidade(String mensagemProblema){
		if(!ligado){
			ligar();
		}
		String alertaFormatado = "[CRÍTICO] " + mensagemProblema;
		filaAlertas.offer(alertaFormatado);
		System.out.println(alertaFormatado);
	}

	public String tratarProximoAlerta() {
		return filaAlertas.poll();
	}

}
