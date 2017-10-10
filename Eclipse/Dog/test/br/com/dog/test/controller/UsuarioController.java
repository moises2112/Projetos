package br.com.dog.test.controller;

import java.sql.SQLException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import br.com.dog.model.dao.DAO;
import br.com.dog.model.dao.UsuarioDAO;
import br.com.dog.model.dao.impl.jdbc.UsuarioDao;
import br.com.dog.model.entity.Usuario;

public class UsuarioController {

	public static void processoAddUser() {
		Usuario user = new Usuario();
		Scanner teclado = new Scanner(System.in);
		Scanner teclado1 = new Scanner(System.in);
		System.out.print("Nome:");
		user.setNome(teclado.nextLine());
		System.out.print("Email:");
		user.setEmail(teclado.nextLine());
		System.out.print("Logradouro:");
		user.setLogradouro(teclado.nextLine());
		System.out.print("Numero:");
		user.setNumero(teclado1.nextInt());
		System.out.println("CEP:");
		user.setCep(teclado1.nextInt());
		System.out.println("Bairro:");
		user.setBairro(teclado.nextLine());
		// Capturar data digitada
		String stdata = null;
		do {
			try {
				System.out.print("Data de Nascimento(dd/MM/yyyy):");
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Scanner teclado2 = new Scanner(System.in);
				stdata = teclado2.nextLine();
				Calendar caldata = new GregorianCalendar();
				caldata.setTime(sdf.parse(stdata));
				user.setdataNascimento(caldata);
			} catch (ParseException e) {
				e.printStackTrace();
				stdata = null;
				System.out
						.println("Formato de data invalido, digite 'dd/mm/yyyy'");

			}
		} while (user.getdataNascimento() == null);
		System.out.println("F para Feminino\nM para Masculino");
		user.setSexo(teclado.nextLine().toUpperCase());
		System.out.println("Senha:");
		user.setSenha(teclado.nextLine());
		UsuarioDAO userdao = new UsuarioDao();
		try {
			userdao.create(user);
			System.out.println("Usuario adicionado");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void processoBuscaUsuarios() {

		UsuarioDAO userDAO = new UsuarioDao();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			if (userDAO.readAll() != null)
				try {
					System.out.println("\t\t\t\t\t\t|Usuarios|");
					for (Object usuario : userDAO.readAll()) {
						Usuario user = (Usuario) usuario;
						System.out
								.println("\t\t\tID:"
										+ user.getIdUsuario()
										+ "\tNome:"
										+ user.getNome()
										+ "\tDataNascimento:"
										+ sdf.format(user.getdataNascimento()
												.getTime()) + "\tSexo:"
										+ user.getSexo().toUpperCase()
										+ "\n\t\tLogradouro:"
										+ user.getLogradouro() + "\tNumero:"
										+ user.getNumero() + "\tCep:"
										+ user.getCep() + "\tBairro:"
										+ user.getBairro()
										+ "\n\t\t\t\t\tLogin:"
										+ user.getEmail() + "\tSenha:"
										+ user.getSenha() + "\n\n");
					}
					System.out.println("\n\n\n");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			else {
				System.out.println("Nenhum usuario gravado");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void processoRemoverTodos() {

		UsuarioDAO userdao = new UsuarioDao();
		try {
			userdao.deleteAll();
			System.out.println("Todos usuarios removidos");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void processoAtualizar() {

		UsuarioDAO userdao = new UsuarioDao();

		Usuario user = new Usuario();
		user.setIdUsuario((long) 3);

		try {
			;
			user = userdao.read(user);

			userdao.update(user);
			System.out.println("alterado");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void processoBuscaEspecifica() {

		Usuario user = new Usuario();
		user.setIdUsuario((long) 3);
		UsuarioDAO userdao = new UsuarioDao();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {

			user = userdao.read(user);
			System.out.println("\t\t\tID:" + user.getIdUsuario() + "\tNome:"
					+ user.getNome() + "\tDataNascimento:"
					+ sdf.format(user.getdataNascimento().getTime())
					+ "\tSexo:" + user.getSexo().toUpperCase()
					+ "\n\t\tLogradouro:" + user.getLogradouro() + "\tNumero:"
					+ user.getNumero() + "\tCep:" + user.getCep() + "\tBairro:"
					+ user.getBairro() + "\n\t\t\t\t\tLogin:" + user.getEmail()
					+ "\tSenha:" + user.getSenha() + "\n\n");
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void processoRemover() {

		UsuarioDAO userdao = new UsuarioDao();
		Usuario usuario = new Usuario();
		usuario.setIdUsuario((long) 3);

		try {
			userdao.delete(usuario);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		processoBuscaUsuarios();

	}

}
