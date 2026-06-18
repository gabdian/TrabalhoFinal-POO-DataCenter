package core;

import enums.StatusDataCenter;
import relatorio.Relatorio;

public class DataCenter {

	private int id;

	private String nome;

	private String localizacao;

	private List servidores;

	private List dispositivo;

	private StatusDataCenter status;

	private Relatorio[] relatorio;

	public boolean cadastrarServidor() {
		return false;
	}

	public boolean removerSevidor() {
		return false;
	}

	public boolean cadastrarDispositivo() {
		return false;
	}

	public double calcularMediaTemperatura() {
		return 0;
	}

	public double calcularMediaConsumoEnergia() {
		return 0;
	}

	public double calcularMediaUsoCPU() {
		return 0;
	}

	public String gerarRelatorioGeral() {
		return null;
	}

}
