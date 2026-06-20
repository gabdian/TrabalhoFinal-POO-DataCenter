package core;

import enums.statusservidor;

public class Servidor {

	private int id;

	private String nome;

	private String enderecoIP;

	private String sistemaOperacional;

	private List sensores;

	private statusservidor status;

	public boolean adicionarSensor() {
		return false;
	}

	public boolean removerSensor() {
		return false;
	}

	public double calcularCargaMedia() {
		return 0;
	}

	public double verificarSaudeServidor() {
		return 0;
	}

	public String gerarResumo() {
		return null;
	}

}
