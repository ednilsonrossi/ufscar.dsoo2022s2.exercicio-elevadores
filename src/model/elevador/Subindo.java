package model.elevador;

import model.ClientCode.Constants;

public class Subindo implements IElevadorState {

	private static Subindo instance = null;
	
	private Subindo() { 	}
	
	public static Subindo getInstance() {
		if(instance == null) {
			instance = new Subindo();
		}
		return instance;
	}
	
	@Override
	public void operar(Elevador context, int destino) {
		System.out.println("^ " + context.getAndarAtual());
		if(destino > Constants.ANDARES) {
			context.setState(Emperrado.getInstance());
			context.getState().operar(context, destino);
		}else {
			if(context.getAndarAtual() == destino) {
				System.out.println("Beep de chegada");
				context.setState(Parado.getInstance());
				context.getState().operar(context, destino);
			}else{
				context.setAndarAtual(context.getAndarAtual()+1);
				context.getState().operar(context, destino);
			}
		}
	}
	
	

}
