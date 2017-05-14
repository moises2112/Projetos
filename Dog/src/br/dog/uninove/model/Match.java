package br.dog.uninove.model;

public class Match {
	private int idMatch;
	private int requisitante;
	private int requisitado;
	private String start;
	
	public int getIdMatch() {
		return idMatch;
	}
	public void setIdMatch(int idMatch) {
		this.idMatch = idMatch;
	}
	public int getRequisitante() {
		return requisitante;
	}
	public void setRequisitante(int requisitante) {
		this.requisitante = requisitante;
	}
	public int getRequisitado() {
		return requisitado;
	}
	public void setRequisitado(int requisitado) {
		this.requisitado = requisitado;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	@Override
	public String toString() {
		return "Match [idMatch=" + idMatch + ", requisitante=" + requisitante
				+ ", requisitado=" + requisitado + ", start=" + start + "]";
	}
	

}
