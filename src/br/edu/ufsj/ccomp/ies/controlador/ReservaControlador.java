package br.edu.ufsj.ccomp.ies.controlador;

import br.edu.ufsj.ccomp.ies.factory.Factory;
import br.edu.ufsj.ccomp.ies.modelo.Entidade;
import br.edu.ufsj.ccomp.ies.modelo.Hospede;
import br.edu.ufsj.ccomp.ies.modelo.Reserva;
import br.edu.ufsj.ccomp.ies.persistencia.ReservaPersistencia;
import br.edu.ufsj.ccomp.ies.visao.HospedeMenu;
import br.edu.ufsj.ccomp.ies.visao.ReservaMenu;

public class ReservaControlador extends Controlador{

    
    //persistencia (requisitada da fabrica)
	ReservaPersistencia persistencia =
    		(ReservaPersistencia)Factory.obterFactory("reserva").criarPersistencia();
	
    
	//SINGLETON
	private static ReservaControlador uniqueInstance;
	private ReservaControlador() { }
	public static ReservaControlador getInstance(){
		if(uniqueInstance == null)
			uniqueInstance = new ReservaControlador();
		return uniqueInstance;
	}

	public Entidade cadastrar(Object[] args) {
		//0:numeroQuarto
		if(args[0] == null) {
			//faltou coisa, tente novamente
			return null;
		}
		
		//criando objeto reserva
        Reserva reserva = (Reserva)Factory.obterFactory("reserva").criarEntidade();

        //criando ID unico
		reserva.setID(contador++);
		
        //cadastrando reserva
		persistencia.cadastrar(reserva, args);
		
		
		//estabelecendo hospedes da reserva
		HospedeMenu hospedeMenu = (HospedeMenu)Factory.obterFactory("hospede").criarMenu();
		ReservaMenu reservaMenu = (ReservaMenu)Factory.obterFactory("reserva").criarMenu();		
		Boolean vazio = true;
		Integer opcao = 0;
		
		do {

			opcao = reservaMenu.adicaoHospede();

			if(opcao == 1){ //cadastrar hospede e adicionar
				
				Hospede hospede = (Hospede)hospedeMenu.cadastro();
				persistencia.addHospede(reserva, hospede);
				vazio = false;
				
			} else if(opcao == 2){ //adicionar existente
				
				Hospede hospede = (Hospede)hospedeMenu.busca();
				if(hospede != null) {
					persistencia.addHospede(reserva, hospede);
				}
				vazio = false;
				
			} else if(opcao < 0 || opcao > 2) {
				//opcao invalida
			} else if(vazio){
				//necessario pelo menos um hospede na reserva
			} 

		} while(vazio || opcao != 0);
		
        //retornando ID
		return reserva;
	}

	public void alterar(Entidade reserva, Object[] args) {
		
		if(reserva == null) {
			//faltou coisa, tente novamente
			return;
		}
		if(args[0] != null) persistencia.alterar(reserva, args);
			
		
		//alterar hospedes da reserva
		HospedeMenu hospedeMenu = (HospedeMenu)Factory.obterFactory("hospede").criarMenu();
		ReservaMenu reservaMenu = (ReservaMenu)Factory.obterFactory("reserva").criarMenu();	
		
		Integer opcao = 0;
		
		do {

			opcao = reservaMenu.alteracaoHospedes();
			
			if(opcao == 0) break;
			else if(opcao < 0 || opcao > 2) {
				//opcao invalida
				continue;
			}
			
			Hospede hospede = (Hospede)hospedeMenu.busca();
			
			if(opcao == 1){ //adicionar hospede a reserva
				
				if(hospede != null) {
					persistencia.addHospede((Reserva)reserva, hospede);
				}
				
			} else if(opcao == 2){ // remover hospede da reserva
				
				if(hospede != null) {
					persistencia.removerHospede((Reserva)reserva, hospede);
				}
			} 

		} while(opcao != 0);
				
	}

	public void remover(Entidade reserva) {
		
		if(reserva == null) {
			//faltou coisa, tente novamente
			return;
		}
		
		persistencia.remover((Reserva)reserva);
		
	}

	public Entidade buscar(Integer ID) {
		
		if(ID == null) {
			//id vazio
			return null;
		}
		
		return persistencia.buscar(ID);
	}

	public Entidade buscar(String numeroQuarto) {
		String quarto = (String)numeroQuarto;
		
		if(quarto == null) {
			//numero vazio
			return null;
		}
		
		return persistencia.buscar(numeroQuarto);
	}

}
