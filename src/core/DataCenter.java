package core;

import dispositivo.Monitoravel;
import enums.StatusDatacenter;
import enums.StatusServidor;
import relatorio.Relatorio;
import sensor.Sensor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataCenter {

	private int id;

	private String nome;

	private String localizacao;

	private List<Servidor> servidores;

	private List<Monitoravel> dispositivos;

	private StatusDatacenter status;

	private List<Relatorio> historicoDeRelatorios;

	public DataCenter(int id, String nome, String localizacao) {
		this.id = id;
		this.nome = nome;
		this.localizacao = localizacao;
		this.servidores = new ArrayList<>();
		this.dispositivos = new ArrayList<>();
		this.historicoDeRelatorios = new ArrayList<>();
		this.status = StatusDatacenter.ATIVO;
	}

	public boolean cadastrarServidor(Servidor servidor) {
		if(!servidores.contains(servidor)) {
			servidores.add(servidor);
			return true;
		}
		return false;
	}

	public boolean removerServidor(Servidor servidor) {
		return servidores.remove(servidor);
	}

	public boolean cadastrarDispositivo(Monitoravel dispositivo) {
		if(!dispositivos.contains(dispositivo)) {
			dispositivos.add(dispositivo);
			return true;
		}
		return false;
	}

	public double calcularMediaTemperatura() {
//		double soma = 0;
//		int totalSensoresTemperaturas = 0;
//
//		for(Servidor servidor : servidores) {
//			for(Sensor sensor : servidor.getSensores()) {
//				if(sensor.getTipo().equalsIgnoreCase("temperatura")) {
//					soma += sensor.getLeituraAtual();
//					totalSensoresTemperaturas++;
//				}
//			}
//		}
//		if(totalSensoresTemperaturas == 0) {
//			return 0;
//		}
//		return soma/totalSensoresTemperaturas;
		return servidores.stream().flatMap(servidor -> servidor.getSensores().stream())
				.filter(sensor -> sensor.getTipo().equalsIgnoreCase("Temperatura"))
				.mapToDouble(Sensor::getLeituraAtual).average().orElse(0.0);
	}

	public double calcularMediaConsumoEnergia() {
//		double soma = 0;
//		int totalSensoresEnergia = 0;
//
//		for(Servidor servidor : servidores) {
//			for(Sensor sensor : servidor.getSensores()) {
//				if(sensor.getTipo().equalsIgnoreCase("Energia")) {
//					soma += sensor.getLeituraAtual();
//					totalSensoresEnergia++;
//				}
//			}
//		}
//		if(totalSensoresEnergia == 0) {
//			return 0;
//		}
//		return soma/totalSensoresEnergia;
		return servidores.stream()
				.flatMap(servidor -> servidor.getSensores().stream())
				.filter(sensor -> sensor.getTipo().equalsIgnoreCase("Energia"))
				.mapToDouble(Sensor::getLeituraAtual).average().orElse(0.0);
	}

	public double calcularMediaUsoCPU() {
		double soma = 0;
		int totalSensoresCPU = 0;

		for(Servidor servidor : servidores) {
			for(Sensor sensor : servidor.getSensores()) {
				if(sensor.getTipo().equalsIgnoreCase("CPU")) {
					soma += sensor.getLeituraAtual();
					totalSensoresCPU++;
				}
			}
		}
		if(totalSensoresCPU == 0) {
			return 0;
		}
		return soma/totalSensoresCPU;
	}

	public Map<StatusServidor, Long> agruparServidoresPorStatus(){
		return servidores.stream().collect(Collectors.groupingBy(Servidor::getStatus, Collectors.counting()));
	}

	public String gerarRelatorioGeral(List<String> alertasDoSistema) {
		Relatorio relatorio = new Relatorio(this, alertasDoSistema);
		relatorio.salvarEmArquivo();
		return relatorio.gerarResumo();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public List<Servidor> getServidores() {
		return servidores;
	}

	public void setServidores(List<Servidor> servidores) {
		this.servidores = servidores;
	}

	public List<Monitoravel> getDispositivos() {
		return dispositivos;
	}

	public void setDispositivos(List<Monitoravel> dispositivos) {
		this.dispositivos = dispositivos;
	}

	public StatusDatacenter getStatus() {
		return status;
	}

	public void setStatus(StatusDatacenter status) {
		this.status = status;
	}

	public List<Relatorio> getHistoricoDeRelatorios() {
		return historicoDeRelatorios;
	}

	public void setHistoricoDeRelatorios(List<Relatorio> historicoDeRelatorios) {
		this.historicoDeRelatorios = historicoDeRelatorios;
	}
}
