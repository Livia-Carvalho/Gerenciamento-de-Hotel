package br.edu.ufsj.ccomp.ies.factory;

import br.edu.ufsj.ccomp.ies.visao.HospedeMenu;

public class HospedeMenuFactory extends MenuFactory {
    
    public HospedeMenu obterMenu() {
		
		return new HospedeMenu();
		
	}
}
