package br.edu.ufsj.ccomp.ies.factory;

import br.edu.ufsj.ccomp.ies.modelo.Hospede;

public class HospedeFactory extends EntidadeFactory {
	
	public Hospede obterEntidade() {
		
		return new Hospede();
		
	}
	
}
