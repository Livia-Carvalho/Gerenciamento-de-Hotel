package br.edu.ufsj.ccomp.ies.visao;

import java.util.Scanner;

public class MenuPrincipal {

	private Scanner scan = new Scanner(System.in);
	  
	public int selecionarMenu() {
		System.out.println("\n\n0 - Sair"
				+ "\n1 - Gerenciar hospedes"
				+ "\n2 - Gerenciar reservas");
		System.out.print("Sua opcao: ");
		return scan.nextInt();
	}
	
}
