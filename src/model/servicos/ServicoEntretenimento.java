package model.servicos;

import model.elevador.Emperrado;
import model.elevador.IElevadorSubject;
import model.elevador.IServicos;

public class ServicoEntretenimento implements IServicoObserver{
	
	private IServicos elevador;

	@Override
	public void update(IElevadorSubject subject) {
		elevador = (IServicos) subject;
		if(elevador.getState() == Emperrado.getInstance()) {
			elevador.ativarRelaxamento();
		}
	}
}
