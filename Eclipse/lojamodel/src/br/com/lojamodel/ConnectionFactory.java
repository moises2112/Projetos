package br.com.lojamodel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

public class ConnectionFactory {

	private static Connection conn;

	public static Connection getConnectionJDBC() {
		try {
			if ((conn == null) || (conn.isClosed() == true)) {
				try {
					conn = DriverManager.getConnection("jdbc:h2:bancodedados/db", "sa", "");
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

	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:h2:bancodedados/db", "sa", "");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
