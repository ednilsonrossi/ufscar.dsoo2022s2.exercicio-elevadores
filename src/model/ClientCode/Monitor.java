package model.ClientCode;

import java.util.ArrayList;
import java.util.List;

import model.elevador.ElevadorFactory;
import model.elevador.IElevador;
import model.elevador.IElevadorSubject;
import model.elevador.IServicos;
import model.servicos.ServicoEmergencia;
import model.servicos.ServicoEntretenimento;
import model.servicos.ServicoManutencao;

public class Monitor {
	
	private static Monitor instance = null;
	
	private List<IElevador> listElevadores;
	
	private Monitor() {
		listElevadores = new ArrayList<>();
	}
	
	public static Monitor getInstance() {
		if(instance == null) {
			instance = new Monitor();
		}
		return instance;
	}

	public List<IElevador> getListIElevadores() {
		return listElevadores;
	}
	
	
	public static void main(String[] args) {
		
		Monitor monitor = Monitor.getInstance();
		
		//Criando elevadores
		ElevadorFactory fabrica = new ElevadorFactory();
		monitor.getListIElevadores().add(fabrica.factory());
		monitor.getListIElevadores().add(fabrica.factory());
		monitor.getListIElevadores().add(fabrica.factory());
		
		//Ligar com de todos elevadores
		for(IElevador e : monitor.getListIElevadores()) {
			e.ligarSomAmbiente("jazz");
		}
		
		//Declarar observadores
		for(IElevador e : monitor.listElevadores) {
			IElevadorSubject es = (IElevadorSubject) e;
			es.attach(new ServicoEntretenimento());
			es.attach(new ServicoEmergencia());
			es.attach(new ServicoManutencao());
			
		}
		
		monitor.getListIElevadores().get(0).chamar(18);
		monitor.getListIElevadores().get(0).chamar(5);
		monitor.getListIElevadores().get(0).chamar(-4);
		monitor.getListIElevadores().get(0).chamar(10);
		
	}
}
