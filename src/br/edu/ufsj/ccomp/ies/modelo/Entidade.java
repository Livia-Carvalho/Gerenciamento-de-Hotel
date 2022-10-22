package br.edu.ufsj.ccomp.ies.modelo;

public abstract class Entidade {
	
	private double ID;

	public String toString() {
		return "ID: " + ID;
	}

	public double getID() {
		return ID;
	}
	public void setID(double iD) {
		ID = iD;
	}
	
	
}
