package br.edu.ufsj.ccomp.ies.modelo;

import java.util.ArrayList;
import java.util.List;

public class Reserva extends Entidade{
	
	private Integer numeroQuarto;
	List<Hospede> hospedes = new ArrayList<Hospede>();
	


	public String toString() {
		return "ID: " + getID()
		+ "Numero do quarto: " + numeroQuarto;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}
	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}
	public List<Hospede> getHospedes() {
		return hospedes;
	}
	public void setHospedes(List<Hospede> hospedes) {
		this.hospedes = hospedes;
	}
	
}
