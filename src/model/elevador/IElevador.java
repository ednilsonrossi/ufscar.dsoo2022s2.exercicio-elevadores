package model.elevador;

public interface IElevador {
	
	public abstract void chamar(int andar);
		
	public abstract void ligarSomAmbiente(String musica);
	
	public abstract void desligarSomAmbiente();
	
	public abstract void alterarVelocidade(double velocidade);
	
	public abstract double cargaAtual();

}
