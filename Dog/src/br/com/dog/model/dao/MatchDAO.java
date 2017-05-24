package br.com.dog.model.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.dog.model.entity.Cachorro;
import br.com.dog.model.entity.Match;
import br.com.dog.model.entity.Usuario;

public interface MatchDAO {

	// Create
	public void create(Match match) throws SQLException;

	// ReadAll
	public List<Match> readAll() throws SQLException;

	// DeleteAll
	public void deleteAll() throws SQLException;

	// Update
	public void update(Match match) throws SQLException;

	// Read especifico
	public Match read(Match match) throws SQLException;

	// Delete per id
	public void delete(Match match) throws SQLException;
}
