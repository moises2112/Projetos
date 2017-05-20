package br.com.dog.model.entity;

public class Cachorro {
	private int idCachorro;
	private int idUsuario;
	private String raca;
    private String sexo;
    private String nome;
    private int idade;
    
	public int getIdCachorro() {
		return idCachorro;
	}
	public void setIdCachorro(int idCachorro) {
		this.idCachorro = idCachorro;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	@Override
	public String toString() {
		return "Cachorro [idCachorro=" + idCachorro + ", idUsuario="
				+ idUsuario + ", raca=" + raca + ", sexo=" + sexo + ", nome="
				+ nome + ", idade=" + idade + "]";
	}
    

}
