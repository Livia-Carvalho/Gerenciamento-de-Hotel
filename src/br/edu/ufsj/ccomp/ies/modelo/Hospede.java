package br.edu.ufsj.ccomp.ies.modelo;

public class Hospede extends Entidade{

	private String nome;
	private Double CPF;
	private Double telefone;
	private Integer idade;
	
	public String toString() {
		return "ID: " + getID()
				+ "Nome: " + nome
				+ "\nCPF: " + CPF
				+ "\nTelefone: " + telefone
				+ "\nIdade: " + idade;
	}


	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getCPF() {
		return CPF;
	}
	public void setCPF(Double cPF) {
		CPF = cPF;
	}
	public Double getTelefone() {
		return telefone;
	}
	public void setTelefone(Double telefone) {
		this.telefone = telefone;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
}
