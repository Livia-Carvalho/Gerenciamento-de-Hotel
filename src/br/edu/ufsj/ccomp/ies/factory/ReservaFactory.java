package br.edu.ufsj.ccomp.ies.factory;

import br.edu.ufsj.ccomp.ies.modelo.Reserva;

public class ReservaFactory extends EntidadeFactory {

	public Reserva obterEntidade() {
		
		return new Reserva();
		
	}

}
