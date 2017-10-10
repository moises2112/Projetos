package br.com.dog.model.dao;

import java.sql.SQLException;
import java.util.List;

public interface DAO {
	
	// Create
	public void adicionar(Object object) throws SQLException;

	// ReadAll
	public List<Object> buscarTodos() throws SQLException;

	// DeleteAll
	public void removerTodos() throws SQLException;

	// Update
	public void atualizar(Object object,int a) throws SQLException;

	// Read per id
	public Object buscarPorId(Object object) throws SQLException;

	// Delete per id
	public void remover(Object object) throws SQLException;

	// Delete per nome
	public Object buscarPorNome(Object object) throws SQLException;

}
