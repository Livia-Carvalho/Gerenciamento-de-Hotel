package br.edu.ufsj.ccomp.ies.visao;

import java.util.Scanner;

import br.edu.ufsj.ccomp.ies.modelo.Entidade;


public abstract class Menu {

	private Scanner scan = new Scanner(System.in);
	
	public void rodar() {
		int input;
		do{
			input = menu();
			switch (input) {
	            case 0:
	                sair();
	                return;

	            case 1:
	            	cadastro();
	            	break;

                case 2:
                    alteracao();
                    break;

                case 3:
                    remocao();
                    break;

                case 4:
                    busca();
                    break;

	            default:
	                System.out.print("Opcao invalida. ");
	                break;
            }

		} while(input != 0);
		       
	}

	public int menu() {    
		System.out.println("\n\n0 - Sair"
				+ "\n1 - Cadastrar hospede"
				+ "\n2 - Alterar dados de hospede"
				+ "\n3 - Remover hospede"
				+ "\n4 - Buscar hospede");
		System.out.print("Sua opcao: ");
		return scan.nextInt();
	}

	public void sair() {
		scan.close();
	}

    public abstract Entidade cadastro();

    public abstract void alteracao();

    public abstract void remocao();

    public abstract Entidade busca();
	
}
