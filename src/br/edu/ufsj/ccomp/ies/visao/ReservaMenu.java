package br.edu.ufsj.ccomp.ies.visao;

import java.util.Scanner;

import br.edu.ufsj.ccomp.ies.controlador.ReservaControlador;
import br.edu.ufsj.ccomp.ies.factory.Factory;
import br.edu.ufsj.ccomp.ies.main.Console;
import br.edu.ufsj.ccomp.ies.modelo.Entidade;
import br.edu.ufsj.ccomp.ies.modelo.Reserva;

public class ReservaMenu extends Menu{
	
	//SINGLETON
	private static ReservaMenu uniqueInstance;
	private ReservaMenu() { }
	public static ReservaMenu getInstance(){
		if(uniqueInstance == null)
			uniqueInstance = new ReservaMenu();
		return uniqueInstance;
	}
	
	private Scanner scan = new Scanner(System.in);
	
	ReservaControlador controlador =
			(ReservaControlador)Factory.obterFactory("reserva").criarControlador();
	
	
	
	public Entidade cadastro() {

		//0:nome - 1: CPF - 2:telefone - 3:idade
		Object[] args = new Object[1];
		args[0] = null;
        
		System.out.print("Numero do quarto: ");
		args[0] = scan.nextInt();
		
		Reserva r = (Reserva)controlador.cadastrar(args);
		if(r == null) {
			System.out.print("\nErro: reserva nao cadastrada.");
			return null;
		}
		System.out.print("\nReserva cadastrada com sucesso!\nID da reserva: " + r.getID());
		return r;
		
	}

	public void alteracao() {
		
		Reserva reserva = (Reserva)busca();
		if(reserva != null) {
			
			System.out.print("\nDeseja alterar a reserva selecionada?"
					+ "\n0 - Nao"
					+ "\n1 - Sim");
			System.out.println("\nSua opcao: ");
			
			Integer opcao = scan.nextInt();
			
			if(opcao == 1) {
				Object[] args = new Object[1];
				args[0] = null;
				System.out.print("\nDeseja alterar o numero do quarto?"
						+ "\n0 - Nao"
						+ "\n1 - Sim");
				System.out.println("\nSua opcao: ");
				if(scan.nextInt() == 1) {
					System.out.print("Novo numero de quarto: ");
					args[0] = scan.nextInt();
				}
					
				controlador.alterar(reserva, args);
			}
			
		}
		
	}

	public void remocao() {
		
		Reserva reserva = (Reserva)busca();
		if(reserva != null) {
			
			System.out.print("\nDeseja remover a reserva selecionada?"
					+ "\n0 - Nao"
					+ "\n1 - Sim");
			System.out.println("\nSua opcao: ");
			Integer opcao = scan.nextInt();
			
			if(opcao == 1) {
				controlador.remover(reserva);
			}
			
		}
		
	}

	public Entidade busca() {
		System.out.print("\n------BUSCA------"
				+ "\n0 - Cancelar"
				+ "\n1 - Busca por ID"
				+ "\n2 - Busca por numero do quarto");
		System.out.println("\nSua opcao: ");
		Integer opcao = scan.nextInt();
		if(opcao == 0) {
			
			return null;
			
		} else if(opcao == 1) {
			
			System.out.print("Insira o ID: ");
			Integer id = scan.nextInt();
			Reserva reserva = (Reserva)controlador.buscar(id);
			System.out.print(reserva.toString());
			return reserva;
			
		} else if (opcao == 2) {
			
			System.out.print("Insira o numero do quarto: ");
			String quarto = Console.readLine();
			Reserva reserva = (Reserva)controlador.buscar(quarto);
			System.out.print(reserva.toString());
			return reserva;
			
		} else {
			// opcao invalida
			return null;
		}
	}
	
	public Integer alteracaoHospedes() {
		Integer x = 0;
		System.out.print("\n\nALTERACAO DE HOSPEDE DA RESERVA"
				+ "\n1 - Adicionar hospede"
				+ "\n2 - Remover hospede"
				+ "\n0 - Nao desejo alterar um hospede");
		System.out.println("\nSua opcao: ");
		x = scan.nextInt();

		if(x == 1){
			return 1;
		} else if (x == 2){
			return 2;
		}
		return 0;
	}

	public Integer adicaoHospede(){
		Integer x = 0;
		System.out.print("\n\nADICIONAR HOSPEDE(S) A RESERVA"
				+ "\nAdicao obrigatoria de pelo menos um hospede"
				+ "\n1 - Cadastrar novo hospede e adicionar"
				+ "\n2 - Adicionar hospede existente"
				+ "\n0 - Finalizar");
		System.out.println("\nSua opcao: ");
		x = scan.nextInt();

		if(x == 1){
			return 1;
		} else if (x == 2){
			return 2;
		}
		return 0;

	}
	
	public Integer remocaoHospede(){
		System.out.print("\n\nREMOVER HOSPEDE DA RESERVA"
				+ "\nInsira o ID do hospede que deseja remover"
				+ "\nSe nao deseja remover um hospede, digite 0\n");
		return scan.nextInt();

	}
}
