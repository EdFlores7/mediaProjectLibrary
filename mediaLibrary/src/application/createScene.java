package application;

import java.awt.TextField;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class createScene {
	private static BorderPane pane = new BorderPane();

	//public static Scene viewLibrary() {
		
		//return scene;
	//}
	
	public static Scene createLibrary() {
		
		Label titleLbl = new Label("Enter information to create a new library:");
		titleLbl.setFont(new Font("Arial", 15));
		HBox topHbox = new HBox();
		topHbox.getChildren().add(titleLbl);
		topHbox.setAlignment(Pos.CENTER);
		pane.setTop(topHbox);
		
		Button BACK = new Button("BACK");
		pane.setCenter(BACK);

		
		Scene scene = new Scene(pane, 600, 300);
		
		return scene;
	}
	
	//public static Scene viewItems() {
		//return scene;
	//}
	
	//public static Scene createMedia() {
		//return scene;
	//}
	
	
	
	
}
