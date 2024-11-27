package application;
import java.sql.*;

public class DatabaseConnection {

	private static final String url = "jdbc:mysql://localhost:3306/mediaLibrary";
	private static final String username = "root";
	private static final String password = "";

	public static Connection getConnection() throws SQLException {
	            return DriverManager.getConnection(url, username, password);
	}
}

