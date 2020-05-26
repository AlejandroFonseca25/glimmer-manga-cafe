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
import threads.SavingThread;

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
	   
	    @FXML
	    private Label timeLeft;
	   
	    @FXML
	    private Label userName;

	    private String clockTotal;
	    
	    private Manager m1;
	    
	    private int counter;
	   
	    public MainGUI(Manager manager) {
	    	this.m1 = manager;
	    
	    	counter = 0;
	    	
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
	    	
	    	SavingThread save = new SavingThread(m1);
	    	save.setDaemon(true);
	    	save.start();
	    	
	    	
		}
	    
	    public void initialize() {}

	    //TODO FIX ADMIN LOGIN CREDENTIALS
		@FXML
		public void signInEmployee(ActionEvent event) throws IOException {
			
			try {
			if(employeeLoginID.getText().equals("") || employeeLoginPassword.getText().equals("")){
				throw new EmptyFieldException();
			}	
			
			
			if(employeeLoginID.getText().equals("admin11037") && employeeLoginPassword.getText().equals("accessV3")){
				adminGUI.loadAdminInterface(null);
				logoutBut.setVisible(true);
				logoutBut.setDisable(false);
			} 
			
			else if(m1.searchEmployeeLogin(employeeLoginID.getText(), employeeLoginPassword.getText())){
				
				employeeGUI.loadEmployeeInterface(null);
				logoutBut.setVisible(true);
				logoutBut.setDisable(false);
			}
			
			else throw new LoginException();
			}catch(EmptyFieldException | LoginException e) {
				
				Alert a = new Alert(AlertType.WARNING, e.getMessage());
				a.show();
			}
		}

		@FXML
		public void signInClient(ActionEvent event) throws IOException {
			
			try {
				
			if(clientID.getText().equals("") || clientPassword.getText().equals("")){
				if(counter > 3) {throw new SecurityException();}
				else throw new EmptyFieldException();
			}	
				
			boolean valid = m1.checkValues(clientID.getText(), clientPassword.getText());
			
			if(valid && counter <= 3) {
				counter = 0;
				userName.setText(clientID.getText());
				clientGUI.loadClientInterface(null);
				logoutBut.setVisible(true);
				logoutBut.setDisable(false);
			}else if(counter > 3 ) {
				
				throw new SecurityException();
			}
				
				
				
			else throw new LoginException();

			}catch(EmptyFieldException | LoginException e ) {

				Alert a = new Alert(AlertType.WARNING, e.getMessage());
				a.show();
				counter++;
			}catch( SecurityException e) {
				Alert a = new Alert(AlertType.WARNING, "Too many attempts to logIn");
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
			userName.setText("");
			timeLeft.setText("");
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


		public void updateHour(String dateHour, String localDateValue) {
			
			dateHourTextField.setText(dateHour);
			setClockTotal(localDateValue);
			
			
		}
		
		public void updateTimeLeft(String timeLeft) {
			
			this.timeLeft.setText(timeLeft);
		}
		
		public String getHourTextField() {
			
			return dateHourTextField.getText();
		}

		public Button getLogoutBut() {
			return logoutBut;
		}
		
		public Label getUsername() {
			return userName;
		}
		
		public void setUsername(String value) {
			userName.setText(value);
		}

		public String getClockTotal() {
			return clockTotal;
		}

		public void setClockTotal(String clockTotal) {
			this.clockTotal = clockTotal;
		}
		
}
