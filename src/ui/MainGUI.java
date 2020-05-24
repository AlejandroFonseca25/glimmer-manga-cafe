package ui;

import java.io.IOException;

import customExceptions.EmptyFieldException;
import customExceptions.LoginException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import model.Manager;
import threads.ClockThread;

public class MainGUI {

		private ClientGUI clientGUI;
		
		private EmployeeGUI employeeGUI;
		
		private AdminGUI adminGUI;
		
		@FXML
		private Button logoutBut;
		
	    @FXML
	    private Label dateHourTextField;
	    
	    @FXML
	    private ChoiceBox<String> clientIdTypeADD;
		
		@FXML
		private TextField employeeLoginID;

	    @FXML
	    private PasswordField employeeLoginPassword;
	    
	    @FXML
	    private TextField clientID;

	    @FXML
	    private PasswordField clientPassword;
	    
		@FXML
	    private ImageView logoImageView;   

	    @FXML
	    private BorderPane mainPane;

	    private Manager m1;
	   
	    public MainGUI(Manager manager) {
	    	this.m1 = manager;
	    	
	    	if (clientGUI == null) {
	    		this.clientGUI = new ClientGUI(this, manager);
	    	}
	    	
	    	if (employeeGUI == null) {
	    		this.employeeGUI = new EmployeeGUI(this, manager, null);
	    	}
	    	
	    	if (adminGUI == null) {
	    		this.adminGUI = new AdminGUI(this, manager, employeeGUI);
	    	}
	    	
	    	
	    	employeeGUI.setAdminGUI(adminGUI);
	    	
	    	ClockThread clock = new ClockThread(this);
	    	clock.setDaemon(true);
	    	clock.start();
		}
	    
	    public void initialize() {}

	    
		@FXML
		public void signInEmployee(ActionEvent event) throws IOException {
			if(employeeLoginID.getText().equals("admin11037") && employeeLoginPassword.getText().equals("accessV3")){
				adminGUI.loadAdminInterface(null);
			} 
			
			else{employeeGUI.loadEmployeeInterface(null);
				logoutBut.setVisible(true);
				logoutBut.setDisable(false);
			}
		}

		@FXML
		public void signInClient(ActionEvent event) throws IOException {
			
			try {
				
			if(clientID.getText().equals("") || clientPassword.getText().equals("")){
				throw new EmptyFieldException();
			}	
				
			boolean valid = m1.checkValues(clientID.getText(), clientPassword.getText());
			
			if(valid) {
				clientGUI.loadClientInterface(null);
				logoutBut.setVisible(true);
				logoutBut.setDisable(false);
			}else throw new LoginException();

			}catch(EmptyFieldException | LoginException e) {

				Alert a = new Alert(AlertType.WARNING, e.getMessage());
				a.show();
			}	
		}
	    
		
	    @FXML
	    public void loadLogin(ActionEvent event) throws IOException {
	    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Client_Login.fxml"));

			fxmlLoader.setController(this);
			
			Parent root = fxmlLoader.load();
			
			mainPane.getChildren().clear();
			mainPane.setCenter(root);
			logoutBut.setVisible(false);
			logoutBut.setDisable(true);
	    }
	    

	  

		@FXML
		public void loadEmployeeLogin(ActionEvent event) throws IOException {
		
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Employee_Login.fxml"));
		
			fxmlLoader.setController(this);
			
			Parent root = fxmlLoader.load();
			
			mainPane.getChildren().clear();
			mainPane.setCenter(root);
		}



	    @FXML
	    public void loadSignUp(ActionEvent event) throws IOException {

	    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Client_SignUp.fxml"));
			
			fxmlLoader.setController(employeeGUI);
			
			Parent root = fxmlLoader.load();
			
			mainPane.getChildren().clear();
			mainPane.setCenter(root);
			
			employeeGUI.getClientIdTypeADD().getItems().addAll("Citizen ID", "Identity card", "Foreigner ID", "Passport");
	    }

	    public BorderPane getMainPane () {
	    	return mainPane;
	    }


		public void updateHour(String dateHour) {
			
			dateHourTextField.setText(dateHour);
			
		}

		public Button getLogoutBut() {
			return logoutBut;
		}
		
}
