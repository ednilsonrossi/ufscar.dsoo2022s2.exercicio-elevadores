package model.elevador;

public class Pronto implements IElevadorState{

	private static Pronto instance = null;
	
	private Pronto() { 	}
	
	public static Pronto getInstance() {
		if(instance == null) {
			instance = new Pronto();
		}
		return instance;
	}

	@Override
	public void operar(Elevador context, int destino) {
		if(context.getState() == Emperrado.getInstance() || context.getState() == Manutencao.getInstance()) {
			context.getState().operar(context, destino);
		}else {
			if(context.getAndarAtual() == destino) {
				System.out.println("Beep de chegada");
				context.setState(Parado.getInstance());
			}else {
				if(context.getAndarAtual() > destino) {
					context.setState(Descendo.getInstance());
					context.setAndarAtual(context.getAndarAtual()-1);
					context.getState().operar(context, destino);
				}else {
					if(context.getAndarAtual() < destino) {
						context.setState(Subindo.getInstance());
						context.setAndarAtual(context.getAndarAtual()+1);
						context.getState().operar(context, destino);
					}
				}
			}
		}
	}
	
}
