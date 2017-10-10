package br.com.dog.model.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.sql.Date;
import java.util.GregorianCalendar;

import java.util.List;

import br.com.dog.model.ConnectionFactory.ConnectionFactory;
import br.com.dog.model.dao.UsuarioDAO;
import br.com.dog.model.entity.Usuario;

public class UsuarioDao implements UsuarioDAO {

	@Override
	public void create(Usuario usuario) throws SQLException {

		Connection con = ConnectionFactory.getConnectionJDBC();

		String sql = "insert into Usuario (nome,email,logradouro,numero,cep,bairro,data_nascimento,sexo,senha) values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(sql);

		try {

			// preenche os valores
			pst.setString(1, usuario.getNome());
			pst.setString(2, usuario.getEmail());
			pst.setString(3, usuario.getLogradouro());
			pst.setInt(4, usuario.getNumero());
			pst.setInt(5, usuario.getCep());
			pst.setString(6, usuario.getBairro());
			pst.setDate(7, (java.sql.Date) new Date(usuario.getdataNascimento().getTimeInMillis()));
			pst.setString(8, usuario.getSexo());
			pst.setString(9, usuario.getSenha());
			// executa
			pst.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
			pst.close();
		}

	}

	@Override
	public List<Usuario> readAll() throws SQLException {

		List<Usuario> listaDeUsuario = null;

		Connection con = new ConnectionFactory().getConnectionJDBC();
		PreparedStatement stmt = con.prepareStatement("select * from usuario");

		// executa um select
		ResultSet rs = stmt.executeQuery();
		try {
			// itera no ResultSet
			while (rs.next()) {
				if (listaDeUsuario == null) {
					listaDeUsuario = new ArrayList<Usuario>();
				}

				Usuario novoUsuario = new Usuario();

				novoUsuario.setNome(rs.getString("nome"));
				novoUsuario.setEmail(rs.getString("email"));
				novoUsuario.setIdUsuario(rs.getLong("id_usuario"));

				// montando a data atrav�s do Calendar
				Calendar data = new GregorianCalendar();
				data.setTime(rs.getDate("data_nascimento"));
				novoUsuario.setdataNascimento(data);
				novoUsuario.setLogradouro(rs.getString("Logradouro"));
				novoUsuario.setBairro(rs.getString("bairro"));
				novoUsuario.setSenha(rs.getString("senha"));
				novoUsuario.setSexo(rs.getString("sexo"));
				novoUsuario.setNumero(rs.getInt("numero"));
				novoUsuario.setCep(rs.getInt("cep"));
				listaDeUsuario.add(novoUsuario);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt.close();
			con.close();

		}
		return listaDeUsuario;
	}

	@Override
	public void deleteAll() throws SQLException {

		Connection con = new ConnectionFactory().getConnectionJDBC();
		PreparedStatement stmt = con.prepareStatement("delete from usuario");
		try {
			stmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
			stmt.close();
		}

	}

	@Override
	public void update(Usuario usuario) throws SQLException {
		Connection con = new ConnectionFactory().getConnectionJDBC();

		PreparedStatement stmt = null;
		stmt = con.prepareStatement("update usuario set senha = ?, nome = ?, logradouro = ?, data_nascimento = ?,"
				+ "numero = ?,  cep = ?, bairro = ?, sexo = ?, email = ?  where id_usuario = ? ");

		stmt.setString(1, usuario.getSenha());
		stmt.setString(2, usuario.getNome());
		stmt.setString(3, usuario.getLogradouro());
		stmt.setDate(4, (java.sql.Date) new Date(usuario.getdataNascimento().getTimeInMillis()));
		stmt.setInt(5, usuario.getNumero());
		stmt.setInt(6, usuario.getCep());
		stmt.setString(7, usuario.getBairro());
		stmt.setString(8, usuario.getSexo());
		stmt.setString(9, usuario.getEmail());
		stmt.setLong(10, usuario.getIdUsuario());

		try {
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
			stmt.close();
		}

	}

	@Override
	public Usuario read(Usuario usuario) throws SQLException {
		Connection con = new ConnectionFactory().getConnectionJDBC();
		List<Object> listaDeUsuario = null;

		PreparedStatement stmt = con.prepareStatement("select * from usuario where id_usuario = ?");
		stmt.setLong(1, usuario.getIdUsuario());

		// executa um select
		ResultSet rs = stmt.executeQuery();
		try {
			while (rs.next()) {
				usuario.setNome(rs.getString("nome"));

				usuario.setEmail(rs.getString("email"));
				usuario.setIdUsuario(rs.getLong("id_usuario"));

				// montando a data atrav�s do Calendar
				Calendar data = new GregorianCalendar();
				data.setTime(rs.getDate("data_nascimento"));
				usuario.setdataNascimento(data);
				usuario.setLogradouro(rs.getString("Logradouro"));
				usuario.setBairro(rs.getString("bairro"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setSexo(rs.getString("sexo"));
				usuario.setNumero(rs.getInt("numero"));
				usuario.setCep(rs.getInt("cep"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt.close();
			con.close();

		}
		return usuario;
	}

	@Override
	public void delete(Usuario usuario) throws SQLException {
		Connection con = new ConnectionFactory().getConnectionJDBC();
		PreparedStatement stmt = con.prepareStatement("delete from usuario where id_usuario=?");
		try {
			stmt.setLong(1, usuario.getIdUsuario());
			stmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
			stmt.close();
		}

	}

	@Override
	public Usuario buscarLoginSenha(String senha, String email) throws SQLException {
		Connection con = new ConnectionFactory().getConnectionJDBC();
		PreparedStatement stmt = con.prepareStatement("select * from usuario where senha = ? and email = ?");
		stmt.setString(1, senha);
		stmt.setString(2, email);
		ResultSet rs = stmt.executeQuery();
		Usuario user = null;

		try {
			while (rs.next()) {

				if (user == null) {
					user = new Usuario();
				}
				user.setNome(rs.getString("nome"));

				user.setEmail(rs.getString("email"));
				user.setIdUsuario(rs.getLong("id_usuario"));

				// montando a data atrav�s do Calendar
				Calendar data = new GregorianCalendar();
				data.setTime(rs.getDate("data_nascimento"));
				user.setdataNascimento(data);
				user.setLogradouro(rs.getString("Logradouro"));
				user.setBairro(rs.getString("bairro"));
				user.setSenha(rs.getString("senha"));
				user.setSexo(rs.getString("sexo"));
				user.setNumero(rs.getInt("numero"));
				user.setCep(rs.getInt("cep"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
			stmt.close();
		}
		return user;

	}

	@Override
	public Boolean buscarLogin(String email) throws SQLException {
		Connection con = new ConnectionFactory().getConnectionJDBC();
		PreparedStatement stmt = con.prepareStatement("select * from usuario where email = ?");
		stmt.setString(1, email);
		ResultSet rs = stmt.executeQuery();
		Usuario user = null;
		Boolean exist = null;
		try {
			if (rs.next()) 
				exist = true;
			else
				exist = false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
			stmt.close();
		}
		return exist;

	}

}
