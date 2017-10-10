package br.com.dog.model.entity;

public class Match {
	private long idMatch;
	private long requisitante;
	private long requisitado;
	private String start;

	public long getIdMatch() {
		return idMatch;
	}

	public void setIdMatch(long idMatch) {
		this.idMatch = idMatch;
	}

	public long getRequisitante() {
		return requisitante;
	}

	public void setRequisitante(long requisitante) {
		this.requisitante = requisitante;
	}

	public long getRequisitado() {
		return requisitado;
	}

	public void setRequisitado(long requisitado) {
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
		return "Match [idMatch=" + idMatch + ", requisitante=" + requisitante + ", requisitado=" + requisitado
				+ ", start=" + start + "]";
	}

}
