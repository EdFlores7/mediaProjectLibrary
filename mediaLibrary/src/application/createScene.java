package application;



import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.control.TextField;

public class createScene {

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
		Label mediaLbl = new Label("Media: ");
		grid.add(mediaLbl, 0, 1);
		TextField text2 = new TextField();
		grid.add(text2, 1, 1);
		grid.setAlignment(Pos.CENTER);
		
		//Temporary back button
		
		HBox bottomHbox = new HBox();
		
		Button back = new Button("Go Back");
		back.setOnAction(e ->Main.switchScenes(mainScene));
		
		Button submitButton = new Button("Submit");
		
		
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
		
		Label titleLbl = new Label("Enter information to create a new media type:");
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
		Label mediaLbl = new Label("Media type: ");
		grid.add(mediaLbl, 0, 1);
		TextField text2 = new TextField();
		grid.add(text2, 1, 1);
		grid.setAlignment(Pos.CENTER);
		
		
		HBox bottomHbox = new HBox();

		//Temporary back button
		Button back = new Button("Go Back");
		back.setOnAction(e ->Main.switchScenes(mainScene));
		
		Button submitButton = new Button("Submit");
		
		bottomHbox.getChildren().addAll(back, submitButton);
		pane.setBottom(bottomHbox);
		pane.setCenter(grid);
		
		Scene scene = new Scene(pane, 600, 300);
		return scene;
	}
	
	
	
	
}
