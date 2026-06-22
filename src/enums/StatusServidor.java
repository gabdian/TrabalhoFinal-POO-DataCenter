package enums;

public enum StatusServidor {

	ONLINE("Online", true),

	OFFLINE("Offline", false),

	SOBRECARGA("Sobrecarga", true),

	MANUTENCAO("Manutenção", false);

	private final String descricao;
	private final boolean operacional;

	StatusServidor(String descricao, boolean operacional) {
		this.descricao = descricao;
		this.operacional = operacional;
	}

	public String getDescricao() {
		return descricao;
	}

	public boolean isOperacional() {
		return operacional;
	}
}
