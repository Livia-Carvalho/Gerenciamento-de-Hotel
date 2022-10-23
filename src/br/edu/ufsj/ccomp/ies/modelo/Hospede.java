package br.edu.ufsj.ccomp.ies.modelo;

public class Hospede extends Entidade{

	private String nome;
	private Long CPF;
	private Long telefone;
	private Integer idade;
	private Boolean hospedado = false;
	
	public String toString() {
		return "\n\nID do hospede: " + getID()
				+ "\nNome: " + nome
				+ "\nCPF: " + CPF
				+ "\nTelefone: " + telefone
				+ "\nIdade: " + idade
				+ "\nHospedado: + hospedado";
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getCPF() {
		return CPF;
	}
	public void setCPF(Long cPF) {
		CPF = cPF;
	}
	public Long getTelefone() {
		return telefone;
	}
	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public Boolean getHospedado() {
		return hospedado;
	}
	public void setHospedado(Boolean hospedado) {
		this.hospedado = hospedado;
	}
}
