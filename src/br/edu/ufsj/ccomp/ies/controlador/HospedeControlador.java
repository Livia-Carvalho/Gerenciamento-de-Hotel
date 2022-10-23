package br.edu.ufsj.ccomp.ies.controlador;

import br.edu.ufsj.ccomp.ies.factory.Factory;
import br.edu.ufsj.ccomp.ies.modelo.Entidade;
import br.edu.ufsj.ccomp.ies.modelo.Hospede;
import br.edu.ufsj.ccomp.ies.persistencia.HospedePersistencia;

public class HospedeControlador extends Controlador {

    
    //persistencia (requisitada da fabrica)
    HospedePersistencia persistencia =
    		(HospedePersistencia)Factory.obterFactory("hospede").criarPersistencia();
	
    
	//SINGLETON
	private static HospedeControlador uniqueInstance;
	private HospedeControlador() { }
	public static HospedeControlador getInstance(){
		if(uniqueInstance == null)
			uniqueInstance = new HospedeControlador();
		return uniqueInstance;
	}
    

	public Hospede cadastrar(Object[] args) {
		//0:nome - 1: CPF - 2:telefone - 3:idade
		if(args[0] == null
			|| args[1] == null
			|| args[2] == null) {
			//faltou coisa, tente novamente
			return null;
		}

		//criando objeto hospede
        Hospede hospede = (Hospede)Factory.obterFactory("hospede").criarEntidade();

        //criando ID unico
		hospede.setID(contador++);
		
        //cadastrando hospede
		persistencia.cadastrar(hospede, args);
		
        //retornando ID
		return hospede;
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

	public Entidade buscar(Integer ID) {
		
		if(ID == null) {
			//id vazio
			return null;
		}
		
		return persistencia.buscar(ID);
	}

	public Entidade buscar(String CPF) {
		String cpf = (String)CPF;
		
		if(cpf == null) {
			//cpf vazio
			return null;
		}
		Hospede h = persistencia.buscar(cpf);
		if(h == null) {
			//nao foi possivel tal tal tal
			return null;
		}
		return h;
	}
    
}
