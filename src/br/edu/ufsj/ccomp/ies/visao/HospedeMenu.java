package br.edu.ufsj.ccomp.ies.visao;

import java.util.Scanner;

import br.edu.ufsj.ccomp.ies.controlador.HospedeControlador;
import br.edu.ufsj.ccomp.ies.factory.ControladorFactory;
import br.edu.ufsj.ccomp.ies.factory.HospedeControladorFactory;
import br.edu.ufsj.ccomp.ies.modelo.Entidade;
import br.edu.ufsj.ccomp.ies.modelo.Hospede;


public class HospedeMenu extends Menu {
	
	private Scanner scan = new Scanner(System.in);
	
	HospedeControladorFactory hcfactory =
			(HospedeControladorFactory)ControladorFactory.obterControladorFactory("hospede");
	HospedeControlador controlador = hcfactory.obterControlador();
	
	
	public Entidade cadastro() {

		//0:nome - 1: CPF - 2:telefone - 3:idade
        Object[] args = new Object[4];

        //garantindo que todos os objetos do array sejam inicialmente nulos
        for(int x = 0; x < 4; x++){
            args[x] = null;
        }
        
		System.out.print("Nome completo: ");
		args[0] = scan.next();
		System.out.print("CPF: ");
		args[1] = scan.nextDouble();
		System.out.print("Telefone (somente numeros): ");
		args[2] = scan.nextDouble();
		System.out.print("Idade: ");
		args[3] = scan.nextInt();
		
		Hospede h = (Hospede)controlador.cadastrar(args);
		if(h == null) {
			System.out.print("Erro: hospede nao cadastrado.");
			return null;
		}
		System.out.print("Hospede cadastrado com sucesso!\nID do hospede: " + h.getID());
		return h;
		
	}

	public void sair() {
		scan.close();
	}

	public void alteracao() {
		
		Hospede hospede = (Hospede)busca();
		if(hospede != null) {
			
			System.out.print("\nDeseja alterar o hospede selecionado?"
					+ "\n0 - Nao"
					+ "\n1 - Sim");
			Boolean opcao = scan.nextBoolean();
			
			if(opcao) {
				//0:nome - 1: CPF - 2:telefone - 3:idade
				Object[] args = new Object[4];
				
				System.out.print("\nDeseja alterar o nome?"
					+ "\n0 - Nao"
					+ "\n1 - Sim");
				if(scan.nextBoolean()) {
					System.out.print("Nome: ");
					args[0] = scan.next();
				}

				System.out.print("\nDeseja alterar o CPF?"
					+ "\n0 - Nao"
					+ "\n1 - Sim");
				if(scan.nextBoolean()) {
					System.out.print("CPF: ");
					args[1] = scan.nextDouble();
				}
				
				System.out.print("\nDeseja alterar o telefone?"
					+ "\n0 - Nao"
					+ "\n1 - Sim");
				if(scan.nextBoolean()) {
					System.out.print("Telefone: ");
					args[2] = scan.nextDouble();
				}
				
				System.out.print("\nDeseja alterar a idade?"
					+ "\n0 - Nao"
					+ "\n1 - Sim");
				if(scan.nextBoolean()) {
					System.out.print("Idade: ");
					args[3] = scan.nextInt();
				}
		
				controlador.alterar(hospede, args);
			}
			
		}
		
	}

	public void remocao() {
		
		Hospede hospede = (Hospede)busca();
		if(hospede != null) {
			
			System.out.print("\nDeseja remover o hospede selecionado?"
					+ "\n0 - Nao"
					+ "\n1 - Sim");
			Boolean opcao = scan.nextBoolean();
			
			if(opcao) {
				controlador.remover(hospede);
			}
			
		}
		
	}

	public Entidade busca() {
		System.out.print("\n------BUSCA------"
				+ "\n0 - Cancelar"
				+ "\n1 - Busca por ID"
				+ "\n2 - Busca por CPF");
		Integer opcao = scan.nextInt();
		if(opcao == 0) {
			
			return null;
			
		} else if(opcao == 1) {
			
			System.out.print("Insira o ID: ");
			Integer id = scan.nextInt();
			Hospede hospede = (Hospede)controlador.buscaID(id);
			System.out.print(hospede.toString());
			return hospede;
			
		} else if (opcao == 2) {
			
			System.out.print("Insira o CPF: ");
			Double cpf = scan.nextDouble();
			Hospede hospede = (Hospede)controlador.buscaAtributo(cpf);
			System.out.print(hospede.toString());
			return hospede;
			
		} else {
			// opcao invalida
			return null;
		}
	}
}
