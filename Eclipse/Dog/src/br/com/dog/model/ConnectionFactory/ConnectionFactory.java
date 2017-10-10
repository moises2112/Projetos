package br.com.dog.model.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static Connection conn;
	private static final String URL_WEB = "jdbc:h2:C:/Users/moise/Desktop/Moises/GIT_REPOSIT�RIOS/Projetos/Dog/bancodedados/database";
	private static final String URL = "jdbc:h2:bancodedados/database";
	private static final String USER = "sa";
	private static final String PASSWORD = "";

	public static Connection getConnectionJDBC() {
		try {
			if ((conn == null) || (conn.isClosed() == true)) {
				try {
					try {
						Class.forName("org.h2.Driver").newInstance();
					} catch (ClassNotFoundException e) {
						throw new SQLException(e.getMessage());
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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