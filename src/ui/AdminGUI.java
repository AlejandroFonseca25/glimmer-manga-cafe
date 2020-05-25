package ui;

import java.io.IOException;

import customExceptions.EmptyFieldException;
import customExceptions.RepeatedUserException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import model.Manager;

public class AdminGUI {

    @FXML
    private Label adminNameUPLEFT;
    
    @FXML
    private TableView<?> employeeTabView;
    
    @FXML
    private TextField employeeNameMAN;

    @FXML
    private TextField employeeSystemIDMAN;

    @FXML
    private TextField employeeUserIDMAN;

    @FXML
    private TextField employeeIDMAN;

    @FXML
    private TextField employeeIDTypeMAN;

    @FXML
    private TextField employeePhoneMAN;

    @FXML
    private TextField employeeEmailMAN;

    @FXML
    private TextField employeeChargeMAN;

    @FXML
    private TextField searchEmployeeTextField;

    @FXML
    private TextField userIDPAY;
    
    @FXML
    private TextField amountToPay;
    
    @FXML
    private TextField roomIDTextField;
    
    @FXML
    private ToggleGroup roomGroup;

    @FXML
    private RadioButton roomDisabled;

    @FXML
    private RadioButton roomEnabled;

    @FXML
    private ToggleGroup clientStatus;

    @FXML
    private RadioButton clientInactiveRB;

    @FXML
    private RadioButton clientBannedRB;

    @FXML
    private RadioButton clientActiveRB;
    
    @FXML
    private TextField clientPasswordUPDT;

    @FXML
    private TextField employeePhoneADD;

    @FXML
    private DatePicker employeeAgeADD;
    
    @FXML
    private TextField employeeEmailADD;
    
    @FXML
    private TextField employeeFirstNameADD;

    @FXML
    private TextField employeeLastNameADD;

    @FXML
    private ToggleGroup employeeGenderADD;

    @FXML
    private RadioButton employeeMaleRB;

    @FXML
    private RadioButton employeeFemaleRB;

    @FXML
    private ChoiceBox<String> employeeIdTypeADD;

    @FXML
    private TextField employeeChargeADD;
    
    @FXML
    private TextField employeeIDADD;

    @FXML
    private TextField employeePasswordADD;
    
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
    private TextField clientEmailUPDT;
    
    @FXML
    private ToggleGroup gender;

    @FXML
    private TextField clientIDUPDT;

    @FXML
    private ChoiceBox<?> iDType;

    @FXML
    private TextField clientPhoneUPDT;
    
    @FXML
    private ToggleGroup clientGender;
    
    @FXML
    private TextField clientPhoneNumberUPDT;
    
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
    private ChoiceBox<String> clientIdTypeADD;
    
    @FXML
    private PasswordField clientPasswordADD;
    
    @FXML
    private TextField productIDSearch;

    @FXML
    private ChoiceBox<String> productType;

    @FXML
    private TextField productName;

    @FXML
    private TextField productShelf;
    
    private MainGUI mainGUI;
    
    private Manager m1;
    
    private EmployeeGUI employeeGUI;
    
    public AdminGUI(MainGUI mainGUI, Manager m1, EmployeeGUI employeeGUI) {

    	this.mainGUI = mainGUI;
    	this.m1 = m1;
    	this.employeeGUI = employeeGUI;
    }
    
    public void initialize() {}

    @FXML
    public void updateClientAdmin(ActionEvent event) {

    }

    @FXML
    public void updateRoomsAdmin(ActionEvent event) {

    }

    @FXML
    public void updateEmployee(ActionEvent event) {

    }
    
    @FXML
    public void pay(ActionEvent event) {

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
    public void addClient(ActionEvent event) {
    	
    	

    }
    
    @FXML
    public void addEmployee(ActionEvent event) {
		try {  	

		//Wrong input
		if(employeeFirstNameADD.getText().matches("[0-9]+") || employeeLastNameADD.getText().matches("[0-9]+") || 
				employeePhoneADD.getText().matches("[a-zA-Z]+") || employeeIDADD.getText().matches("[a-zA-Z]+") ||
				employeeChargeADD.getText().matches("[0-9]+")) {
			throw new IllegalArgumentException();
		}
		
		//Empty fields
		if (employeeFirstNameADD.getText().equals("") || employeeLastNameADD.getText().equals("") || employeeAgeADD.getValue() == null || 
				employeeEmailADD.getText().equals("") || employeeIdTypeADD.getValue() == null || employeeIDADD.getText().equals("") || 
				employeeChargeADD.getText().equals("") || employeePhoneADD.getText().equals("") || 
				employeePasswordADD.getText().equals("")) {
			
			throw new EmptyFieldException();
		
			
		}
		
		RadioButton selectedRadioButtonGender = (RadioButton) employeeGenderADD.getSelectedToggle();
		
		boolean repeated = m1.addEmployee(employeeFirstNameADD.getText(), employeeLastNameADD.getText(), employeeIDADD.getText(), 
				employeeIdTypeADD.getValue(), employeeAgeADD.getValue(), employeePhoneADD.getText(), employeeEmailADD.getText(), 
				employeePasswordADD.getText(), selectedRadioButtonGender.getText(), employeeChargeADD.getText());

		if (repeated) {
			throw new RepeatedUserException();
		}
		else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Success");
			alert.setHeaderText(null);
			alert.setContentText("Employee added successfully!");
			alert.showAndWait();
		}
		}catch(EmptyFieldException | RepeatedUserException e) {
			
			Alert a = new Alert(AlertType.ERROR, e.getMessage());
			a.showAndWait();
		}catch (IllegalArgumentException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Invalid input");
			alert.setContentText("A field has an invalid type of data. Try again.");

			alert.showAndWait();
		}
    }
    
