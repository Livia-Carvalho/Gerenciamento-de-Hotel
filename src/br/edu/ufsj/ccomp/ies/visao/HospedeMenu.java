package br.edu.ufsj.ccomp.ies.visao;

import java.util.Scanner;

import br.edu.ufsj.ccomp.ies.controlador.HospedeControlador;
import br.edu.ufsj.ccomp.ies.factory.Factory;
import br.edu.ufsj.ccomp.ies.main.Console;
import br.edu.ufsj.ccomp.ies.modelo.Entidade;
import br.edu.ufsj.ccomp.ies.modelo.Hospede;


public class HospedeMenu extends Menu {
	
	//SINGLETON
	private static HospedeMenu uniqueInstance;
	private HospedeMenu() { }
	public static HospedeMenu getInstance(){
		if(uniqueInstance == null)
			uniqueInstance = new HospedeMenu();
		return uniqueInstance;
	}

	private Scanner scan = new Scanner(System.in);
	
	HospedeControlador controlador =
			(HospedeControlador)Factory.obterFactory("hospede").criarControlador();
	
	
	public Entidade cadastro() {

		//0:nome - 1: CPF - 2:telefone - 3:idade
        Object[] args = new Object[4];

        //garantindo que todos os objetos do array sejam inicialmente nulos
        for(int x = 0; x < 4; x++){
            args[x] = null;
        }
        
		System.out.print("Nome completo: ");
		args[0] = Console.readLine();
		System.out.print("CPF (somente numeros): ");
		args[1] = scan.nextLong();
		System.out.print("Telefone (somente numeros): ");
		args[2] = scan.nextLong();
		System.out.print("Idade: ");
		args[3] = scan.nextInt();
		
		Hospede h = (Hospede)controlador.cadastrar(args);
		if(h == null) {
			System.out.print("\nErro: hospede nao cadastrado.");
			return null;
		}
		System.out.print("\nHospede cadastrado com sucesso!\nID do hospede: " + h.getID());
		return h;
		
	}

	public void alteracao() {
		
		Hospede hospede = (Hospede)busca();
		if(hospede != null) {
			
			System.out.print("\nDeseja alterar o hospede selecionado?"
					+ "\n0 - Nao"
					+ "\n1 - Sim");
			System.out.println("\nSua opcao: ");
			Integer opcao = scan.nextInt();
			
			if(opcao == 1) {
				//0:nome - 1: CPF - 2:telefone - 3:idade
				Object[] args = new Object[4];
				//garantindo que todos os objetos do array sejam inicialmente nulos
		        for(int x = 0; x < 4; x++){
		            args[x] = null;
		        }
		        
				System.out.print("\nDeseja alterar o nome?"
					+ "\n0 - Nao"
					+ "\n1 - Sim");
				System.out.println("\nSua opcao: ");
				if(scan.nextInt() == 1) {
					System.out.print("Nome: ");
					args[0] = Console.readLine();
				}

				System.out.print("\nDeseja alterar o CPF?"
					+ "\n0 - Nao"
					+ "\n1 - Sim");
				System.out.println("\nSua opcao: ");
				if(scan.nextInt() == 1) {
					System.out.print("CPF: ");
					args[1] = scan.nextLong();
				}
				
				System.out.print("\nDeseja alterar o telefone?"
					+ "\n0 - Nao"
					+ "\n1 - Sim");
				System.out.println("\nSua opcao: ");
				if(scan.nextInt() == 1) {
					System.out.print("Telefone: ");
					args[2] = scan.nextLong();
				}
				
				System.out.print("\nDeseja alterar a idade?"
					+ "\n0 - Nao"
					+ "\n1 - Sim");
				System.out.println("Sua opcao: ");
				if(scan.nextInt() == 1) {
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
			System.out.println("\nSua opcao: ");
			Integer opcao = scan.nextInt();
			
			if(opcao == 1) {
				controlador.remover(hospede);
			}
			
		}
		
	}

	public Entidade busca() {
		System.out.print("\n------BUSCA------"
				+ "\n0 - Cancelar"
				+ "\n1 - Busca por ID"
				+ "\n2 - Busca por CPF");
		System.out.println("\nSua opcao: ");
		Integer opcao = scan.nextInt();
		if(opcao == 0) {
			
			return null;
			
		} else if(opcao == 1) {
			
			System.out.print("Insira o ID: ");
			Integer id = scan.nextInt();
			Hospede hospede = (Hospede)controlador.buscar(id);
			if(hospede == null) {
				System.out.println("Hospede nao encontrado");
				return null;
			}
			System.out.print(hospede.toString());
			return hospede;
			
		} else if (opcao == 2) {
			
			System.out.print("Insira o CPF: ");
			String cpf = Console.readLine();
			Hospede hospede = (Hospede)controlador.buscar(cpf);
			if(hospede == null) {
				System.out.println("Hospede nao encontrado");
				return null;
			}
			System.out.print(hospede.toString());
			return hospede;
			
		} else {
			// opcao invalida
			return null;
		}
	}
}
