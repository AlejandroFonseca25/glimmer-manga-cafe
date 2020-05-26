package ui;

import java.io.IOException;

import customExceptions.EmptyFieldException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
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
    private ChoiceBox<String> hourPlan;
    
    @FXML
    private TextField MangaSearchMAN;

    @FXML
    private TextField foodSearchFOOD;
    
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
    public void borrowMangas (ActionEvent event) {
    	try {
	    	String manga = MangaSearchMAN.getText();
	    	if (manga.equals("")) {
	    		throw new EmptyFieldException();
	    	}
	    	
	    	else {
	    		boolean saved = m1.addMangaToClient(m1.getRootManga(), mainGUI.getUsername().getText(), manga);
	    		if (!saved) {
	    			throw new IllegalArgumentException();
	    		}
	    		else {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Success");
					alert.setHeaderText(null);
					alert.setContentText("Manga borrowed successfully!");
					alert.showAndWait();
	    		}
	    	}
    	} catch (EmptyFieldException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Empty Field");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
    	} catch (IllegalArgumentException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Manga not available");
			alert.setContentText("Either the manga doesn't exists, or it is not available at the moment.");
			alert.showAndWait();
    	}
    }
    
    
    //Help me
    @FXML
    public void buyFood () {
    	try {
    		String food = foodSearchFOOD.getText();
    		if (food.equals("")) {
    			throw new EmptyFieldException();
    		}

    		else {
    			boolean possible = m1.buyFood(mainGUI.getUsername().getText(),food);
    			if (!possible) {
    				throw new IllegalArgumentException("Either inputted food does not exist or user has too much debt");
    			}
    			else {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Success");
					alert.setHeaderText(null);
					alert.setContentText("Food bought successfully!");
					alert.showAndWait();
    			}
    		}
    	}catch(IllegalArgumentException | EmptyFieldException e){
    		Alert a = new Alert(AlertType.ERROR, e.getMessage());
    		a.showAndWait();
    	}
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
