package application;
	
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;



public class Main extends Application {
	private static Stage stage;
	@Override
	public void start(Stage primaryStage) {
		stage = primaryStage;
		
		BorderPane pane = new BorderPane();
		
		Button btnNewItem = new Button("Add new item");
		Button btnViewLibrary = new Button("View Library");
		Button btnCreateLibrary = new Button("Create Library");
		Button btnViewItems = new Button("View All Items");
		Button btnCreateMedia = new Button("Add New Media");
		
		
		HBox hBoxFirstRow = new HBox(10);
		hBoxFirstRow.getChildren().addAll(btnNewItem,btnViewLibrary, btnCreateLibrary);
		hBoxFirstRow.setAlignment(Pos.CENTER);
		
		HBox hBoxSecondRow = new HBox(10);
		hBoxSecondRow.getChildren().addAll(btnViewItems, btnCreateMedia);
		hBoxSecondRow.setAlignment(Pos.CENTER);

		
		VBox vbox = new VBox(10);
		vbox.getChildren().addAll(hBoxFirstRow, hBoxSecondRow);
		vbox.setAlignment(Pos.CENTER);
		pane.setCenter(vbox);

		
		Scene mainScene = new Scene(pane, 600, 300);
		
		
		
		primaryStage.setScene(mainScene);
		primaryStage.show();
		
		btnNewItem.setOnAction(e ->switchScenes(createScene.createItem(mainScene)));
		//btnViewLibrary.setOnAction(e ->switchScenes(createScene.viewLibrary(mainScene)));
		btnCreateLibrary.setOnAction(e ->switchScenes(createScene.createLibrary(mainScene)));
		//btnViewItems.setOnAction(e ->switchScenes(createScene.viewItems(mainScene)));
		btnCreateMedia.setOnAction(e ->switchScenes(createScene.createMedia(mainScene)));

	}
	
	public static void switchScenes(Scene scene) {
		stage.setScene(scene);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}