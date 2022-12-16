package model.servicos;

import model.elevador.IElevadorSubject;

public interface IServicoObserver {
	
	public abstract void update(IElevadorSubject subject);
	
}
