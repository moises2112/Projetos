package br.com.dog.model.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.dog.model.ConnectionFactory.ConnectionFactory;
import br.com.dog.model.dao.CachorroDAO;
import br.com.dog.model.dao.DAO;
import br.com.dog.model.entity.Cachorro;
import br.com.dog.model.entity.Usuario;

public class CachorroDao implements CachorroDAO {

	@Override
	public void create(Cachorro cachorro) throws SQLException {

		Connection con = ConnectionFactory.getConnectionJDBC();

		String sql = "insert into Cachorro (nome, ra�a, idade, sexo, id_usuario) values(?,?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(sql);

		try {

			// preenche os valores
			pst.setString(1, cachorro.getNome());
			pst.setString(2, cachorro.getRaca());
			pst.setInt(3, cachorro.getIdade());
			pst.setString(4, cachorro.getSexo());
			pst.setLong(5, cachorro.getIdUsuario());

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
	public List<Cachorro> readAll() throws SQLException {

		List<Cachorro> listaDeCachorro = null;

		Connection con = new ConnectionFactory().getConnectionJDBC();
		PreparedStatement stmt = con.prepareStatement("select * from cachorro");

		// executa um select
		ResultSet rs = stmt.executeQuery();
		try {
			// itera no ResultSet
			while (rs.next()) {
				if (listaDeCachorro == null) {
					listaDeCachorro = new ArrayList<Cachorro>();
				}

				Cachorro novoCachorro = new Cachorro();

				novoCachorro.setNome(rs.getString("nome"));
				novoCachorro.setRaca(rs.getString("ra�a"));
				novoCachorro.setIdade(rs.getInt("idade"));
				novoCachorro.setSexo(rs.getString("sexo"));
				novoCachorro.setIdCachorro(rs.getLong("id_cachorro"));
				novoCachorro.setIdUsuario(rs.getLong("id_usuario"));

				listaDeCachorro.add(novoCachorro);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt.close();
			con.close();

		}
		return listaDeCachorro;

	}

	@Override
	public void deleteAll() throws SQLException {
		Connection con = new ConnectionFactory().getConnectionJDBC();
		PreparedStatement stmt = con.prepareStatement("delete from cachorro");
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
	public void update(Cachorro cachorro) throws SQLException {
		Connection con = new ConnectionFactory().getConnectionJDBC();
		PreparedStatement pst = null;
		pst = con.prepareStatement(
				"update cachorro set nome = ?,ra�a = ?, idade = ?, sexo = ?," + "id_usuario = ? where id_usuario = ? ");

		pst.setString(1, cachorro.getNome());
		pst.setString(2, cachorro.getRaca());
		pst.setInt(3, cachorro.getIdade());
		pst.setString(4, cachorro.getSexo());
		pst.setLong(5, cachorro.getIdUsuario());
		pst.setLong(6, cachorro.getIdCachorro());

		try {
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
			pst.close();
		}

	}

	// Testar codigo abaixo
	@Override
	public Cachorro read(Cachorro cachorro) throws SQLException {

		Connection con = new ConnectionFactory().getConnectionJDBC();
		List<Object> listaDeCachorro = null;

		PreparedStatement stmt = con.prepareStatement("select * from cachorro where id_cachorro = ?");
		stmt.setLong(1, cachorro.getIdCachorro());

		// executa um select
		ResultSet rs = stmt.executeQuery();
		try {
			while (rs.next()) {

				cachorro.setNome(rs.getString("nome"));
				cachorro.setRaca(rs.getString("ra�a"));
				cachorro.setSexo(rs.getString("sexo"));
				cachorro.setIdade(rs.getInt("idade"));
				cachorro.setIdCachorro(rs.getLong("id_cachorro"));
				cachorro.setIdUsuario(rs.getLong("id_usuario"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt.close();
			con.close();

		}
		return cachorro;

	}

	@Override
	public void delete(Cachorro cachorro) throws SQLException {
		Connection con = new ConnectionFactory().getConnectionJDBC();
		PreparedStatement stmt = con.prepareStatement("delete from cachorro where id_cachorro=?");
		try {
			stmt.setLong(1, cachorro.getIdCachorro());
			stmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
			stmt.close();
		}

	}

	@Override
	public List<Cachorro> buscaPorUsuario(Usuario usuario) throws SQLException {
		List<Cachorro> listaDeCachorro = null;

		Connection con = new ConnectionFactory().getConnectionJDBC();
		PreparedStatement stmt = con.prepareStatement("select * from cachorro where id_usuario =?");
		stmt.setLong(1, usuario.getIdUsuario());
		// executa um select
		ResultSet rs = stmt.executeQuery();
		try {
			// itera no ResultSet
			while (rs.next()) {
				if (listaDeCachorro == null) {
					listaDeCachorro = new ArrayList<Cachorro>();
				}

				Cachorro novoCachorro = new Cachorro();

				novoCachorro.setNome(rs.getString("nome"));
				novoCachorro.setRaca(rs.getString("ra�a"));
				novoCachorro.setIdade(rs.getInt("idade"));
				novoCachorro.setSexo(rs.getString("sexo"));
				novoCachorro.setIdCachorro(rs.getLong("id_cachorro"));
				novoCachorro.setIdUsuario(rs.getLong("id_usuario"));

				listaDeCachorro.add(novoCachorro);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt.close();
			con.close();

		}
		return listaDeCachorro;

	}
}
