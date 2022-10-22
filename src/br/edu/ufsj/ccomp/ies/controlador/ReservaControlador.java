package br.edu.ufsj.ccomp.ies.controlador;

import br.edu.ufsj.ccomp.ies.factory.EntidadeFactory;
import br.edu.ufsj.ccomp.ies.factory.HospedeMenuFactory;
import br.edu.ufsj.ccomp.ies.factory.MenuFactory;
import br.edu.ufsj.ccomp.ies.factory.PersistenciaFactory;
import br.edu.ufsj.ccomp.ies.factory.ReservaFactory;
import br.edu.ufsj.ccomp.ies.factory.ReservaMenuFactory;
import br.edu.ufsj.ccomp.ies.factory.ReservaPersistenciaFactory;
import br.edu.ufsj.ccomp.ies.modelo.Entidade;
import br.edu.ufsj.ccomp.ies.modelo.Hospede;
import br.edu.ufsj.ccomp.ies.modelo.Reserva;
import br.edu.ufsj.ccomp.ies.persistencia.ReservaPersistencia;
import br.edu.ufsj.ccomp.ies.visao.HospedeMenu;
import br.edu.ufsj.ccomp.ies.visao.ReservaMenu;

public class ReservaControlador extends Controlador{

    
    //persistencia (requisitada da fabrica)
    ReservaPersistencia persistencia =
    		((ReservaPersistenciaFactory)PersistenciaFactory.obterPersistenciaFactory("reserva")).obterPersistencia();

    //fabrica de reserva
    ReservaFactory rf =
            (ReservaFactory)EntidadeFactory.obterEntidadeFactory("hospede");
    

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
        Reserva reserva = rf.obterEntidade();

        //criando ID unico
		reserva.setID(contador++);
		//contador++;
		
        //cadastrando reserva
		persistencia.cadastrar(reserva, args);
		
		
		//estabelecendo hospedes da reserva
		ReservaMenu reservaMenu =
				((ReservaMenuFactory)MenuFactory.obterMenuFactory("reserva")).obterMenu();
		HospedeMenu hospedeMenu =
				((HospedeMenuFactory)MenuFactory.obterMenuFactory("hospede")).obterMenu();
		Boolean nenhum = true;
		Integer opcao = 0;
		
		do {

			opcao = reservaMenu.adicaoHospede();

			if(opcao == 1){ //cadastrar hospede e adicionar
				
				Hospede hospede = (Hospede)hospedeMenu.cadastro();
				persistencia.addHospede(reserva, hospede);
				nenhum = false;
				
			} else if(opcao == 2){ //adicionar existente
				
				Hospede hospede = (Hospede)hospedeMenu.busca();
				if(hospede != null) {
					persistencia.addHospede(reserva, hospede);
				}
				nenhum = false;
				
			} else if(opcao != 1 &&
						opcao != 2 &&
						!nenhum) {
				break;
			}else if(nenhum){
				//necessario pelo menos um hospede na reserva
			} 

		} while(nenhum);
		
        //retornando ID
		return reserva;
	}

	public void alterar(Entidade entidade, Object[] args) {
		
		if(args[0] == null || entidade == null) {
			//faltou coisa, tente novamente
			return;
		}
		
		persistencia.alterar(entidade, args);
		
	}

	public void remover(Entidade entidade) {
		
		if(entidade == null) {
			//faltou coisa, tente novamente
			return;
		}
		
		persistencia.remover(entidade);
		
	}

	public Entidade buscaID(Integer ID) {
		
		if(ID == null) {
			//id vazio
			return null;
		}
		
		return persistencia.buscaID(ID);
	}

	public Entidade buscaAtributo(Object numeroQuarto) {
		Integer numero = (Integer)numeroQuarto;
		
		if(numero == null) {
			//numero vazio
			return null;
		}
		
		return persistencia.buscaAtributo(numeroQuarto);
	}

}
