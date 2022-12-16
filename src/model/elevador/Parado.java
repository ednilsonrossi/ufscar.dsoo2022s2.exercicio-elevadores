package model.elevador;

public class Parado implements IElevadorState{

	private static Parado instance = null;
	
	private Parado() { 	}
	
	public static Parado getInstance() {
		if(instance == null) {
			instance = new Parado();
		}
		return instance;
	}

	@Override
	public void operar(Elevador context, int destino) {
		System.out.println("Mensagem: Abrindo portas");
		context.setState(Pronto.getInstance());
	}
	
	
}
