import dispositivo.*;
import enums.*;
import relatorio.Relatorio;
import core.*;
import sensor.*;
import telas.DashboardGUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String []args){
        System.out.println(">>> INICIANDO SISTEMA DE GERENCIAENTO DO DATA CENTER <<<");
        DataCenter dcAlpha = new DataCenter(1, "DC Alpha Central", "Porto Alegre");
        System.out.println("Informações do Data Center: " + dcAlpha.getNome() + "inicializando.");

        SistemaRefrigeracao arCondicionado = new SistemaRefrigeracao(24.0);
        GeradorEnergia gerador = new GeradorEnergia();
        Nobreak noBreak = new Nobreak();
        SistemaAlerta alerta = new SistemaAlerta();

        dcAlpha.cadastrarDispositivo(arCondicionado);
        dcAlpha.cadastrarDispositivo(gerador);
        dcAlpha.cadastrarDispositivo(noBreak);
        dcAlpha.cadastrarDispositivo(alerta);

        Servidor serv1 = new Servidor(101, "Servidor Banco de Dados", "101215", "Linux");
        serv1.setStatus(StatusServidor.ONLINE);

        Servidor serv2 = new Servidor(102, "Servidor Aplicação Web", "101216", "Windows");
        serv2.setStatus(StatusServidor.ONLINE);

        Servidor serv3 = new Servidor(103, "Servidor de Backup", "101217", "Linux");
        serv3.setStatus(StatusServidor.MANUTENCAO);

        Sensor temp1 = new SensorTemperatura(1, "Temperatura", "°C", 26.5, 18.0, 24.0);
        Sensor cpu1 = new SensorTemperatura(2, "CPU", "%", 85.0, 0.0, 80.0);
        Sensor energia1 = new SensorEnergia(3, "Energia", "W", 450.0, 200.0, 600.0);
        Sensor mem1 = new SensorMemoria(4, "Memoria", "%", 90.0, 0.0, 80.0);

        Sensor temp2 = new SensorTemperatura(5, "Temperatura", "°C", 22.0, 18.0, 24.0);
        Sensor cpu2 = new SensorTemperatura(6, "CPU", "%", 40.0, 0.0, 80.0);
        Sensor energia2 = new SensorEnergia(7, "Energia", "W", 300.0, 200.0, 600.0);
        Sensor mem2 = new SensorMemoria(8, "Memoria", "%", 45.0, 0.0, 80.0);

        serv1.adicionarSensor(temp1);
        serv1.adicionarSensor(cpu1);
        serv1.adicionarSensor(energia1);
        serv1.adicionarSensor(mem1);

        serv2.adicionarSensor(temp2);
        serv2.adicionarSensor(cpu2);
        serv2.adicionarSensor(energia2);
        serv2.adicionarSensor(mem2);

        dcAlpha.cadastrarServidor(serv1);
        dcAlpha.cadastrarServidor(serv2);
        dcAlpha.cadastrarServidor(serv3);

        System.out.println("/n>>> EXECUTANDO VERIFICAÇÃO DE INFRAESTRUTURA <<<");

        double temperaturaAtual = dcAlpha.calcularMediaTemperatura();
        boolean houveQuedaDeEnergia = true;

        System.out.println("Temperatura Média Calculada: " + String.format("%.2f", temperaturaAtual) + " °C");

        if (temperaturaAtual > 24.0) {
            alerta.emitirAlertaCriticidade("Temperatura Média excedeu o limite seguro!");
        }
        if (houveQuedaDeEnergia) {
            alerta.emitirAlertaCriticidade("Queda de energia externa detectada.");
        }

        arCondicionado.avaliarTemperatura(temperaturaAtual);
        noBreak.assumirCarga(houveQuedaDeEnergia);
        gerador.monitorarRedeEletrica(!houveQuedaDeEnergia);

        System.out.println("\n>>> VERIFICANDO STATUS DOS SERVIDORES <<<");
        Map<StatusServidor, Long> painelStatus = dcAlpha.agruparServidoresPorStatus();
        painelStatus.forEach((status, quantidade) -> System.out.println("- " + status + ": " +  quantidade + "servidor(es)"));

        System.out.println("\n>>> GERANDO RELATÓRIO FINAL <<<");
        List<String> listaAlertasParaRelatorio = new ArrayList<>();

        System.out.println("Tratando alertas pendentes...");
        String alertaPendente = alerta.tratarProximoAlerta();

        while(alertaPendente != null){
            listaAlertasParaRelatorio.add(alertaPendente);
            alertaPendente = alerta.tratarProximoAlerta();
        }

        String resumo = dcAlpha.gerarRelatorioGeral(listaAlertasParaRelatorio);
        System.out.println(resumo);
        System.out.println("Iniciando Painel de Controle Gráfico...");
        DashboardGUI tela = new DashboardGUI();
        tela.exibirTela(resumo);

        System.out.println(">>> SIMULAÇÃO ENCERRADA COM SUCESSO <<<");
    }
}
