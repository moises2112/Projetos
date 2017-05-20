package br.com.dog.model.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.dog.model.entity.Usuario;

public interface UsuarioDAO {

	// Create
	public void create(Usuario usuario) throws SQLException;

	// ReadAll
	public List<Usuario> readAll() throws SQLException;

	// DeleteAll
	public void deleteAll() throws SQLException;

	// Update
	public void update(Usuario usuario) throws SQLException;

	// Read especifico
	public Usuario read(Usuario usuario) throws SQLException;

	// Delete per id
	public void delete(Usuario usuario) throws SQLException;
}
