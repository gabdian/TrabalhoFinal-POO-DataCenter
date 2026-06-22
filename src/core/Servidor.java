package core;

import enums.StatusServidor;
import sensor.Sensor;

import java.util.ArrayList;
import java.util.List;

public class Servidor {

    private int id;

    private String nome;

    private String enderecoIP;

    private String sistemaOperacional;

    private List<Sensor> sensores;

    private StatusServidor status;

    public Servidor(int id, String nome, String enderecoIP, String sistemaOperacional) {
        this.id = id;
        this.nome = nome;
        this.enderecoIP = enderecoIP;
        this.sistemaOperacional = sistemaOperacional;
        this.sensores = new ArrayList<>();
        this.status = StatusServidor.ONLINE;
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

    public String getEnderecoIP() {
        return enderecoIP;
    }

    public void setEnderecoIP(String enderecoIP) {
        this.enderecoIP = enderecoIP;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public void setSistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }

    public List<Sensor> getSensores() {
        return this.sensores;
    }

    public void setSensores(List<Sensor> sensores) {
        this.sensores = sensores;
    }

    public StatusServidor getStatus() {
        return status;
    }

    public void setStatus(StatusServidor status) {
        this.status = status;
    }

    public boolean adicionarSensor(Sensor sensor) {
        sensores.add(sensor);
        return true;
    }

    public boolean removerSensor(Sensor sensor) {
        sensores.remove(sensor);
        return true;
    }

    public double calcularCargaMedia() {
        if (sensores == null || sensores.isEmpty()) {
            return 0.0;
        }

        double soma = 0.0;
        for (Sensor sensor : sensores) {
            soma += sensor.getLeituraAtual();
        }

        return soma / sensores.size();
    }

    public double verificarSaudeServidor() {
        double carga = calcularCargaMedia();

        return Math.max(0.0, 100.0 - carga);
    }

    public String gerarResumo() {
        return "Id" + id +
                "Nome:" + nome +
                "EnderecoIP:" + enderecoIP +
                "SO: " + sistemaOperacional +
                "Sensores: " + sensores.size() +
                "Status: " + status;
    }

}
