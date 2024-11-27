package application;
import java.sql.*;


public class DatabaseAccess {
	public void addMedia(String media) throws SQLException {
		String query = "INSERT INTO medias (media_name) VALUES (?)";
		
		
		try (Connection conn = DatabaseConnection.getConnection();
		Statement stmt = conn.createStatement();
		
		PreparedStatement stmnt = conn.prepareStatement(query)) {
			stmnt.setString(1,media);
			stmnt.executeUpdate();
		}
	}
	
	public void addLibrary(String library) throws SQLException {
		String query = "INSERT INTO libraries (library_name) VALUES (?)";
		
		
		try (Connection conn = DatabaseConnection.getConnection();
		Statement stmt = conn.createStatement();
		
		PreparedStatement stmnt = conn.prepareStatement(query)) {
			stmnt.setString(1,library);
			stmnt.executeUpdate();
		}
	}
}
