package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import model.Manager;

public class MainGUI {

		private ClientGUI clientGUI;
		
		private EmployeeGUI employeeGUI;
		
		private AdminGUI adminGUI;
		
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
		}

	    
	    /** admin11037 / accessV3 */
		@FXML
		void signInEmployee(ActionEvent event) throws IOException {
			if(employeeLoginID.getText().equals("admin11037") && employeeLoginPassword.getText().equals("accessV3")){
				adminGUI.loadAdminInterface(null);
			} 
			
			else{employeeGUI.loadEmployeeInterface(null);}
		}

		@FXML
		void signInClient(ActionEvent event) throws IOException {
			clientGUI.loadClientInterface(null);
		}
	    
		
	    @FXML
	    void loadLogin(ActionEvent event) throws IOException {
	    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Client_Login.fxml"));

			fxmlLoader.setController(this);
			
			Parent root = fxmlLoader.load();
			
			mainPane.getChildren().clear();
	    	mainPane.setCenter(root);
	    }
	    

	  

		@FXML
		void loadEmployeeLogin(ActionEvent event) throws IOException {
		
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Employee_Login.fxml"));
		
			fxmlLoader.setController(this);
			
			Parent root = fxmlLoader.load();
			
			mainPane.getChildren().clear();
			mainPane.setCenter(root);
		}



	    @FXML
	    void loadSignUp(ActionEvent event) throws IOException {

	    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Client_SignUp.fxml"));
			
			fxmlLoader.setController(employeeGUI);
			
			Parent root = fxmlLoader.load();
			
			mainPane.getChildren().clear();
			mainPane.setCenter(root);
	    }

	    public BorderPane getMainPane () {
	    	return mainPane;
	    }
	    
}
