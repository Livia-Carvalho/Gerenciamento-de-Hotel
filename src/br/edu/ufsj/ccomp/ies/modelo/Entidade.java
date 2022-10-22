package br.edu.ufsj.ccomp.ies.modelo;

public abstract class Entidade {
	
	private Integer ID;

	public String toString() {
		return "ID: " + ID;
	}

	public Integer getID() {
		return ID;
	}
	public void setID(Integer ID) {
		this.ID = ID;
	}
	
	
}
