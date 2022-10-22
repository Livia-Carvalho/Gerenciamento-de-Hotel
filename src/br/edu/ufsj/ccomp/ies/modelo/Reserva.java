package br.edu.ufsj.ccomp.ies.modelo;

import java.util.ArrayList;
import java.util.List;

public class Reserva extends Entidade{
	
	private String numeroQuarto;
	List<Hospede> hospedes = new ArrayList<Hospede>();
	


	public String toString() {
		return "ID: " + getID()
		+ "Numero do quarto: " + numeroQuarto;
	}

	public String getNumeroQuarto() {
		return numeroQuarto;
	}
	public void setNumeroQuarto(String numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}
	public List<Hospede> getHospedes() {
		return hospedes;
	}
	public void setHospedes(List<Hospede> hospedes) {
		this.hospedes = hospedes;
	}
	
}
