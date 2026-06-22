package relatorio;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import core.DataCenter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class Relatorio {

	private LocalDate dataGeracao;
	private DataCenter dataCenter;
	private double mediaCPU;
	private double mediaMemoria;
	private double mediaTemperatura;
	private double mediaEnergia;
	private List<String> alertasGerados;

	public Relatorio(DataCenter dataCenter, List<String> alertasGerados) {
		this.dataGeracao = LocalDate.now();
		this.dataCenter = dataCenter;
		this.mediaTemperatura = dataCenter.calcularMediaTemperatura();
		this.mediaEnergia = dataCenter.calcularMediaConsumoEnergia();
		this.mediaCPU = dataCenter.calcularMediaUsoCPU();
		this.mediaMemoria = dataCenter.calcularMediaUsoMemoria();
		this.alertasGerados = alertasGerados;
	}

	public String gerarResumo() {
		StringBuilder sb = new StringBuilder();
		DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		sb.append("=========================================\n");
		sb.append("      RELATÓRIO GERAL DO DATA CENTER     \n");
		sb.append("=========================================\n");
		sb.append("Data de Geração: ").append(dataGeracao.format(formatoData)).append("\n");
		sb.append("Média de Temperatura: ").append(String.format("%.2f", mediaTemperatura)).append(" °C\n");
		sb.append("Média de Consumo de Energia: ").append(String.format("%.2f", mediaEnergia)).append(" kW\n");
		sb.append("Média de Uso de CPU: ").append(String.format("%.2f", mediaCPU)).append(" %\n");
		sb.append("Média de Uso de Memória: ").append(String.format("%.2f", mediaMemoria)).append(" %\n");
		sb.append("-----------------------------------------\n");
		sb.append("ALERTAS REGISTRADOS:\n");

		if (alertasGerados == null || alertasGerados.isEmpty()) {
			sb.append("Nenhuma alerta crítico registado no período.\n");
		}else {
			for(String alerta : alertasGerados){
				sb.append("- ").append(alerta).append("\n");
			}
		}
		sb.append("=========================================\n");
		return sb.toString();
	}

	public void salvarEmArquivoPDF() {
		String nomeArquivo = "Relatorio_DataCenter_" + dataGeracao + ".pdf";
		Document documento = new Document();
		try {
			PdfWriter.getInstance(documento, new FileOutputStream(nomeArquivo));
			documento.open();
			documento.add(new Paragraph(gerarResumo()));
			documento.close();
			System.out.println("Arquivo salvo com sucesso!");
		} catch (IOException e) {
			System.out.println("Erro de Leitura/Escrita: falha ao tentar salvar o arquivo.");
			System.out.println("Detalhes técnicos: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Erro inesperado: Ocorreu uma inconsistência ao gerar o relatório");
			e.printStackTrace();
		}
	}

}
