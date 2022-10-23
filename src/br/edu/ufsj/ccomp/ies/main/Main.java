package br.edu.ufsj.ccomp.ies.main;

import br.edu.ufsj.ccomp.ies.factory.Factory;
import br.edu.ufsj.ccomp.ies.visao.ReservaMenu;
import br.edu.ufsj.ccomp.ies.visao.HospedeMenu;
import br.edu.ufsj.ccomp.ies.visao.MenuPrincipal;

public class Main {
	
	public static void main(String args[]){
				
		MenuPrincipal menuPrincipal = new MenuPrincipal();
		HospedeMenu hospedeMenu = (HospedeMenu)Factory.obterFactory("hospede").criarMenu();
		ReservaMenu reservaMenu = (ReservaMenu)Factory.obterFactory("reserva").criarMenu();		
		
		int opcao = 0;
		do {
			opcao = menuPrincipal.selecionarMenu();
			
			if(opcao == 1) {
				hospedeMenu.rodar();
			} else if(opcao == 2) {
				reservaMenu.rodar();
			}else if (opcao != 0) {
				// opcao invalida
			}
		}while(opcao != 0);
	}
}
