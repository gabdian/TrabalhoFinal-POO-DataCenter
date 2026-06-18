package dispositivo;

public abstract interface Monitoravel {

	public abstract Monitoravel();

	public abstract void ligar();

	public abstract void desligar();

	public abstract boolean verificarStatus();

}
