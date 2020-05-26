package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Manager;

public class Main extends Application{
	
	//TODO HACER QUE EL PROGRAMA GUARDE CUANDO SE CIERRE D:
	private MainGUI glimmerGUI;
	private Manager manager;
	
	public Main() {
		manager = new Manager();
		glimmerGUI = new MainGUI(manager);
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
		primaryStage.setResizable(false);
		primaryStage.show();
		manager.loadAll();
		//manager.init();
		glimmerGUI.loadLogin(null);
	}
}
