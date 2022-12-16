package model.elevador;

public interface IServicos {
	public abstract void descerTerreo();
	
	public abstract void liberar();
	
	public abstract IElevadorState getState();
	
	public abstract void ativarRelaxamento();
}
