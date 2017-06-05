package br.com.dog.model.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static Connection conn;
	private static final String URL_WEB = "jdbc:h2://localhost/database";
//	private static final String URL = "jdbc:h2:bancodedados/database";
	private static final String USER = "sa";
	private static final String PASSWORD = "";

	public static Connection getConnectionJDBC() {
		try {
			if ((conn == null) || (conn.isClosed() == true)) {
				try {
					conn = DriverManager.getConnection(URL_WEB, USER, PASSWORD);
					
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}

	public static void main(String[] args) {
		getConnectionJDBC();
	}
}