package br.edu.ufsj.ccomp.ies.factory;

import br.edu.ufsj.ccomp.ies.controlador.Controlador;
import br.edu.ufsj.ccomp.ies.controlador.HospedeControlador;
import br.edu.ufsj.ccomp.ies.modelo.Entidade;
import br.edu.ufsj.ccomp.ies.modelo.Hospede;
import br.edu.ufsj.ccomp.ies.persistencia.HospedePersistencia;
import br.edu.ufsj.ccomp.ies.persistencia.Persistencia;
import br.edu.ufsj.ccomp.ies.visao.HospedeMenu;
import br.edu.ufsj.ccomp.ies.visao.Menu;

public class HospedeFactory extends Factory {

	public Entidade criarEntidade() {
		return new Hospede();
	}

	public Persistencia criarPersistencia() {
		return HospedePersistencia.getInstance();
	}

	public Controlador criarControlador() {
		return HospedeControlador.getInstance();
	}

	public Menu criarMenu() {
		return HospedeMenu.getInstance();
	}
	
}
