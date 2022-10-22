package br.edu.ufsj.ccomp.ies.persistencia;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import br.edu.ufsj.ccomp.ies.modelo.Entidade;
import br.edu.ufsj.ccomp.ies.modelo.Reserva;

public class ReservaPersistencia extends Persistencia {
	
	List<Reserva> reservas = new ArrayList<Reserva>();
	
	private static final ReservaPersistencia uniqueInstance = new ReservaPersistencia();
		private ReservaPersistencia() { }
		public static ReservaPersistencia getInstance(){
		return uniqueInstance;
	}

	public void cadastrar(Entidade reserva, Object args[]) {
		Reserva r = (Reserva)reserva;
		r.setNumeroQuarto((String)args[0]);
	}

	public void adicionar(Entidade reserva) {
		Reserva r = (Reserva)reserva;
		if(!reservas.contains(r)) {
			reservas.add((Reserva)r);
		}
	}

	public void alterar(Entidade reserva, Object args[]) {
		Reserva r = (Reserva)reserva;
		r.setNumeroQuarto((String)args[0]);
	}

	public void remover(Entidade reserva) {
		Reserva r = (Reserva)reserva;
		if(!reservas.contains(r)) {
			reservas.remove(r);
		}
	}

	public Reserva buscar(Integer ID) {
		for(Reserva reserva : reservas) {
			if(reserva.getID() == ID){
				return reserva;
			}
		}
		return null;
	}

	public Reserva buscar(String numeroQuarto) {
		for(Reserva reserva : reservas) {
			if(Objects.equals(reserva.getNumeroQuarto(), numeroQuarto)){
				return reserva;
			}
		}
		return null;
	}
}
