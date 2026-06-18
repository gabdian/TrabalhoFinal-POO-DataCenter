package relatorio;

import core.DataCenter;

public class Relatorio {

	private LocalDate dataGeracao;

	private DataCenter dataCenter;

	private double mediaCPU;

	private double mediaMemoria;

	private double mediaTemperatura;

	private double mediaEnergia;

	private List alertasGerados;

	public String gerarResumo() {
		return null;
	}

	public boolean salvarEmArquivo() {
		return false;
	}

}
