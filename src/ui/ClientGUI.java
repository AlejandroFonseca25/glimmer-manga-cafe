package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Manager;

public class ClientGUI {

    @FXML
    private Label clientNameUPLEFT;

    @FXML
    private Label dateHourTextField;
    
    @FXML
    private ChoiceBox<?> extensionPlans;
	
	@FXML
	private TextField clientEmailSelfADD;
	
    @FXML
    private ListView<?> availableFoodList;

    @FXML
    private ListView<?> chosenFoodList;
    
    @FXML
    private ListView<?> availableMangasList;

    @FXML
    private ListView<?> chosenMangasList;
    
    @FXML
    private Label timeLeftClientTextField;
    
    @FXML
    private Button roomA;

    @FXML
    private Button roomB;

    @FXML
    private Button roomC;

    @FXML
    private Button roomD;

    @FXML
    private Button roomE;

    @FXML
    private Button roomF;

    @FXML
    private Button roomG;

    @FXML
    private Button roomH;

    @FXML
    private Button roomI;

    @FXML
    private Button roomJ;

	private MainGUI mainGUI;

	private Manager m1;
	
    
    public ClientGUI(MainGUI mainGUI, Manager m1) {
    	
    	this.m1 = m1;
    	this.mainGUI = mainGUI;
    	
    }
    
    @FXML
    void rentRoom(ActionEvent event) {

    }
    
	@FXML
	void loadClientInterface(ActionEvent event) throws IOException {
	
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Client_Interface.fxml"));
	
		fxmlLoader.setController(this);
		
		Parent root = fxmlLoader.load();
		
		mainGUI.getMainPane().getChildren().clear();
		mainGUI.getMainPane().setCenter(root);
	}
    
	
	@FXML
	void loadMangas(ActionEvent event) throws IOException {
	
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Client_manga.fxml"));
		
		fxmlLoader.setController(this);
		
		Parent root = fxmlLoader.load();
		
		mainGUI.getMainPane().getChildren().clear();
		mainGUI.getMainPane().setCenter(root);
	}
	
	@FXML
	void loadFoods(ActionEvent event) throws IOException {
	
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Client_food.fxml"));
		
		fxmlLoader.setController(this);
		
		Parent root = fxmlLoader.load();
		
		mainGUI.getMainPane().getChildren().clear();
		mainGUI.getMainPane().setCenter(root);
	}
	
	@FXML
	void loadExtendTime(ActionEvent event) throws IOException {
	
	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Client_ExtendTime.fxml"));
	
	fxmlLoader.setController(this);
	
	Parent root = fxmlLoader.load();
	
	mainGUI.getMainPane().getChildren().clear();
	mainGUI.getMainPane().setCenter(root);
	
	}
	
	@FXML
	void loadRooms(ActionEvent event) throws IOException {
	
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Client_Rooms.fxml"));
	
		fxmlLoader.setController(this);
		
		Parent root = fxmlLoader.load();
	
		mainGUI.getMainPane().getChildren().clear();
		mainGUI.getMainPane().setCenter(root);
	}
	
    @FXML
    void extendPlan(ActionEvent event) {

    }
    
    
    
    @FXML
    void addManga(ActionEvent event) {

    }

    @FXML
    void confirmMangas(ActionEvent event) {

    }

    @FXML
    void removeManga(ActionEvent event) {

    }

    
    @FXML
    void addFood(ActionEvent event) {

    }

    @FXML
    void confirmFood(ActionEvent event) {

    }

    @FXML
    void removeFood(ActionEvent event) {

    }
    
    
    @FXML
    void loadLogin(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Client_Login.fxml"));

		fxmlLoader.setController(mainGUI);
		
		Parent root = fxmlLoader.load();
		
		mainGUI.getMainPane().getChildren().clear();
		mainGUI.getMainPane().setCenter(root);
    }
    
}
