package br.com.lojamodel;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

import br.com.lojamodel.controle.ContatosControle;

public class RunApplication {

	public static void main(String[] args) throws ParseException, SQLException {
		String str = null;
		System.out.println("Hello!");
		Scanner teclado = new Scanner(System.in);
		do {
			System.out.print("\n1 - Novo Contato\n2 - Mostrar todos os contatos\n3 - Busca por ID do contato\n"
					+ "4 - Busca por nome do contato\n5 - Excluir todos os contatos\n6 - Excluir contato por ID\n"
					+ "7 - Alterar Contato\n0 - Finalizar\nDigite um numero para escolher a opção desejada:\t");

			str = teclado.nextLine();
			switch (str) {
			case "1":
				ContatosControle.processoInserirContatos();
				break;
			case "2":
				ContatosControle.processoBuscaContatos();
				break;
			case "3":
				ContatosControle.processoBuscarPorId();
				break;
			case "4":
				ContatosControle.processoBuscarPorNome();
				break;
			case "5":
				ContatosControle.processoDeletarTudo();
				break;
			case "6":
				ContatosControle.processoDeletarPorId();
				break;
			case "7":
				ContatosControle.processoAtualizar();
				break;
			case "0":
				Connection con = ConnectionFactory.getConnectionJDBC();
				con.close();
				System.out.println("Finalizado");
				break;
			default:
				System.out.println("!Opção Invalida!");
				break;
			}
		} while (!str.equalsIgnoreCase("0"));
	}
}
