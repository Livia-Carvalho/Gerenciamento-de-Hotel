package br.edu.ufsj.ccomp.ies.factory;

import br.edu.ufsj.ccomp.ies.persistencia.Persistencia;

public abstract class PersistenciaFactory {

    public static PersistenciaFactory obterPersistenciaFactory(String persistencia) {
		
		if(persistencia.equalsIgnoreCase("hospede")) {
			
			return new HospedePersistenciaFactory();
			
		} else if(persistencia.equalsIgnoreCase("reserva")) {
			
			return new ReservaPersistenciaFactory();
			
		}
		return null;
	}

	public abstract Persistencia obterPersistencia();

}
