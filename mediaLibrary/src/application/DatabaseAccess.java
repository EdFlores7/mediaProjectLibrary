package application;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
	
	public void addItem(String itemName, String itemCreator, String itemDescription, int mediaId, int libraryId) throws SQLException {
		String query = "INSERT INTO items (item_name, item_description, media_id, library_id, input_date,"
				+ "item_creator) VALUES (?, ?, ?, ?, ?, ?)";
		
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd");
		String formattedDate = currentDate.format(formatter);
		
		try (Connection conn = DatabaseConnection.getConnection();
		
		PreparedStatement stmnt = conn.prepareStatement(query)) {
			stmnt.setString(1,itemName);
			stmnt.setString(2,itemDescription);
			stmnt.setInt(3, mediaId);
			stmnt.setInt(4, libraryId);
			stmnt.setString(5,formattedDate);
			stmnt.setString(6, itemCreator);
			
			
			stmnt.executeUpdate();
		}
	}
	
    public List<String> getMedia() throws SQLException {

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
    
    public List<String> getLibrary() throws SQLException {

    	String query = "Select library_name from libraries";
        List<String> options = new ArrayList<>();

		try (Connection conn = DatabaseConnection.getConnection();
		Statement stmt = conn.createStatement();
		
		PreparedStatement stmnt = conn.prepareStatement(query)){
			ResultSet set = stmnt.executeQuery();
		



            while (set.next()) {
                options.add(set.getString("library_name"));
            }

            set.close();

            // Return the List
            return options;
		}
      }
    
    public int getId(String media) throws SQLException {
    	String query = "SELECT media_id FROM medias WHERE \"" + media + "\" = media_name";
    	int media_id;

		try (Connection conn = DatabaseConnection.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query)){
			rs.next();
			media_id = rs.getInt("media_id");
		}
				
    	return media_id;
    }
    
    public int getLibraryId(String library) throws SQLException {
    	String query = "SELECT library_id FROM libraries WHERE \"" + library + "\" = library_name";
    	int library_id;

		try (Connection conn = DatabaseConnection.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query)){
			rs.next();
			library_id = rs.getInt("library_id");
		}
				
    	return library_id;
    }
    }

