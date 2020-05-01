package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Manager;

public class Main extends Application{
	private GlimmerGUI glimmerGUI;
	private Manager manager;
	
	public Main() {
		manager = new Manager();
		glimmerGUI = new GlimmerGUI(manager);
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Main_Panel.fxml"));

		fxmlLoader.setController(glimmerGUI);
		
		Parent root = fxmlLoader.load();
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Glimmer - MANGA & CAFE");
		primaryStage.show();
		glimmerGUI.loadLogin(null);
	}
	
}
