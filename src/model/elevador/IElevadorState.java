package model.elevador;

public interface IElevadorState {
	
	public abstract void operar(Elevador context, int destino);
	
}
