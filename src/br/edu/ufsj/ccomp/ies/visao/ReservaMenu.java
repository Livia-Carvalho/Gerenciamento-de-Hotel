package br.edu.ufsj.ccomp.ies.visao;

import java.util.Scanner;

import br.edu.ufsj.ccomp.ies.controlador.ReservaControlador;
import br.edu.ufsj.ccomp.ies.factory.ControladorFactory;
import br.edu.ufsj.ccomp.ies.factory.ReservaControladorFactory;
import br.edu.ufsj.ccomp.ies.modelo.Entidade;
import br.edu.ufsj.ccomp.ies.modelo.Reserva;

public class ReservaMenu extends Menu{
	
	private Scanner scan = new Scanner(System.in);

	ReservaControladorFactory rcfactory =
			(ReservaControladorFactory)ControladorFactory.obterControladorFactory("reserva");
	ReservaControlador controlador = rcfactory.obterControlador();
	
	
	public Entidade cadastro() {

		//0:nome - 1: CPF - 2:telefone - 3:idade
		Object[] args = new Object[1];
		args[0] = null;
        
		System.out.print("Numero do quarto: ");
		args[0] = scan.next();
		
		Reserva r = (Reserva)controlador.cadastrar(args);
		if(r == null) {
			System.out.print("Erro: reserva nao cadastrada.");
			return null;
		}
		System.out.print("Reserva cadastrada com sucesso!\nID da reserva: " + r.getID());
		return r;
		
	}

	public void sair() {
		scan.close();
	}

	public void alteracao() {
		
		Reserva reserva = (Reserva)busca();
		if(reserva != null) {
			
			System.out.print("\nDeseja alterar a reserva selecionada?"
					+ "\n0 - Nao"
					+ "\n1 - Sim");
			Boolean opcao = scan.nextBoolean();
			
			if(opcao) {
				Object[] args = new Object[1];
			
				System.out.print("Novo numero de quarto: ");
				args[0] = scan.nextInt();
		
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
			Boolean opcao = scan.nextBoolean();
			
			if(opcao) {
				controlador.remover(reserva);
			}
			
		}
		
	}

	public Entidade busca() {
		System.out.print("\n------BUSCA------"
				+ "\n0 - Cancelar"
				+ "\n1 - Busca por ID"
				+ "\n2 - Busca por numero do quarto");
		Integer opcao = scan.nextInt();
		if(opcao == 0) {
			
			return null;
			
		} else if(opcao == 1) {
			
			System.out.print("Insira o ID: ");
			Integer id = scan.nextInt();
			Reserva reserva = (Reserva)controlador.buscaID(id);
			System.out.print(reserva.toString());
			return reserva;
			
		} else if (opcao == 2) {
			
			System.out.print("Insira o numero do quarto: ");
			Integer numero = scan.nextInt();
			Reserva reserva = (Reserva)controlador.buscaAtributo(numero);
			System.out.print(reserva.toString());
			return reserva;
			
		} else {
			// opcao invalida
			return null;
		}
	}

	public Integer adicaoHospede(){
		Integer x = 0;
		//do {
		System.out.print("\n0 - Finalizar cadastro"
				+ "\n1 - Cadastrar novo hospede e adicionar"
				+ "\n2 - Adicionar hospede existente");
		x = scan.nextInt();

		if(x == 1){
			return 1;
		} else if (x == 2){
			return 2;
		}
		return 0;
		//} while(x == 1 || x == 2);

	}
}
