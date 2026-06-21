package core;

import enums.statusservidor;

import java.util.List;

import java.util.List;

public class Servidor {

	private int id;

	private String nome;

	private String enderecoIP;

	private String sistemaOperacional;

	private List sensores;

	private statusservidor status;

	public Servidor(int id, String nome, String enderecoIP, String sistemaOperacional, List sensores, StatusServidor status) {
		this.id = id;
		this.nome = nome;
		this.enderecoIP = enderecoIP;
		this.sistemaOperacional = sistemaOperacional;
		this.sensores = sensores;
		this.status = status;
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

	public List getSensores() {
		return sensores;
	}

	public void setSensores(List sensores) {
		this.sensores = sensores;
	}

	public StatusServidor getStatus() {
		return status;
	}

	public void setStatus(StatusServidor status) {
		this.status = status;
	}

	public Servidor(int id, String nome, String enderecoIP, String sistemaOperacional, List sensores, StatusServidor status) {
		this.id = id;
		this.nome = nome;
		this.enderecoIP = enderecoIP;
		this.sistemaOperacional = sistemaOperacional;
		this.sensores = sensores;
		this.status = status;
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

	public List getSensores() {
		return sensores;
	}

	public void setSensores(List sensores) {
		this.sensores = sensores;
	}

	public StatusServidor getStatus() {
		return status;
	}

	public void setStatus(StatusServidor status) {
		this.status = status;
	}

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
