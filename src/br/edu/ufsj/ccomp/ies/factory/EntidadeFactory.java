package br.edu.ufsj.ccomp.ies.factory;

import br.edu.ufsj.ccomp.ies.modelo.Entidade;

public abstract class EntidadeFactory {

	public static EntidadeFactory obterEntidadeFactory(String entidade) {
		
		if(entidade.equalsIgnoreCase("hospede")) {
			
			return new HospedeFactory();
			
		} else if(entidade.equalsIgnoreCase("reserva")) {
			
			return new ReservaFactory();
			
		}
		return null;
	}

	public abstract Entidade obterEntidade();

}