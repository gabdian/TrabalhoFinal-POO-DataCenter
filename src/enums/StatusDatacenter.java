package enums;

public enum StatusDatacenter {

	ATIVO("Ativo", true),

	EM_MANUTENCAO("Em manutenção", false),

	INATIVO("Inativo", false);

	private final String descricao;
	private final boolean operacional;

	StatusDatacenter(String descricao, boolean operacional) {
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
