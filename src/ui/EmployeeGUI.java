package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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
	private Label employeeNameUPLEFT;

	@FXML
	private Label dateHourTextField;

	@FXML
	private TextField userIDPAY;

	@FXML
	private TextField amountToPay;

	@FXML
	private TextField clientAgeUPDT;

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

    @FXML
    void addClient(ActionEvent event) {

    }

    
	@FXML
	void signUp(ActionEvent event) {

		boolean validInput = true;    	

		if(clientFirstNameADD.getText().contains("[0-9]+")|| clientLastNameADD.getText().contains("[0-9]+") || (clientPhoneADD.getText().contains("[a-zA-Z]+"))) {
			validInput = false;
		}


		if(validInput == true) {
			m1.addClient(clientFirstNameADD.getText(), clientPhoneADD.getText(), clientIDADD.getText(), clientIDADD.getText(), clientAgeADD.getValue(), clientGenderADD.selectedToggleProperty().getName(), clientPhoneADD.getText(), clientEmailADD.getText(), clientPasswordADD.getText());
		}

	}


    @FXML
    void loadAddClient(ActionEvent event) throws IOException {

    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Employee_addClient.fxml"));

		fxmlLoader.setController(this);
		
		Parent root = fxmlLoader.load();
		
		mainGUI.getMainPane().getChildren().clear();
		mainGUI.getMainPane().setCenter(root);
		clientIdTypeADD.getItems().addAll("Citizen ID", "Identity card", "Foreigner ID", "Passport");
    }

	@FXML
	void loadEmployeeInterface(ActionEvent event) throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Employee_Interface.fxml"));

		fxmlLoader.setController(this);

		Parent root = fxmlLoader.load();

		mainGUI.getMainPane().getChildren().clear();
		mainGUI.getMainPane().setCenter(root);
	}
	
	@FXML
	void loadSystemInformation(ActionEvent event) throws IOException {
	
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Employee_SystemInformation.fxml"));
	
		fxmlLoader.setController(this);
		
		Parent root = fxmlLoader.load();
		
		mainGUI.getMainPane().getChildren().clear();
		mainGUI.getMainPane().setCenter(root);
	}
	
	@FXML
	void loadSupplyManagement(ActionEvent event) throws IOException {
	
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Employee_SupplyManagement.fxml"));
	
		fxmlLoader.setController(this);
		
		Parent root = fxmlLoader.load();
		
		mainGUI.getMainPane().getChildren().clear();
		mainGUI.getMainPane().setCenter(root);
	}

	@FXML
	void loadPayments(ActionEvent event) throws IOException {
	
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Employee_Payment.fxml"));
	
		fxmlLoader.setController(this);
		
		Parent root = fxmlLoader.load();
		
		mainGUI.getMainPane().getChildren().clear();
		mainGUI.getMainPane().setCenter(root);
	}
	
    @FXML
    void loadUpdateClientEmployee(ActionEvent event) throws IOException {

    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Employee_UpdateClient.fxml"));

		fxmlLoader.setController(this);
		
		Parent root = fxmlLoader.load();
		
		mainGUI.getMainPane().getChildren().clear();
		mainGUI.getMainPane().setCenter(root);
    }
    
	@FXML
	void pay(ActionEvent event) {

	}
	
    @FXML
    void updateClientEmployee(ActionEvent event) {

    }
    
    
    @FXML
    void addProduct(ActionEvent event) {

    }

    @FXML
    void removeProduct(ActionEvent event) {

    }

    @FXML
    void searchProductID(ActionEvent event) {

    }
    
    
    
    
    
    @FXML
    void loadLogin(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Client_Login.fxml"));

		fxmlLoader.setController(mainGUI);
		
		Parent root = fxmlLoader.load();
		
		mainGUI.getMainPane().getChildren().clear();
		mainGUI.getMainPane().setCenter(root);
    }
    
    @FXML
    void loadAdminInterface(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Admin_Interface.fxml"));

		fxmlLoader.setController(adminGUI);
		
		Parent root = fxmlLoader.load();
		
		mainGUI.getMainPane().getChildren().clear();
		mainGUI.getMainPane().setCenter(root);
    } 
    
    public void setAdminGUI (AdminGUI ag) {
    	adminGUI = ag;
    }
}
