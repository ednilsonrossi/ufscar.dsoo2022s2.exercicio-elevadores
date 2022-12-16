package model.servicos;

import model.elevador.Emperrado;
import model.elevador.IElevadorSubject;
import model.elevador.IServicos;

public class ServicoEmergencia implements IServicoObserver{

	private IServicos elevador;

	public void resgatarUsuarios() {
		System.out.println("Usuários liberados.");
	}
	
	@Override
	public void update(IElevadorSubject subject) {
		this.elevador = (IServicos) subject;
		if(elevador.getState() == Emperrado.getInstance()) {
			resgatarUsuarios();
		}
	}
}
