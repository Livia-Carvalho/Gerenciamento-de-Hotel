package br.edu.ufsj.ccomp.ies.persistencia;

import java.util.ArrayList;
import java.util.List;
import br.edu.ufsj.ccomp.ies.modelo.Entidade;
import br.edu.ufsj.ccomp.ies.modelo.Hospede;

public class HospedePersistencia extends Persistencia{

	List<Hospede> hospedes = new ArrayList<Hospede>();
	
	//SINGLETON
	private static HospedePersistencia uniqueInstance;
	private HospedePersistencia() { }
	public static HospedePersistencia getInstance(){
		if(uniqueInstance == null)
			uniqueInstance = new HospedePersistencia();
		return uniqueInstance;
	}

			
	public void cadastrar(Entidade hospede, Object args[]) {
		Hospede h = (Hospede)hospede;
		
		h.setNome((String)args[0]);
		h.setCPF((Long)args[1]);
		h.setTelefone((Long)args[2]);
		h.setIdade((Integer)args[3]);
		
		adicionar(h);
	}

	public void adicionar(Entidade hospede) {
		Hospede h = (Hospede)hospede;
		if(hospedes.contains(h)) {
			//hospede ja cadastrado
			return;
		}
		for(Hospede hos : hospedes) {
			if(hos.getCPF().equals(h.getCPF())) {
				//cpf ja cadastrado
				return;
			}
		}
		hospedes.add(h);
	}

	public void alterar(Entidade hospede, Object args[]) {
		Hospede h = (Hospede)hospede;
		
		if(args[0] != null) 
			h.setNome((String)args[0]);
		if(args[1] != null)
			h.setCPF((Long)args[1]);
		if(args[2] != null)
			h.setTelefone((Long)args[2]);
		if(args[3] != null)
			h.setIdade((Integer)args[3]);
		
	}

	public void remover(Entidade hospede) {
		Hospede h = (Hospede)hospede;

		if(hospedes.contains(h)) {
			hospedes.remove(h);
		}
	}

	public Hospede buscar(Integer ID) {
		for(Hospede hospede : hospedes) {
			if(hospede.getID().equals(ID)){
				return hospede;
			}
		}
		return null;
	}

	public Hospede buscar(String CPF) {
		Long cpf = Long.parseLong(CPF);
		for(Hospede hospede : hospedes) {
			if(hospede.getCPF().equals(cpf)){
				return hospede;
			}
		}
		return null;
	}
		
}