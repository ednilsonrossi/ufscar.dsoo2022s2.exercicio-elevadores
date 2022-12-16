package model.elevador;

public class Emperrado implements IElevadorState {

	private static Emperrado instance = null;
	
	private Emperrado() { 	}
	
	public static Emperrado getInstance() {
		if(instance == null) {
			instance = new Emperrado();
		}
		return instance;
	}
	
	@Override
	public void operar(Elevador context, int destino) {
		System.out.println("Estado: emprerrado, aguardo ação de manutenção");
		context.setState(Manutencao.getInstance());
	}

}
