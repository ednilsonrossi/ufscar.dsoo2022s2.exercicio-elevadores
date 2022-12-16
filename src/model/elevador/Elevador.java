package model.elevador;

import java.util.ArrayList;
import java.util.List;

import model.servicos.IServicoObserver;

class Elevador implements IElevador, IElevadorSubject, IServicos{
	
	private int andarAtual;
	private double velocidadeOperacao;
	
	private SomAmbiente somAmbiente;
	
	private IElevadorState state;
	private List<IServicoObserver> listObservers;
	
	public Elevador() {
		super();
		this.andarAtual = 0;
		this.velocidadeOperacao = 20.0;
		
		this.somAmbiente = new SomAmbiente();
		
		this.state = Pronto.getInstance();
		this.listObservers = new ArrayList<>();
	}

	public int getAndarAtual() {
		return andarAtual;
	}

	public void setAndarAtual(int andarAtual) {
		this.andarAtual = andarAtual;
	}

	public double getVelocidadeOperacao() {
		return velocidadeOperacao;
	}

	public void setVelocidadeOperacao(double velocidadeOperacao) {
		this.velocidadeOperacao = velocidadeOperacao;
	}
	
	public IElevadorState getState() {
		return this.state;
	}
	
	public void setState(IElevadorState state) {
		this.state = state;
		notification();
	}

	@Override
	public void chamar(int andar) {
		state.operar(this, andar);
	}

	@Override
	public void ligarSomAmbiente(String musica) {
		this.somAmbiente.ligar(musica);
	}

	@Override
	public void desligarSomAmbiente() {
		this.somAmbiente.desligar();
	}

	@Override
	public void alterarVelocidade(double velocidade) {
		setVelocidadeOperacao(velocidade);
		
	}

	@Override
	public double cargaAtual() {
		return 120.5;
	}

	@Override
	public void attach(IServicoObserver observer) {
		listObservers.add(observer);
		
	}

	@Override
	public void detach(IServicoObserver observer) {
		listObservers.remove(observer);
		
	}

	@Override
	public void notification() {
		for(IServicoObserver observer : listObservers) {
			observer.update(this);
		}
		
	}

	@Override
	public void descerTerreo() {
		setAndarAtual(0);
		setState(Manutencao.getInstance());
		state.operar(this, 0);
	}

	@Override
	public void liberar() {
		setState(Pronto.getInstance());
		state.operar(this, 0);
		ligarSomAmbiente("jazz");
	}

	@Override
	public void ativarRelaxamento() {
		ligarSomAmbiente("TOCANDO: Musiquinha ZEN");
	}
}
