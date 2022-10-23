package br.edu.ufsj.ccomp.ies.modelo;

import java.util.ArrayList;
import java.util.List;

public class Reserva extends Entidade{
	
	private Integer numeroQuarto;
	private List<Hospede> hospedes = new ArrayList<Hospede>();
	

	public String toString() {
		
		String listaHospedes = "\nHospedes na reserva:";
		
		for(Hospede h : hospedes) {
			listaHospedes = listaHospedes.concat(h.toString());
		}

		return "\nID da reserva: " + getID()
		+ "\nNumero do quarto: " + numeroQuarto
		+ listaHospedes;
	}
	
	public void addHospede(Hospede hospede) {
		hospedes.add(hospede);
	}
	
	public void removerHospede(Hospede hospede) {
		hospedes.remove(hospede);
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
