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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import model.Manager;

public class AdminGUI {

    @FXML
    private Label adminNameUPLEFT;

    @FXML
    private Label dateHourTextField;
    
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
    private TextField employeePhoneUPDT;

    @FXML
    private TextField employeeAgeUPDT;

    @FXML
    private TextField employeeFirstNameUPDT;

    @FXML
    private TextField employeeLastNameUPDT;

    @FXML
    private ToggleGroup genderEmployee;

    @FXML
    private RadioButton employeeMaleRB;

    @FXML
    private RadioButton employeeFemaleRB;

    @FXML
    private ChoiceBox<?> employeeIDTypeUPDT;

    @FXML
    private TextField employeePositionUPDT;

    @FXML
    private Label employeeIDUPDT;

    @FXML
    private TextField employeePasswordUPDT;
    
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
    private ChoiceBox<String> clientIdTypeADDfromADM;
    
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

    @FXML
    void loadAddClient(ActionEvent event) throws IOException {

    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Admin_addClient.fxml"));

		fxmlLoader.setController(this);
		
		Parent root = fxmlLoader.load();
		
		mainGUI.getMainPane().getChildren().clear();
		mainGUI.getMainPane().setCenter(root);
		clientIdTypeADDfromADM.getItems().addAll("Citizen ID", "Identity card", "Foreigner ID", "Passport");
    }

	@FXML
	void loadEmployeeManagement(ActionEvent event) throws IOException {
	
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Admin_EmployeeManagement.fxml"));
	
		fxmlLoader.setController(this);
		
		Parent root = fxmlLoader.load();
		
		mainGUI.getMainPane().getChildren().clear();
		mainGUI.getMainPane().setCenter(root);
	}

	@FXML
	void loadPayments(ActionEvent event) throws IOException {
	
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Admin_Payment.fxml"));
	
		fxmlLoader.setController(employeeGUI);
		
		Parent root = fxmlLoader.load();
		
		mainGUI.getMainPane().getChildren().clear();
		mainGUI.getMainPane().setCenter(root);
	}

	@FXML
	void loadRoomManagement(ActionEvent event) throws IOException {
	
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Admin_RoomManagement.fxml"));
	
		fxmlLoader.setController(this);
		
		Parent root = fxmlLoader.load();
		
		mainGUI.getMainPane().getChildren().clear();
		mainGUI.getMainPane().setCenter(root);
	}

	@FXML
	void loadSupplyManagement(ActionEvent event) throws IOException {
	
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Admin_SupplyManagement.fxml"));
	
		fxmlLoader.setController(employeeGUI);
		
		Parent root = fxmlLoader.load();
		
		mainGUI.getMainPane().getChildren().clear();
		mainGUI.getMainPane().setCenter(root);
	}

	@FXML
	void loadSystemInformation(ActionEvent event) throws IOException {
	
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Admin_SystemInformation.fxml"));
	
		fxmlLoader.setController(employeeGUI);
		
		Parent root = fxmlLoader.load();
		
		mainGUI.getMainPane().getChildren().clear();
		mainGUI.getMainPane().setCenter(root);
	}


	@FXML
	void loadUpdateClientAdmin(ActionEvent event) throws IOException {
	
	
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Admin_UpdateClient.fxml"));
	
		fxmlLoader.setController(this);
		
		Parent root = fxmlLoader.load();
		
		mainGUI.getMainPane().getChildren().clear();
		mainGUI.getMainPane().setCenter(root);
	
	}
	
    @FXML
    void loadAdminInterface(ActionEvent event) throws IOException {


    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Admin_Interface.fxml"));

		fxmlLoader.setController(this);
		
		Parent root = fxmlLoader.load();
		
		mainGUI.getMainPane().getChildren().clear();
		mainGUI.getMainPane().setCenter(root);
    }  
    
	@FXML
	void loadEmployeeInterface(ActionEvent event) throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Employee_Interface.fxml"));

		fxmlLoader.setController(employeeGUI);

		Parent root = fxmlLoader.load();

		mainGUI.getMainPane().getChildren().clear();
		mainGUI.getMainPane().setCenter(root);
	}

    @FXML
    void updateClientAdmin(ActionEvent event) {

    }

    @FXML
    void updateRoomsAdmin(ActionEvent event) {

    }

    @FXML
    void updateEmployee(ActionEvent event) {

    }
    
    @FXML
    void pay(ActionEvent event) {

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
    void addClient(ActionEvent event) {

    }
    
	@FXML
    void saveChangesEmployee(ActionEvent event) {

    }

    @FXML
    void searchEmployee(ActionEvent event) {

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
