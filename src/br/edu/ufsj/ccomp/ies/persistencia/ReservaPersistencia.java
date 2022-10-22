package br.edu.ufsj.ccomp.ies.persistencia;

import java.util.ArrayList;
import java.util.List;
import br.edu.ufsj.ccomp.ies.modelo.Entidade;
import br.edu.ufsj.ccomp.ies.modelo.Hospede;
import br.edu.ufsj.ccomp.ies.modelo.Reserva;

public class ReservaPersistencia extends Persistencia {
	
	List<Reserva> reservas = new ArrayList<Reserva>();
	
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
		if(!reservas.contains(r)) {
			reservas.add((Reserva)r);
		}
	}

	public void addHospede(Reserva reserva, Hospede hospede) {
		reserva.getHospedes().add(hospede);
	}

	public void alterar(Entidade reserva, Object args[]) {
		Reserva r = (Reserva)reserva;
		r.setNumeroQuarto((Integer)args[0]);
	}

	public void remover(Entidade reserva) {
		Reserva r = (Reserva)reserva;
		if(!reservas.contains(r)) {
			reservas.remove(r);
		}
	}

	public Reserva buscaID(Integer ID) {
		for(Reserva reserva : reservas) {
			if(reserva.getID() == ID){
				return reserva;
			}
		}
		return null;
	}

	public Reserva buscaAtributo(Object numeroQuarto) {
		for(Reserva reserva : reservas) {
			if(reserva.getNumeroQuarto()== (Integer)numeroQuarto){
				return reserva;
			}
		}
		return null;
	}
}
