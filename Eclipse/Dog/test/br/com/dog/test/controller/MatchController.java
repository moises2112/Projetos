package br.com.dog.test.controller;

import java.sql.SQLException;

import br.com.dog.model.dao.CachorroDAO;
import br.com.dog.model.dao.MatchDAO;
import br.com.dog.model.dao.impl.jdbc.CachorroDao;
import br.com.dog.model.dao.impl.jdbc.MatchDao;
import br.com.dog.model.entity.Cachorro;
import br.com.dog.model.entity.Match;

public class MatchController {

	public static void processoAddMatch() {
		Match match = new Match();
		match.setRequisitado(1);
		match.setRequisitante(1);
		match.setStart("V");
		MatchDAO matchDAO = new MatchDao();
		try {
			matchDAO.create(match);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void processoBuscaTodos() {

		MatchDAO matchDAO = new MatchDao();
		try {
			if (matchDAO.readAll() != null)
				try {
					System.out.println("\t\t\t\t|Match|");
					for (Object mat : matchDAO.readAll()) {
						Match match = (Match) mat;
						System.out.println("\t\tID Match:" + match.getIdMatch() + "\tID Requisitante:"
								+ match.getRequisitante() + "\tID Requisitado:" + match.getRequisitado() + "\tStart:"
								+ match.getStart() + "\n\n");
					}
					System.out.println("\n\n\n");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			else {
				System.out.println("Nenhum match gravado");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void processoRemoverTodos() {
		MatchDAO matchDAO = new MatchDao();
		try {
			matchDAO.deleteAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void processoRemover() {

		MatchDAO matchDAO = new MatchDao();
		Match match = new Match();
		match.setIdMatch((long) 3);

		try {
			matchDAO.delete(match);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void processoAtualizar() {

		MatchDAO matchDAO = new MatchDao();
		Match mat = new Match();

		mat.setIdMatch((long) 6);
		try {
			Match match = matchDAO.read(mat);
			match.setRequisitado(3);
			match.setRequisitante(4);
			match.setStart("F");

			matchDAO.update(match);

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public static void processoBuscaEspecifica() {
		Match match = new Match();
		match.setIdMatch((long) 4);
		MatchDAO matchDAO = new MatchDao();

		try {

			match = matchDAO.read(match);

			System.out.println("\t\tID Match:" + match.getIdMatch() + "\tID Requisitante:" + match.getRequisitante()
					+ "\tID Requisitado:" + match.getRequisitado() + "\tStart:" + match.getStart() + "\n\n");

		}

		catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		processoBuscaTodos();
		processoAtualizar();
		processoBuscaTodos();

	}

}
