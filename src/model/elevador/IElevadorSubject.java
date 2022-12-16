package model.elevador;

import model.servicos.IServicoObserver;

public interface IElevadorSubject {
	
	public abstract void attach(IServicoObserver observer);
	
	public abstract void detach(IServicoObserver observer);
	
	public abstract void notification();
	
}
