package br.edu.ufsj.ccomp.ies.persistencia;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import br.edu.ufsj.ccomp.ies.modelo.Entidade;
import br.edu.ufsj.ccomp.ies.modelo.Hospede;

public class HospedePersistencia extends Persistencia{

	List<Hospede> hospedes = new ArrayList<Hospede>();
	
	private static final HospedePersistencia uniqueInstance = new HospedePersistencia();
	private HospedePersistencia() { }
	public static HospedePersistencia getInstance(){
		return uniqueInstance;
	}

			
	public void cadastrar(Entidade hospede, Object args[]) {
		Hospede h = (Hospede)hospede;
		
		h.setNome((String)args[0]);
		h.setCPF((Double)args[1]);
		h.setTelefone((Double)args[2]);
		h.setIdade((Integer)args[3]);
		
	}

	public void adicionar(Entidade hospede) {
		Hospede h = (Hospede)hospede;
		
		if(!hospedes.contains(h)) {
			hospedes.add(h);
		}
	}

	public void alterar(Entidade hospede, Object args[]) {
		Hospede h = (Hospede)hospede;
		
		if(args[0] != null) 
			h.setNome((String)args[0]);
		if(args[1] != null)
			h.setCPF((Double)args[1]);
		if(args[2] != null)
			h.setTelefone((Double)args[2]);
		if(args[3] != null)
			h.setIdade((Integer)args[3]);
		
	}

	public void remover(Entidade hospede) {
		Hospede h = (Hospede)hospede;

		if(!hospedes.contains(h)) {
			hospedes.remove(h);
		}
	}

	public Hospede buscar(Integer ID) {
		for(Hospede hospede : hospedes) {
			if(hospede.getID() == ID){
				return hospede;
			}
		}
		return null;
	}

	public Hospede buscar(String nome) {
		for(Hospede hospede : hospedes) {
			if(Objects.equals(hospede.getNome(), nome)){
				return hospede;
			}
		}
		return null;
	}
		
}