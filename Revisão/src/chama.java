import java.sql.SQLException;
import java.util.Scanner;

import br.revisao.uninove.dao.PessoaDAO;
import br.revisao.uninove.model.Pessoa;

public class chama {
	public static void main(String[] args) {
		System.out.println("Olá, digite seu nome:");
		Scanner teclado1 = new Scanner(System.in);
		Pessoa pessoaUm = new Pessoa();
		pessoaUm.setNome(teclado1.nextLine());
		System.out.println("Digite seu id:");
		pessoaUm.setId(teclado1.nextLong());
		PessoaDAO pessoaDAO = new PessoaDAO();
		try {
			pessoaDAO.adicionar(pessoaUm);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
