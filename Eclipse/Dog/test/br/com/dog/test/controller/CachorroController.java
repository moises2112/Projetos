package br.com.dog.test.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import br.com.dog.model.dao.CachorroDAO;
import br.com.dog.model.dao.UsuarioDAO;
import br.com.dog.model.dao.impl.jdbc.CachorroDao;
import br.com.dog.model.dao.impl.jdbc.UsuarioDao;
import br.com.dog.model.entity.Cachorro;
import br.com.dog.model.entity.Usuario;

public class CachorroController {

	public static void processoAddCachorro() {

		Cachorro cachorro = new Cachorro();
		cachorro.setIdade(3);
		cachorro.setNome("chorao");
		cachorro.setRaca("poddle");
		cachorro.setSexo("M");
		cachorro.setIdUsuario((long) 2);
		CachorroDAO dogDAO = new CachorroDao();
		try {
			dogDAO.create(cachorro);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void processoBuscarTodos() {

		CachorroDAO dogDAO = new CachorroDao();
		try {
			if (dogDAO.readAll() != null)
				try {
					System.out.println("\t\t\t\t|Cachorros|");
					for (Object cachorro : dogDAO.readAll()) {
						Cachorro dog = (Cachorro) cachorro;
						System.out.println("\t\ttID DONO:" + dog.getIdUsuario() + "\tID:" + dog.getIdCachorro()
								+ "\tNome:" + dog.getNome() + "\tRa�a:" + dog.getRaca() + "\tIdade:" + dog.getIdade()
								+ "\t Sexo:" + dog.getSexo().toUpperCase() + "\n\n");
					}
					System.out.println("\n\n\n");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			else {
				System.out.println("Nenhum cachorro gravado");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void removerTodos() {

		CachorroDAO dogDAO = new CachorroDao();
		try {
			dogDAO.deleteAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void processoAtualizar() {

		CachorroDAO dogDAO = new CachorroDao();
		Cachorro cachorro = new Cachorro();

		cachorro.setIdCachorro((long) 2);
		try {
			Cachorro dog = dogDAO.read(cachorro);
			dog.setIdade(2);
			dog.setNome("white");
			dog.setRaca("yorkshine");
			dog.setSexo("F");
			dog.setIdUsuario((long) 4);

			dogDAO.update(dog);

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public static void processoBuscaEspecifica() {

		Cachorro dog = new Cachorro();
		dog.setIdCachorro((long) 1);
		CachorroDAO dogDAO = new CachorroDao();

		try {

			dog = dogDAO.read(dog);

			System.out.println("\t\ttID DONO:" + dog.getIdUsuario() + "\tID:" + dog.getIdCachorro() + "\tNome:"
					+ dog.getNome() + "\tRa�a:" + dog.getRaca() + "\tIdade:" + dog.getIdade() + "\t Sexo:"
					+ dog.getSexo().toUpperCase() + "\n\n");
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void processoRemover() {

		CachorroDAO dogDAO = new CachorroDao();
		Cachorro cachorro = new Cachorro();
		cachorro.setIdCachorro((long) 2);

		try {
			dogDAO.delete(cachorro);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		processoBuscarTodos();

	}

}
