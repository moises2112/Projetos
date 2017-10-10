package br.com.lojamodel.controle;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import br.com.lojamodel.Contato;
import br.com.lojamodel.dao.DAO;
import br.com.lojamodel.dao.impl.ContatoDAO;

public class ContatosControle {

	public static void processoInserirContatos() throws ParseException {

		Contato contato = new Contato();
		Scanner teclado = new Scanner(System.in);
		System.out.print("Nome:");
		contato.setNome(teclado.nextLine());

		System.out.print("Email:");
		contato.setEmail(teclado.nextLine());
		System.out.print("Endereco:");
		contato.setEndereco(teclado.nextLine());
		// Capturar data digitada
		String stdata = null;
		do {
			try {
				System.out.print("Data de Nascimento:");
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Scanner teclado1 = new Scanner(System.in);
				stdata = teclado1.nextLine();
				Calendar caldata = new GregorianCalendar();
				caldata.setTime(sdf.parse(stdata));
				contato.setDataNascimento(caldata);
			} catch (ParseException e) {
				e.printStackTrace();
				stdata = null;
				System.out.println("Formato de data invalido, digite 'dd/mm/yyyy'");

			}
		} while (contato.getDataNascimento() == null);
		DAO contatoDAO = new ContatoDAO();
		try {
			contatoDAO.adicionar(contato);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void processoBuscaContatos() {

		DAO contatoDAO = new ContatoDAO();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			if (contatoDAO.buscarTodos() != null)
				try {
					System.out.println("\t\t|CONTATOS|");
					for (Object contato : contatoDAO.buscarTodos()) {
						Contato cont = (Contato) contato;
						System.out.println("ID:" + cont.getId() + "\tNome:" + cont.getNome() + "\tE-mail:"
								+ cont.getEmail() + "\tEndereço:" + cont.getEndereco() + "\tDataNascimento:"
								+ sdf.format(cont.getDataNascimento().getTime()));
					}
					System.out.println("\n\n\n");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			else {
				System.out.println("Nenhum contato gravado");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void processoDeletarTudo() throws SQLException {
		ContatoDAO contdao = new ContatoDAO();
		contdao.remover(null);

	}

	public static void processoDeletarPorId() throws SQLException {
		Contato cont = new Contato();
		processoBuscaContatos();
		System.out.print("Digite o ID do contato que deseja deletar:\t");
		Scanner teclado = new Scanner(System.in);
		cont.setId(teclado.nextLong());
		ContatoDAO contdao = new ContatoDAO();
		contdao.removerPorId(cont);
	}

	public static void processoBuscarPorId() throws SQLException {

		Contato cont = new Contato();
		System.out.print("Digite o ID para buscar:");
		Scanner teclado = new Scanner(System.in);
		cont.setId(teclado.nextLong());
		ContatoDAO contdao = new ContatoDAO();
		try {
			if (contdao.buscarPorId(cont) != null)
				try {
					for (Object contato : contdao.buscarPorId(cont)) {
						Contato c = (Contato) contato;
						System.out.println(c.toString());
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			else {
				System.out.println("Nenhum contato foi encontrado");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void processoBuscarPorNome() throws SQLException {
		Contato cont = new Contato();
		System.out.print("Digite o nome para buscar:");
		Scanner teclado = new Scanner(System.in);
		cont.setNome(teclado.nextLine());
		ContatoDAO contdao = new ContatoDAO();
		try {
			if (contdao.buscarPorNome(cont) != null)
				try {
					for (Object contato : contdao.buscarPorNome(cont)) {
						Contato c = (Contato) contato;

						System.out.println(c.toString());
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			else {
				System.out.println("Nenhum contato foi encontrado");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void processoAtualizar() {
		processoBuscaContatos();
		System.out.print("Digite o ID do contato que deseja alterar:");
		Scanner teclado1 = new Scanner(System.in);
		Scanner teclado2 = new Scanner(System.in);
		Contato cont = new Contato();
		cont.setId(teclado1.nextLong());
		System.out.println("Digite o numero para alterar opção correspondente\n1 - Nome\n2 - E-mail\n"
				+ "3 - Endereço\n4 - Data de Nascimento\n0 - Voltar");
		String a = teclado2.nextLine();
		ContatoDAO contatodao = new ContatoDAO();
		try {

			if (a.equalsIgnoreCase("0") || a.equalsIgnoreCase("1") || a.equalsIgnoreCase("2") || a.equalsIgnoreCase("3")
					|| a.equalsIgnoreCase("4") || a.equalsIgnoreCase("5")) {
				int b = Integer.parseInt(a);
				contatodao.atualizar(cont, b);
				contatodao.buscarPorId(cont);
			} else
				System.out.println("Opção Invalida");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
