package br.revisao.uninove.model;

public class Pessoa {

	public String nome;
	public Long id;
	
	
	
	public static String getTudo() {
		return "nome:moises";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String abc) {
		this.nome = abc;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
