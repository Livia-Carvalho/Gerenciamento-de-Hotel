package br.edu.ufsj.ccomp.ies.factory;

import br.edu.ufsj.ccomp.ies.persistencia.ReservaPersistencia;

public class ReservaPersistenciaFactory extends PersistenciaFactory {

    public ReservaPersistencia obterPersistencia() {
		
		return ReservaPersistencia.getInstance();
		
	}
}
