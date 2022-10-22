package br.edu.ufsj.ccomp.ies.factory;

import br.edu.ufsj.ccomp.ies.persistencia.HospedePersistencia;

public class HospedePersistenciaFactory extends PersistenciaFactory {
  
    public HospedePersistencia obterPersistencia() {
		
		return HospedePersistencia.getInstance();		
	}
}
