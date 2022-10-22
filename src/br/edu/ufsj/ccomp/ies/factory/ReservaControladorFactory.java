package br.edu.ufsj.ccomp.ies.factory;

import br.edu.ufsj.ccomp.ies.controlador.ReservaControlador;

public class ReservaControladorFactory extends ControladorFactory {

    public ReservaControlador obterControlador() {
		
		return ReservaControlador.getInstance();
		
	}
}
