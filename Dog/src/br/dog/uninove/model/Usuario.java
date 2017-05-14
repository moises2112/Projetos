package br.dog.uninove.model;

import java.util.Calendar;

public class Usuario {
	private Long idUsuario;
	private String nome;
	private String email;
	private String logradouro;
	private int numero;
	private int cep;
	private String bairo;
	private Calendar dataNascimento;
	private String sexo;
	private String senha;

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long id_usuario) {
		this.idUsuario = id_usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public String getBairo() {
		return bairo;
	}

	public void setBairo(String bairo) {
		this.bairo = bairo;
	}

	public Calendar getdataNascimento() {
		return dataNascimento;
	}

	public void setdataNascimento(Calendar data_nascimento) {
		this.dataNascimento = data_nascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Usuario [IdUsuario=" + idUsuario + ", nome=" + nome + ", email=" + email + ", logradouro=" + logradouro
				+ ", numero=" + numero + ", cep=" + cep + ", bairo=" + bairo + ", data_nascimento=" + dataNascimento
				+ ", sexo=" + sexo + ", senha=" + senha + "]";
	}

}
