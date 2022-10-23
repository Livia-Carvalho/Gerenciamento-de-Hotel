package br.edu.ufsj.ccomp.ies.factory;

import br.edu.ufsj.ccomp.ies.controlador.Controlador;
import br.edu.ufsj.ccomp.ies.modelo.Entidade;
import br.edu.ufsj.ccomp.ies.persistencia.Persistencia;
import br.edu.ufsj.ccomp.ies.visao.Menu;

public abstract class Factory {
	
	public static Factory obterFactory(String fabrica) {
		
		if(fabrica.equalsIgnoreCase("hospede")) {
			
			return new HospedeFactory();
			
		} else if(fabrica.equalsIgnoreCase("reserva")) {
			
			return new ReservaFactory();
			
		}
		return null;
	}
	
	public abstract Entidade criarEntidade();
	public abstract Persistencia criarPersistencia();
	public abstract Controlador criarControlador();
	public abstract Menu criarMenu();
}
