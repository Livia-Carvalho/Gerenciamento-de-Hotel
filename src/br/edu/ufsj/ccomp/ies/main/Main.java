package br.edu.ufsj.ccomp.ies.main;

import br.edu.ufsj.ccomp.ies.factory.EntidadeFactory;
import br.edu.ufsj.ccomp.ies.modelo.Entidade;

public class Main {
	
	public static void main(String args[]){
		
		EntidadeFactory fabricaHospede = EntidadeFactory.obterEntidadeFactory("hospede");
		Entidade hospede = fabricaHospede.obterEntidade();
		
		//System.out.println("aaa");
		System.out.print(hospede);
		
		/*
		Modelo modelo = new Modelo();
    	Controller controller = new Controller(modelo);
    	Visao visao = new Visao(controller);
    	modelo.addObserver(visao);
    	visao.rodar();
		 */
		
	}
}
