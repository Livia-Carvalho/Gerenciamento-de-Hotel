package br.edu.ufsj.ccomp.ies.factory;

import br.edu.ufsj.ccomp.ies.controlador.Controlador;
import br.edu.ufsj.ccomp.ies.controlador.ReservaControlador;
import br.edu.ufsj.ccomp.ies.modelo.Entidade;
import br.edu.ufsj.ccomp.ies.modelo.Reserva;
import br.edu.ufsj.ccomp.ies.persistencia.Persistencia;
import br.edu.ufsj.ccomp.ies.persistencia.ReservaPersistencia;
import br.edu.ufsj.ccomp.ies.visao.Menu;
import br.edu.ufsj.ccomp.ies.visao.ReservaMenu;

public class ReservaFactory extends Factory {

	public Entidade criarEntidade() {
		return new Reserva();
	}

	public Persistencia criarPersistencia() {
		return ReservaPersistencia.getInstance();
	}

	public Controlador criarControlador() {
		return ReservaControlador.getInstance();
	}

	public Menu criarMenu() {
		return ReservaMenu.getInstance();
	}

}
