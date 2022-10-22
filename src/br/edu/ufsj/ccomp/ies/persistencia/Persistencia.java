package br.edu.ufsj.ccomp.ies.persistencia;

import br.edu.ufsj.ccomp.ies.modelo.Entidade;

public abstract class Persistencia {

    public abstract void cadastrar(Entidade entidade, Object args[]);
    public abstract void adicionar(Entidade entidade);
    public abstract void alterar(Entidade entidade, Object args[]);
    public abstract void remover(Entidade entidade);
    public abstract Entidade buscaID(Integer ID);
    public abstract Entidade buscaAtributo(Object atributo);
    
}
