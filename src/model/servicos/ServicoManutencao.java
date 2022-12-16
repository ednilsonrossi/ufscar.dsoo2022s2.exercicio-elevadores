package model.servicos;

import model.elevador.Emperrado;
import model.elevador.IElevadorSubject;
import model.elevador.IServicos;

public class ServicoManutencao implements IServicoObserver {

	private IServicos elevador;
	
	public void realizarManutencao() {
		elevador.descerTerreo();
		elevador.liberar();
	}
	
	@Override
	public void update(IElevadorSubject subject) {
		this.elevador = (IServicos) subject;
		if(elevador.getState() == Emperrado.getInstance()) {
			realizarManutencao();
			System.out.println("Elevador consertado!!!");
		}
	}

}
