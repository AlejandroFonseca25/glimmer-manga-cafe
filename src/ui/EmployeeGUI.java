package ui;

import java.io.IOException;

import customExceptions.EmptyFieldException;
import customExceptions.RepeatedUserException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import model.Manager;

public class EmployeeGUI {

	
	@FXML
	private TextField clientEmailUPDT;

	@FXML
	private TextField clientEmailADD;
	
	@FXML
	private TextField clientEmailSelfADD;

	@FXML
	private Label employeeNameUPLEFT;

	@FXML
	private TextField userIDPAY;

	@FXML
	private TextField amountToPay;

	@FXML
	private DatePicker clientAgeUPDT;

	@FXML
	private TextField clientFirstNameUPDT;

	@FXML
	private TextField clientLastNameUPDT;

	@FXML
	private RadioButton clientMaleRB;

	@FXML
	private RadioButton clientFemaleRB;

	@FXML
	private ToggleGroup gender;

	@FXML
	private TextField clientIDUPDT;

	@FXML
	private ChoiceBox<?> iDType;
	
    @FXML
    private ChoiceBox<String> clientIdTypeADD;
    
	@FXML
	private TextField clientPhoneUPDT;

	@FXML
	private ToggleGroup clientGender;

	@FXML
	private TextField clientPhoneADD;

	@FXML
	private DatePicker clientAgeADD;

	@FXML
	private TextField clientFirstNameADD;

	@FXML
	private TextField clientLastNameADD;

	@FXML
	private RadioButton clientMaleRBADD;

	@FXML
	private ToggleGroup clientGenderADD;

	@FXML
	private RadioButton clientFemaleRBADD;

	@FXML
	private TextField clientIDADD;

	@FXML
	private PasswordField clientPasswordADD;

	@FXML
	private TextField productIDSearch;

	@FXML
	private ChoiceBox<?> productType;

	@FXML
	private TextField productName;

	@FXML
	private TextField productShelf;

	private MainGUI mainGUI;

	private Manager m1;
	
	private AdminGUI adminGUI;

	public EmployeeGUI(MainGUI mainGUI, Manager m1, AdminGUI adminGUI) {
		this.mainGUI = mainGUI;
		this.m1 = m1;
		this.adminGUI = adminGUI;
	}
	
	public void initialize() {}
	
    @FXML
    public void addClient(ActionEvent event) {
		try {  	

		//Wrong input
		if(clientFirstNameADD.getText().matches("[0-9]+") || clientLastNameADD.getText().matches("[0-9]+") || 
				clientPhoneADD.getText().matches("[a-zA-Z]+") || clientIDADD.getText().matches("[a-zA-Z]+")) {
			throw new IllegalArgumentException();
		}
		
		//Empty fields
		if (clientFirstNameADD.getText().equals("") || clientLastNameADD.getText().equals("") || clientAgeADD.getValue() == null || 
				clientEmailSelfADD.getText().equals("") || clientIdTypeADD.getValue() == null || clientIDADD.getText().equals("") || 
				clientPhoneADD.getText().equals("") || clientPasswordADD.getText().equals("")) {
			
			throw new EmptyFieldException();
		
			
		}
		
		boolean repeated = m1.addClient(clientFirstNameADD.getText(),
				clientLastNameADD.getText(),
				clientIDADD.getText(), 
				clientIdTypeADD.getValue(), 
				clientAgeADD.getValue(), 
				clientPhoneADD.getText(),
				clientEmailSelfADD.getText(), 
				clientPasswordADD.getText(),
				clientGenderADD.selectedToggleProperty().getName());
		
		if (repeated) {
			throw new RepeatedUserException();
		}
		}catch(IllegalArgumentException | EmptyFieldException | RepeatedUserException e) {
			
			Alert a = new Alert(AlertType.ERROR, e.getMessage());
			a.show();
		}
    }


    @FXML
    public void pay(ActionEvent event) {
    	
	}
	
    @FXML
    public void updateClientEmployee(ActionEvent event) {

    }
    
    
    @FXML
    public void addProduct(ActionEvent event) {

    }

    @FXML
    public void removeProduct(ActionEvent event) {

    }

    @FXML
    public void searchProductID(ActionEvent event) {

    }  
    
    @FXML
    public void loadEmployeeInterface(ActionEvent event) throws IOException {
	
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Employee_Interface.fxml"));
	
		fxmlLoader.setController(this);
	
		Parent root = fxmlLoader.load();
	
		mainGUI.getMainPane().getChildren().clear();
		mainGUI.getMainPane().setCenter(root);
	}

	@FXML
	public void loadSystemInformation(ActionEvent event) throws IOException {
	
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Employee_SystemInformation.fxml"));
	
		fxmlLoader.setController(this);
		
		Parent root = fxmlLoader.load();
		
		mainGUI.getMainPane().getChildren().clear();
		mainGUI.getMainPane().setCenter(root);
	}

	@FXML
	public void loadAddClient(ActionEvent event) throws IOException {
	
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Employee_addClient.fxml"));
	
		fxmlLoader.setController(this);
		
		Parent root = fxmlLoader.load();
		
		mainGUI.getMainPane().getChildren().clear();
		mainGUI.getMainPane().setCenter(root);
		clientIdTypeADD.getItems().addAll("Citizen ID", "Identity card", "Foreigner ID", "Passport");
	}

	@FXML
	public void loadSupplyManagement(ActionEvent event) throws IOException {
	
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Employee_SupplyManagement.fxml"));
	
		fxmlLoader.setController(this);
		
		Parent root = fxmlLoader.load();
		
		mainGUI.getMainPane().getChildren().clear();
		mainGUI.getMainPane().setCenter(root);
	}

	@FXML
	public void loadPayments(ActionEvent event) throws IOException {
	
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Employee_Payment.fxml"));
	
		fxmlLoader.setController(this);
		
		Parent root = fxmlLoader.load();
		
		mainGUI.getMainPane().getChildren().clear();
		mainGUI.getMainPane().setCenter(root);
	}

	@FXML
	public void loadUpdateClientEmployee(ActionEvent event) throws IOException {

    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Employee_UpdateClient.fxml"));

		fxmlLoader.setController(this);
		
		Parent root = fxmlLoader.load();
		
		mainGUI.getMainPane().getChildren().clear();
		mainGUI.getMainPane().setCenter(root);
    }
    
    @FXML
    public void loadAdminInterface(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Admin_Interface.fxml"));

		fxmlLoader.setController(adminGUI);
		
		Parent root = fxmlLoader.load();
		
		mainGUI.getMainPane().getChildren().clear();
		mainGUI.getMainPane().setCenter(root);
    } 
    
    public void setAdminGUI (AdminGUI ag) {
    	adminGUI = ag;
    }
    
    @FXML
    public void loadLogin(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Client_Login.fxml"));

		fxmlLoader.setController(mainGUI);
		
		Parent root = fxmlLoader.load();
		
		mainGUI.getMainPane().getChildren().clear();
		mainGUI.getMainPane().setCenter(root);
		mainGUI.getLogoutBut().setVisible(false);
		mainGUI.getLogoutBut().setDisable(true);
    }

	public ChoiceBox<String> getClientIdTypeADD() {
		
		return clientIdTypeADD;
    
	}
    
}
