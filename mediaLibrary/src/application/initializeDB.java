package application;
import java.sql.*;

public class initializeDB {

	    public static void startDB() {

	        String url = "jdbc:mysql://localhost:3306/mydb";
	        String username = "root";
	        String password = "";

	        try (Connection conn = DriverManager.getConnection(url, username, password)) {
	            if (conn != null) {
	                System.out.println("Connected to the database!");
	            }
	        } catch (SQLException e) {
	            System.out.println("Failed to connect to the database: " + e.getMessage());
	        }
	    }
	}

