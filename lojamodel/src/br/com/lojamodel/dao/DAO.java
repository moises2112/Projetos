package br.com.lojamodel.dao;

import java.sql.SQLException;
import java.util.List;

//CRUD
public interface DAO {

	// Create
	public void adicionar(Object object) throws SQLException;

	// Read
	public List<Object> buscarTodos() throws SQLException;

	// Update
	public void atualizar(Object object, int a) throws SQLException;

	// Delete
	public void remover(Object object) throws SQLException;

	// Metodo para buscar todos pelo ID
	public Object buscarPorId(Object object) throws SQLException;

	// Método para buscar todos pelo Nome
	public Object buscarPorNome(Object object) throws SQLException;

	// Método para remover por id
	void removerPorId(Object object) throws SQLException;
}
