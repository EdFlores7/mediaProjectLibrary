package application;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


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
	
	public void addItem(String item) throws SQLException {
		
	}
	
    public List<String> getData() throws SQLException {

    	String query = "Select media_name from medias";
        List<String> options = new ArrayList<>();

		try (Connection conn = DatabaseConnection.getConnection();
		Statement stmt = conn.createStatement();
		
		PreparedStatement stmnt = conn.prepareStatement(query)){
			ResultSet set = stmnt.executeQuery();
		



            while (set.next()) {
                options.add(set.getString("media_name"));
            }

            set.close();

            // Return the List
            return options;
		}
        }
    }

