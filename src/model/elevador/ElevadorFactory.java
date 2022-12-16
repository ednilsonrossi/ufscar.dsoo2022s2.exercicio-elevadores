package model.elevador;

public class ElevadorFactory implements IElevadorFactory{

	@Override
	public IElevador factory() {
		Elevador e = new Elevador();
		return e;
	}
	
}