	@FXML
	public void saveChangesEmployee(ActionEvent event) {

    }

    @FXML
    public void searchEmployee(ActionEvent event) {

    }	
    
    
    @FXML
    public void loadAdminInterface(ActionEvent event) throws IOException {
	
	
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Admin_Interface.fxml"));
	
		fxmlLoader.setController(this);
		
		Parent root = fxmlLoader.load();
		
		mainGUI.getMainPane().getChildren().clear();
		mainGUI.getMainPane().setCenter(root);
	}

	@FXML
	public void loadPayments(ActionEvent event) throws IOException {
	
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Admin_Payment.fxml"));
	
		fxmlLoader.setController(employeeGUI);
		
		Parent root = fxmlLoader.load();
		
		mainGUI.getMainPane().getChildren().clear();
		mainGUI.getMainPane().setCenter(root);
	}

	@FXML
	public void loadSupplyManagement(ActionEvent event) throws IOException {
	
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Admin_SupplyManagement.fxml"));
	
		fxmlLoader.setController(employeeGUI);
		
		Parent root = fxmlLoader.load();
		
		mainGUI.getMainPane().getChildren().clear();
		mainGUI.getMainPane().setCenter(root);
	}

	@FXML
	public void loadSystemInformation(ActionEvent event) throws IOException {
	
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Admin_SystemInformation.fxml"));
	
		fxmlLoader.setController(employeeGUI);
		
		Parent root = fxmlLoader.load();
		
		mainGUI.getMainPane().getChildren().clear();
		mainGUI.getMainPane().setCenter(root);
	}

	@FXML
	public void loadRoomManagement(ActionEvent event) throws IOException {
	
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Admin_RoomManagement.fxml"));
	
		fxmlLoader.setController(this);
		
		Parent root = fxmlLoader.load();
		
		mainGUI.getMainPane().getChildren().clear();
		mainGUI.getMainPane().setCenter(root);
	}

	@FXML
	public void loadEmployeeManagement(ActionEvent event) throws IOException {
	
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Admin_EmployeeManagement.fxml"));
	
		fxmlLoader.setController(this);
		
		Parent root = fxmlLoader.load();
		
		mainGUI.getMainPane().getChildren().clear();
		mainGUI.getMainPane().setCenter(root);
	}
    
	@FXML
	public void loadAddEmployee(ActionEvent event) throws IOException {
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Admin_AddEmployee.fxml"));
	
		fxmlLoader.setController(this);
	
		Parent root = fxmlLoader.load();
	
		mainGUI.getMainPane().getChildren().clear();
		mainGUI.getMainPane().setCenter(root);
		employeeIdTypeADD.getItems().addAll("Citizen ID", "Identity card", "Foreigner ID", "Passport");
	}

	@FXML
	public void loadAddClient(ActionEvent event) throws IOException {
	
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Admin_addClient.fxml"));
	
		fxmlLoader.setController(employeeGUI);
		
		Parent root = fxmlLoader.load();
		
		mainGUI.getMainPane().getChildren().clear();
		mainGUI.getMainPane().setCenter(root);
		employeeGUI.getClientIdTypeADD().getItems().addAll("Citizen ID", "Identity card", "Foreigner ID", "Passport");
	}

	@FXML
	public void loadUpdateClientAdmin(ActionEvent event) throws IOException {
	
	
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Admin_UpdateClient.fxml"));
	
		fxmlLoader.setController(this);
		
		Parent root = fxmlLoader.load();
		
		mainGUI.getMainPane().getChildren().clear();
		mainGUI.getMainPane().setCenter(root);
	
	}

	@FXML
	public void loadEmployeeInterface(ActionEvent event) throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Employee_Interface.fxml"));

		fxmlLoader.setController(employeeGUI);

		Parent root = fxmlLoader.load();

		mainGUI.getMainPane().getChildren().clear();
		mainGUI.getMainPane().setCenter(root);
	}
}
