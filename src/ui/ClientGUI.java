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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.Manager;
import threads.RoomTimerThread;

public class ClientGUI {

    @FXML
    private Label clientNameUPLEFT;

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
    private ChoiceBox<String> hourPlan;
    
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
    
    public void initialize() {}
    
    @FXML
    public void rentRoom(ActionEvent event) {
    	
    	if(hourPlan.getValue() != null) {
    	Button selectedButton = (Button)event.getSource();
    	selectedButton.setDisable(true);
    	selectedButton.setStyle("-fx-background-color: red; -fx-opacity: 1;");
    	
    	String room = selectedButton.getText();
    	
    	
    	
    	m1.rentRoom(room, 
    			hourPlan.getValue(), 
    			mainGUI.getUsername().getText());	
    	
    	RoomTimerThread timerThread = new RoomTimerThread(mainGUI, m1.getRoom(room), m1.getRoom(room).getTime()); 
    	timerThread.setDaemon(true);
    	timerThread.start();
    	}

    	else { 
    		Alert a = new Alert(AlertType.ERROR, "Please select an hourly plan");
    		a.show();
    	}
    	
    	
    	//TODO Excepciones
    	
    	
    	
    }
      
   
    
    @FXML
    public void addManga(ActionEvent event) {

    }

    @FXML
    public void confirmMangas(ActionEvent event) {

    }

    @FXML
    public void removeManga(ActionEvent event) {

    }

    
    @FXML
    public void addFood(ActionEvent event) {

    }

    @FXML
    public void confirmFood(ActionEvent event) {

    }

    @FXML
    public void removeFood(ActionEvent event) {

    }
    
    
    @FXML
	public void loadClientInterface(ActionEvent event) throws IOException {
	
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Client_Interface.fxml"));
	
		fxmlLoader.setController(this);
		
		Parent root = fxmlLoader.load();
		
		mainGUI.getMainPane().getChildren().clear();
		mainGUI.getMainPane().setCenter(root);
	}

	@FXML
	public void loadMangas(ActionEvent event) throws IOException {
	
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Client_manga.fxml"));
		
		fxmlLoader.setController(this);
		
		Parent root = fxmlLoader.load();
		
		mainGUI.getMainPane().getChildren().clear();
		mainGUI.getMainPane().setCenter(root);
	}

	@FXML
	public void loadFoods(ActionEvent event) throws IOException {
	
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Client_food.fxml"));
		
		fxmlLoader.setController(this);
		
		Parent root = fxmlLoader.load();
		
		mainGUI.getMainPane().getChildren().clear();
		mainGUI.getMainPane().setCenter(root);
	}

	@FXML
	public void loadRooms(ActionEvent event) throws IOException {
	
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Client_Rooms.fxml"));
	
		fxmlLoader.setController(this);
		
		Parent root = fxmlLoader.load();
	
		mainGUI.getMainPane().getChildren().clear();
		mainGUI.getMainPane().setCenter(root);
		hourPlan.getItems().addAll("3 Hours", "6 Hours", "12 Hours", "24 Hours");
	}

	public ChoiceBox<String> getHourPlan() {
		
		return hourPlan;
		
	}  
}
