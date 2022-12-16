package model.elevador;

import model.ClientCode.Constants;

public class Descendo implements IElevadorState {

	private static Descendo instance = null;
	
	private Descendo() { 	}
	
	public static Descendo getInstance() {
		if(instance == null) {
			instance = new Descendo();
		}
		return instance;
	}

	@Override
	public void operar(Elevador context, int destino) {
		System.out.println("v " + context.getAndarAtual());
		if(destino < Constants.SUBSOLO) {
			context.setState(Emperrado.getInstance());
			context.getState().operar(context, destino);
		}else {
			if(context.getAndarAtual() == destino) {
				System.out.println("Beep de chegada");
				context.setState(Parado.getInstance());
				context.getState().operar(context, destino);
			}else{
				context.setAndarAtual(context.getAndarAtual()-1);
				context.getState().operar(context, destino);
			}
		}
	}
}
