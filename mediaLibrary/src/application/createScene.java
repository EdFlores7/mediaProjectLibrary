package application;



import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.control.TextField;

public class createScene {
	private static DatabaseAccess db = new DatabaseAccess();
	
	public static Scene createItem(Scene mainScene) {
		
		
		BorderPane pane = new BorderPane();
		
		Label titleLbl = new Label("Enter information to add a new item");
		titleLbl.setFont(new Font("Arial", 15));
		HBox topHbox = new HBox();
		topHbox.getChildren().add(titleLbl);
		topHbox.setAlignment(Pos.CENTER);
		pane.setTop(topHbox);
		
		GridPane grid = new GridPane();
		grid.setVgap(10);
		Label itemLbl = new Label("Item Name: ");
		grid.add(itemLbl, 0, 0);
		TextField text1 = new TextField();
		grid.add(text1, 1, 0);
		
		Label creatorLbl = new Label("Creator: ");
		grid.add(creatorLbl, 0, 1);
		TextField text2 = new TextField();
		grid.add(text2, 1, 1);
		
		ComboBox<String> mediaList = new ComboBox<String>();
		try {
			mediaList.setItems(FXCollections.observableArrayList(db.getMedia()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Label mediaLbl = new Label("Media Type: ");
		grid.add(mediaLbl, 0, 2);
		grid.add(mediaList, 1, 2);
		
		ComboBox<String> libraryList = new ComboBox<String>();
		try {
			libraryList.setItems(FXCollections.observableArrayList(db.getLibrary()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Label libraryLbl = new Label("Library: ");
		grid.add(libraryLbl, 0, 3);
		grid.add(libraryList, 1, 3);
		
		
		
		Label descriptionLbl = new Label("Notes: ");
		grid.add(descriptionLbl, 0, 4);
		TextArea texta = new TextArea();
		texta.setPrefColumnCount(15);
		texta.setPrefHeight(100);
		texta.setPrefWidth(300);
		grid.add(texta, 1, 4);
		grid.setAlignment(Pos.CENTER);
		
		HBox bottomHbox = new HBox();
		
		//Temporary back button
		Button back = new Button("Go Back");
		back.setOnAction(e ->Main.switchScenes(mainScene));
		
		
		Button submitButton = new Button("Submit");
		submitButton.setOnAction(e ->{
				try {
					db.addItem(text1.getText(), text2.getText(), texta.getText(), db.getId(mediaList.getValue()), db.getLibraryId(libraryList.getValue()));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

		});
		
		bottomHbox.getChildren().addAll(back, submitButton);
		
		pane.setBottom(bottomHbox);
		pane.setCenter(grid);
		
		Scene scene = new Scene(pane, 600, 300);
		
	
		return scene;
	}


	//public static Scene viewLibrary() {
		
		//return scene;
	//}
	
	public static Scene createLibrary(Scene mainScene) {
		BorderPane pane = new BorderPane();
		
		Label titleLbl = new Label("Enter information to create a new library:");
		titleLbl.setFont(new Font("Arial", 15));
		HBox topHbox = new HBox();
		topHbox.getChildren().add(titleLbl);
		topHbox.setAlignment(Pos.CENTER);
		pane.setTop(topHbox);
		
		GridPane grid = new GridPane();
		grid.setVgap(10);
		Label libraryLbl = new Label("Library Name: ");
		grid.add(libraryLbl, 0, 0);
		TextField text = new TextField();
		grid.add(text, 1, 0);
		grid.setAlignment(Pos.CENTER);
		
		
		HBox bottomHbox = new HBox();
		
		//Temporary back button
		Button back = new Button("Go Back");
		back.setOnAction(e ->Main.switchScenes(mainScene));
		
		Button submitButton = new Button("Submit");
		submitButton.setOnAction(e ->{
			try {
				db.addLibrary(text.getText());
				text.clear();
			} catch (SQLException e1) {
				System.out.println("Error");
			}
		});
		
		bottomHbox.getChildren().addAll(back, submitButton);
		pane.setBottom(bottomHbox);
		pane.setCenter(grid);
		
		Scene scene = new Scene(pane, 600, 300);
		return scene;
	}
	
	//public static Scene viewItems() {
	
	
		//return scene;
	//}
	
	public static Scene createMedia(Scene mainScene) {
		BorderPane pane = new BorderPane();
		
		Label titleLbl = new Label("Enter new media name:");
		titleLbl.setFont(new Font("Arial", 15));
		HBox topHbox = new HBox();
		topHbox.getChildren().add(titleLbl);
		topHbox.setAlignment(Pos.CENTER);
		pane.setTop(topHbox);
		
		GridPane grid = new GridPane();
		grid.setVgap(10);
		Label libraryLbl = new Label("Media name: ");
		grid.add(libraryLbl, 0, 0);
		TextField text = new TextField();
		grid.add(text, 1, 0);
		grid.setAlignment(Pos.CENTER);
		
		
		HBox bottomHbox = new HBox();

		//Temporary back button
		Button back = new Button("Go Back");
		back.setOnAction(e ->Main.switchScenes(mainScene));
		
		Button submitButton = new Button("Submit");
		
		submitButton.setOnAction(e ->{
			try {
				db.addMedia(text.getText());
				text.clear();
			} catch (SQLException e1) {
				System.out.println("Error");
			}
		});
		
		bottomHbox.getChildren().addAll(back, submitButton);
		pane.setBottom(bottomHbox);
		pane.setCenter(grid);
		
		Scene scene = new Scene(pane, 600, 300);
		return scene;
	}
	
	
	
	
}
