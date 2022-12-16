package model.elevador;

public class Manutencao implements IElevadorState {

	private static Manutencao instance = null;
	
	private Manutencao() { 	}
	
	public static Manutencao getInstance() {
		if(instance == null) {
			instance = new Manutencao();
		}
		return instance;
	}
	
	@Override
	public void operar(Elevador context, int destino) {
		System.out.println("Mesangem: elevador em manutenção, utilize outro.");
	}

}
