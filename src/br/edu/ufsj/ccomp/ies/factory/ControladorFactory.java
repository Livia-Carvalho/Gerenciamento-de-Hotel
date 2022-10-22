package br.edu.ufsj.ccomp.ies.factory;

import br.edu.ufsj.ccomp.ies.controlador.Controlador;

public abstract class ControladorFactory {

    public static ControladorFactory obterControladorFactory(String controlador) {
		
		if(controlador.equalsIgnoreCase("hospede")) {
			
			return new HospedeControladorFactory();
			
		} else if(controlador.equalsIgnoreCase("reserva")) {
			
			return new ReservaControladorFactory();
			
		}
		return null;
	}

	public abstract Controlador obterControlador();

}
