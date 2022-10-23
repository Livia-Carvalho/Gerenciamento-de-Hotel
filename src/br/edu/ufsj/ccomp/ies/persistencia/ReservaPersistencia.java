package br.edu.ufsj.ccomp.ies.persistencia;

import java.util.ArrayList;
import java.util.List;
import br.edu.ufsj.ccomp.ies.modelo.Entidade;
import br.edu.ufsj.ccomp.ies.modelo.Hospede;
import br.edu.ufsj.ccomp.ies.modelo.Reserva;

public class ReservaPersistencia extends Persistencia {
	
	List<Reserva> reservas = new ArrayList<Reserva>();
	
	//SINGLETON
	private static ReservaPersistencia uniqueInstance;
	private ReservaPersistencia() { }
	public static ReservaPersistencia getInstance(){
		if(uniqueInstance == null)
			uniqueInstance = new ReservaPersistencia();
		return uniqueInstance;
	}


	public void cadastrar(Entidade reserva, Object args[]) {
		Reserva r = (Reserva)reserva;
		r.setNumeroQuarto((Integer)args[0]);
		
		adicionar(r);
	}

	public void adicionar(Entidade reserva) {
		Reserva r = (Reserva)reserva;
		if(reservas.contains(r)) {
			//reserva ja cadastrada
			return;
		} 

		for(Reserva res : reservas){
			if(res.getNumeroQuarto().equals(r.getNumeroQuarto())){
				//quarto ocupado
				return;
			}
		}
		reservas.add(r);
	}

	public void addHospede(Reserva reserva, Hospede hospede) {
		if(hospede.getHospedado()) {
			//hospede selecionado ja esta hospedado
			return;
		}
		reserva.addHospede(hospede);
		hospede.setHospedado(true);
		//adicionado com sucesso
	}
	
	public void removerHospede(Reserva reserva, Hospede hospede) {
		if(!reserva.getHospedes().contains(hospede)
				|| reserva.getHospedes().size() == 1) {
			//hospede selecionado ja esta na reserva
			//ou nao pode haver reserva sem hospedes
			return;
		}
		reserva.removerHospede(hospede);
		hospede.setHospedado(false);
		//adicionado com sucesso
	}

	public void alterar(Entidade reserva, Object args[]) {
		Reserva r = (Reserva)reserva;
		r.setNumeroQuarto((Integer)args[0]);
	}

	public void remover(Entidade reserva) {
		Reserva r = (Reserva)reserva;
		if(reservas.contains(r)) {
			reservas.remove(r);
		}
	}

	public Reserva buscar(Integer ID) {
		for(Reserva reserva : reservas) {
			if(reserva.getID().equals(ID)){
				return reserva;
			}
		}
		return null;
	}

	public Reserva buscar(String numeroQuarto) {
		Integer quarto = Integer.parseInt(numeroQuarto);
		for(Reserva reserva : reservas) {
			if(reserva.getNumeroQuarto().equals(quarto)){
				return reserva;
			}
		}
		return null;
	}
}
