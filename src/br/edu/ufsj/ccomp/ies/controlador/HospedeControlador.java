package br.edu.ufsj.ccomp.ies.controlador;

import br.edu.ufsj.ccomp.ies.factory.EntidadeFactory;
import br.edu.ufsj.ccomp.ies.factory.HospedeFactory;
import br.edu.ufsj.ccomp.ies.factory.HospedePersistenciaFactory;
import br.edu.ufsj.ccomp.ies.factory.PersistenciaFactory;
import br.edu.ufsj.ccomp.ies.modelo.Entidade;
import br.edu.ufsj.ccomp.ies.modelo.Hospede;
import br.edu.ufsj.ccomp.ies.persistencia.HospedePersistencia;

public class HospedeControlador extends Controlador {

    
    //persistencia (requisitada da fabrica)
    HospedePersistencia persistencia =
    		((HospedePersistenciaFactory)PersistenciaFactory.obterPersistenciaFactory("hospede")).obterPersistencia();

    //fabrica de hospede
    HospedeFactory hf =
            (HospedeFactory)EntidadeFactory.obterEntidadeFactory("hospede");
    

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
        Hospede hospede = hf.obterEntidade();

        //criando ID unico
		hospede.setID(contador++);
		//contador++;
		
        //cadastrando hospede
		persistencia.cadastrar(hospede, args);
		
        //retornando ID
		return hospede;
	}

	public void alterar(Entidade entidade, Object[] args) {
		
		
	}

	public void remover(Entidade entidade) {
		
		
	}

	public Entidade buscaID(Integer ID) {
		
		if(ID == null) {
			//id vazio
			return null;
		}
		
		return persistencia.buscaID(ID);
	}

	public Entidade buscaAtributo(Object CPF) {
		Double cpf = (Double)CPF;
		
		if(cpf == null) {
			//cpf vazio
			return null;
		}
		
		return persistencia.buscaAtributo(cpf);
	}
    
}
