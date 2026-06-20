package core;

import dispositivo.Monitoravel;
import enums.statusdatacenter;
import relatorio.Relatorio;

import java.util.ArrayList;
import java.util.List;

public class DataCenter {

	private int id;

	private String nome;

	private String localizacao;

	private List servidores;

	private List dispositivo;

	private statusdatacenter status;

	private Relatorio[] relatorio;

	public DataCenter(int id, String nome, String localizacao) {
		this.id = id;
		this.nome = nome;
		this.localizacao = localizacao;
		this.servidores = new ArrayList();
		this.dispositivo = new ArrayList();
	}

	public boolean cadastrarServidor(Servidor servidor) {
		servidores.add(servidor);
		return true;
	}

	public boolean removerSevidor(Servidor servidor) {
		servidores.remove(servidor.getId());
		return true;
	}

	public boolean cadastrarDispositivo(Monitoravel dispositivo) {
		this.dispositivo.add(dispositivo);

		return true;
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
