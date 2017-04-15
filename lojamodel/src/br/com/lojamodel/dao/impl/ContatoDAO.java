package br.com.lojamodel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import br.com.lojamodel.ConnectionFactory;
import br.com.lojamodel.Contato;
import br.com.lojamodel.dao.DAO;

public class ContatoDAO implements DAO {

	@Override
	public void adicionar(Object object) throws SQLException {

		Connection conn = ConnectionFactory.getConnectionJDBC();

		Contato contato = (Contato) object;

		// conectando
		Connection con = null;
		con = new ConnectionFactory().getConnection();
		// cria um preparedStatement
		String sql = "insert into contatos" + " (nome,email,endereco,dataNascimento)" + " values (?,?,?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		try {

			// preenche os valores
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			// stmt.setDate(4, contato.getDataNascimento().getTime());
			stmt.setDate(4, new java.sql.Date(contato.getDataNascimento().getTimeInMillis()));

			// executa
			System.out.println("Contato gravado!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt.execute();
			stmt.close();
		}
	}

	@Override
	public List<Object> buscarTodos() throws SQLException {

		List<Object> listaDeContatos = null;

		Connection con = new ConnectionFactory().getConnection();
		PreparedStatement stmt = con.prepareStatement("select * from contatos");

		// executa um select
		ResultSet rs = stmt.executeQuery();
		try {
			// itera no ResultSet
			while (rs.next()) {
				if (listaDeContatos == null) {
					listaDeContatos = new ArrayList<Object>();
				}

				Contato novoContato = new Contato();

				novoContato.setNome(rs.getString("nome"));
				novoContato.setEmail(rs.getString("email"));
				novoContato.setId(rs.getLong("id"));

				// montando a data através do Calendar
				Calendar data = new GregorianCalendar();
				data.setTime(rs.getDate("dataNascimento"));
				novoContato.setDataNascimento(data);
				novoContato.setEndereco(rs.getString("endereco"));

				listaDeContatos.add(novoContato);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt.close();
			con.close();

		}

		return listaDeContatos;
	}

	@Override
	public void atualizar(Object object, int a) throws SQLException {

		Contato contato = (Contato) object;
		Connection con = new ConnectionFactory().getConnection();
		PreparedStatement stmt = null;
		Scanner teclado = new Scanner(System.in);
		int c = 0;
		try {

			switch (a) {
			case 1:
				System.out.print("Digite o novo nome:");
				stmt = con.prepareStatement("update contatos set nome = ? where id = ?");
				stmt.setLong(2, contato.getId());
				contato.setNome(teclado.nextLine());
				stmt.setString(1, contato.getNome());
				stmt.execute();
				System.out.println("Contato Alterado Com Sucesso");

				break;
			case 2:
				System.out.print("Digite o novo e-mail:");
				stmt = con.prepareStatement("update contatos set email = ? where id=?");
				stmt.setLong(2, contato.getId());
				contato.setEmail(teclado.nextLine());
				stmt.setString(1, contato.getEmail());
				stmt.execute();
				System.out.println("Contato Alterado Com Sucesso");

				break;
			case 3:
				System.out.print("Digite o novo endereço:");
				stmt = con.prepareStatement("update contatos set endereco = ? where id=?");
				stmt.setLong(2, contato.getId());
				contato.setEndereco(teclado.nextLine());
				stmt.setString(1, contato.getEndereco());
				stmt.execute();
				System.out.println("Contato Alterado Com Sucesso");

				break;
			case 4:

				do {
					String stdata = null;
					try {

						System.out.print("Digite a nova data:");
						stmt = con.prepareStatement("update contatos set dataNascimento = ? where id=?");
						stmt.setLong(2, contato.getId());
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						Scanner teclado1 = new Scanner(System.in);
						stdata = teclado1.nextLine();
						Calendar caldata = new GregorianCalendar();
						caldata.setTime(sdf.parse(stdata));
						contato.setDataNascimento(caldata);

						stmt.setDate(1, new java.sql.Date(contato.getDataNascimento().getTimeInMillis()));

						stmt.execute();
						System.out.println("Contato Alterado Com Sucesso");
					} catch (ParseException e) {
						e.printStackTrace();
						stdata = null;
						System.out.println("Formato de data invalido, digite 'dd/mm/yyyy'");

					}
				} while (contato.getDataNascimento() == null);

				break;
			default:
				c = 1;
				break;

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (c == 0)
				stmt.close();
			con.close();
		}

	}

	@Override
	public void remover(Object object) throws SQLException {
		System.out.println("Deletando...");
		Connection con = new ConnectionFactory().getConnectionJDBC();
		PreparedStatement stmt = con.prepareStatement("delete from contatos");
		try {
			stmt.execute();
			System.out.println("Base de dados vazia");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt.close();
			con.close();
		}

	}

	@Override
	public void removerPorId(Object object) throws SQLException {
		if (buscarPorId(object) == null) {
			System.out.println("Nenhum Contato encontrado");
			return;
		}

		else {
			Connection con = new ConnectionFactory().getConnectionJDBC();
			PreparedStatement stmt = con.prepareStatement("delete from contatos where id=?");
			Contato contato = (Contato) object;
			stmt.setLong(1, contato.getId());

			try {
				stmt.execute();
				System.out.println("Contato deletado");
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				stmt.close();
				con.close();
			}
		}

	}

	@Override
	public List<Object> buscarPorId(Object object) throws SQLException {
		Connection con = new ConnectionFactory().getConnectionJDBC();
		PreparedStatement stmt = con.prepareStatement("select * from contatos where id=?");
		Contato cont = (Contato) object;
		stmt.setLong(1, cont.getId());
		ResultSet rs = null;
		List<Object> listaDeContatos = null;
		try {
			rs = stmt.executeQuery();
			while (rs.next()) {
				if (listaDeContatos == null) {
					listaDeContatos = new ArrayList<Object>();
				}

				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
				listaDeContatos.add(contato);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt.close();
			con.close();
		}
		return listaDeContatos;
	}

	@Override
	public List<Object> buscarPorNome(Object object) throws SQLException {

		Connection con = new ConnectionFactory().getConnectionJDBC();
		PreparedStatement stmt = con
				.prepareStatement("select * from contatos where (lower(nome) like ?) or (upper(nome) like ?)");
		Contato cont = (Contato) object;
		stmt.setString(1, '%' + cont.getNome() + '%');
		stmt.setString(2, '%' + cont.getNome() + '%');
		List<Object> listaDeContatos = null;
		try {
			ResultSet rs = stmt.executeQuery();

			// itera no ResultSet
			while (rs.next()) {
				if (listaDeContatos == null) {
					listaDeContatos = new ArrayList<Object>();
				}
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
				listaDeContatos.add(contato);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt.close();
			con.close();
		}
		return listaDeContatos;
	}

}