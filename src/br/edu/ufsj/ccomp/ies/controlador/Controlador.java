package br.edu.ufsj.ccomp.ies.controlador;

import br.edu.ufsj.ccomp.ies.modelo.Entidade;

public abstract class Controlador {

	Integer contador = 1;
	
    public abstract Entidade cadastrar(Object[] args);
    public abstract void alterar(Entidade entidade, Object[] args);
    public abstract void remover(Entidade entidade);
    public abstract Entidade buscar(Integer ID);
    public abstract Entidade buscar(String atributo);

}
