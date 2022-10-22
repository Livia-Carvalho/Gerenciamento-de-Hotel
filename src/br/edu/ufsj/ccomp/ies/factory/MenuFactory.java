package br.edu.ufsj.ccomp.ies.factory;

import br.edu.ufsj.ccomp.ies.visao.Menu;

public abstract class MenuFactory {

    public static MenuFactory obterMenuFactory(String menu) {
		
		if(menu.equalsIgnoreCase("hospede")) {
			
			return new HospedeMenuFactory();
			
		} else if(menu.equalsIgnoreCase("reserva")) {
			
			return new ReservaMenuFactory();
			
		}
		return null;
	}

	public abstract Menu obterMenu();

}
