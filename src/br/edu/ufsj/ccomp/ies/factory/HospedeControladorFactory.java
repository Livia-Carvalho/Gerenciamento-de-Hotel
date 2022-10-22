package br.edu.ufsj.ccomp.ies.factory;

import br.edu.ufsj.ccomp.ies.controlador.HospedeControlador;

public class HospedeControladorFactory extends ControladorFactory {
    
    public HospedeControlador obterControlador() {
		
		return new HospedeControlador();
		
	}
}
