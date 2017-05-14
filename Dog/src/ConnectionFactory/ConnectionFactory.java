package ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static Connection conn;

	public static Connection getConnectionJDBC() {
		try {
			if ((conn == null) || (conn.isClosed() == true)) {
				try {
					conn = DriverManager.getConnection("jdbc:h2:bancodedados/databasedog", "sa", "");
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