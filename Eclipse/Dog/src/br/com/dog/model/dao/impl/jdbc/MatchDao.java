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
import br.com.dog.model.dao.MatchDAO;
import br.com.dog.model.entity.Cachorro;
import br.com.dog.model.entity.Match;
import br.com.dog.model.entity.Usuario;

public class MatchDao implements MatchDAO {

	@Override
	public void create(Match match) throws SQLException {
		Connection con = ConnectionFactory.getConnectionJDBC();

		String sql = "insert into match (requisitante, requisitado, start) values(?,?,?)";
		PreparedStatement pst = con.prepareStatement(sql);

		try {

			// preenche os valores
			pst.setLong(1, match.getRequisitante());
			pst.setLong(2, match.getRequisitado());
			pst.setString(3, match.getStart());

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
	public List<Match> readAll() throws SQLException {
		List<Match> listaDeMatch = null;

		Connection con = new ConnectionFactory().getConnectionJDBC();
		PreparedStatement stmt = con.prepareStatement("select * from match");

		// executa um select
		ResultSet rs = stmt.executeQuery();
		try {
			// itera no ResultSet
			while (rs.next()) {
				if (listaDeMatch == null) {
					listaDeMatch = new ArrayList<Match>();
				}

				Match novoMatch = new Match();

				novoMatch.setRequisitante(rs.getLong("requisitante"));
				novoMatch.setRequisitado(rs.getLong("requisitado"));
				novoMatch.setStart(rs.getString("start"));
				novoMatch.setIdMatch(rs.getLong("id_match"));

				listaDeMatch.add(novoMatch);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt.close();
			con.close();

		}
		return listaDeMatch;

	}

	@Override
	public void deleteAll() throws SQLException {
		Connection con = new ConnectionFactory().getConnectionJDBC();
		PreparedStatement stmt = con.prepareStatement("delete from match");
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
	public void update(Match match) throws SQLException {
		Connection con = new ConnectionFactory().getConnectionJDBC();

		PreparedStatement stmt = null;
		stmt = con
				.prepareStatement("update match set requisitante = ?, requisitado = ?, start = ? where id_match = ? ");

		stmt.setLong(1, match.getRequisitante());
		stmt.setLong(2, match.getRequisitado());
		stmt.setString(3, match.getStart());
		stmt.setLong(4, match.getIdMatch());

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
	public Match read(Match match) throws SQLException {
		Connection con = new ConnectionFactory().getConnectionJDBC();
		List<Object> listaDeUsuario = null;

		PreparedStatement stmt = con.prepareStatement("select * from match where id_match = ?");
		stmt.setLong(1, match.getIdMatch());

		// executa um select
		ResultSet rs = stmt.executeQuery();
		try {
			while (rs.next()) {
				match.setRequisitante(rs.getLong("requisitante"));
				match.setRequisitado(rs.getLong("requisitado"));
				match.setStart(rs.getString("start"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt.close();
			con.close();

		}
		return match;
	}

	@Override
	public void delete(Match match) throws SQLException {
		Connection con = new ConnectionFactory().getConnectionJDBC();
		PreparedStatement stmt = con.prepareStatement("delete from match where id_match=?");
		try {
			stmt.setLong(1, match.getIdMatch());
			stmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
			stmt.close();
		}

	}

}
