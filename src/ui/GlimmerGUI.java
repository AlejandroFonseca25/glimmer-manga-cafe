package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import model.Manager;

public class GlimmerGUI {
	    @FXML
	    private Label adminNameUPLEFT;
	    
	    @FXML
	    private Label employeeNameUPLEFT;
		 
	    @FXML
	    private Label clientNameUPLEFT;

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
	    private RadioButton roomDisabled;

	    @FXML
	    private ToggleGroup roomGroup;

	    @FXML
	    private RadioButton roomEnabled;

	    @FXML
	    private TextField clientPhoneNumberUPDT;

	    @FXML
	    private TextField clientAgeUPDT;

	    @FXML
	    private TextField clientFirstNameUPDT;

	    @FXML
	    private TextField clientLastNameUPDT;

	    @FXML
	    private RadioButton clientMaleRB;

	    @FXML
	    private ToggleGroup gender;

	    @FXML
	    private RadioButton clientFemaleRB;

	    @FXML
	    private TextField clientIDUPDT;

	    @FXML
	    private ChoiceBox<?> iDType;

	    @FXML
	    private RadioButton clientInactiveRB;

	    @FXML
	    private RadioButton clientBannedRB;

	    @FXML
	    private RadioButton clientActiveRB;

	    @FXML
	    private ToggleGroup clientStatus;

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
	    private RadioButton employeeMaleRB;

	    @FXML
	    private ToggleGroup genderEmployee;

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
	    private TextField clientPhoneUPDT;

	    @FXML
	    private ToggleGroup clientGender;

	    @FXML
	    private ChoiceBox<?> extensionPlans;

	    @FXML
	    private ListView<?> availableFoodList;

	    @FXML
	    private ListView<?> chosenFoodList;

	    @FXML
	    private TextField employeeLoginID;

	    @FXML
	    private TextField employeeLoginPassword;

	    @FXML
	    private ImageView logoImageView;
	    
	    @FXML
	    private TextField clientID;

	    @FXML
	    private PasswordField clientPassword;
	    
	    @FXML
	    private Label timeLeftClientTextField;

	    @FXML
	    private ListView<?> availableMangasList;

	    @FXML
	    private ListView<?> chosenMangasList;

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

	    @FXML
	    private TextField clientPhoneADD;

	    @FXML
	    private TextField clientAgeADD;

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


	    @FXML
	    private BorderPane mainPane;

	    private Manager m1;

		@FXML
	    void saveChangesEmployee(ActionEvent event) {

	    }

	    @FXML
	    void searchEmployee(ActionEvent event) {

	    }	
	    
	    @FXML
	    void addProduct(ActionEvent event) {

	    }

	    @FXML
	    void backFromSupplyManagement(ActionEvent event) {

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
	    void rentRoom(ActionEvent event) {

	    }
	    
	    @FXML
	    void setSelectedRoomName(MouseEvent event) {

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
	    void signInClient(ActionEvent event) throws IOException {
	    	loadClientInterface(null);
	    }

	    @FXML
	    void signUp(ActionEvent event) {
	    	
	    }

	    @FXML
	    void signInEmployee(ActionEvent event) throws IOException {
	    	loadEmployeeInterface(null);
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
	    void extendPlan(ActionEvent event) {

	    }

	    
	    @FXML
	    void updateClientEmployee(ActionEvent event) {

	    }
	    
	    @FXML
	    void employeeIDUPDT(ActionEvent event) {

	    }

	    @FXML
	    void updateEmployee(ActionEvent event) {

	    }
	    
	    @FXML
	    void updateClientAdmin(ActionEvent event) {

	    }

	    @FXML
	    void updateRoomsAdmin(ActionEvent event) {

	    }
	    
	    @FXML
	    void pay(ActionEvent event) {

	    }
	       
	    
	    @FXML
	    void loadAdminInterface(ActionEvent event) throws IOException {


	    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Admin_Interface.fxml"));

			fxmlLoader.setController(this);
			
			Parent root = fxmlLoader.load();
			
			mainPane.getChildren().clear();
	    	mainPane.setCenter(root);
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
	    void loadAddClient(ActionEvent event) throws IOException {

	    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Employee_addUser.fxml"));

			fxmlLoader.setController(this);
			
			Parent root = fxmlLoader.load();
			
			mainPane.getChildren().clear();
	    	mainPane.setCenter(root);
	    }

	    @FXML
	    void loadUpdateClientEmployee(ActionEvent event) throws IOException {

	    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Employee_UpdateUser.fxml"));

			fxmlLoader.setController(this);
			
			Parent root = fxmlLoader.load();
			
			mainPane.getChildren().clear();
	    	mainPane.setCenter(root);
	    }

		@FXML
		void loadRooms(ActionEvent event) throws IOException {
		
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Client_Rooms.fxml"));
		
			fxmlLoader.setController(this);
			
			Parent root = fxmlLoader.load();
			
			mainPane.getChildren().clear();
			mainPane.setCenter(root);
		}

		@FXML
		void loadEmployeeManagement(ActionEvent event) throws IOException {
		
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Admin_EmployeeManagement.fxml"));
		
			fxmlLoader.setController(this);
			
			Parent root = fxmlLoader.load();
			
			mainPane.getChildren().clear();
			mainPane.setCenter(root);
		}

		@FXML
		void loadPayments(ActionEvent event) throws IOException {
		
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Employee_Payment.fxml"));
		
			fxmlLoader.setController(this);
			
			Parent root = fxmlLoader.load();
			
			mainPane.getChildren().clear();
			mainPane.setCenter(root);
		}

		@FXML
		void loadRoomManagement(ActionEvent event) throws IOException {
		
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Admin_RoomManagement.fxml"));
		
			fxmlLoader.setController(this);
			
			Parent root = fxmlLoader.load();
			
			mainPane.getChildren().clear();
			mainPane.setCenter(root);
		}

		@FXML
		void loadSupplyManagement(ActionEvent event) throws IOException {
		
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Employee_SupplyManagement.fxml"));
		
			fxmlLoader.setController(this);
			
			Parent root = fxmlLoader.load();
			
			mainPane.getChildren().clear();
			mainPane.setCenter(root);
		}

		@FXML
		void loadSystemInformation(ActionEvent event) throws IOException {
		
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Employee_SystemInformation.fxml"));
		
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
		void loadClientInterface(ActionEvent event) throws IOException {
		
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Client_Interface.fxml"));
		
			fxmlLoader.setController(this);
			
			Parent root = fxmlLoader.load();
			
			mainPane.getChildren().clear();
			mainPane.setCenter(root);
		}

		@FXML
		void loadEmployeeInterface(ActionEvent event) throws IOException {
		
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Employee_Interface.fxml"));
		
			fxmlLoader.setController(this);
			
			Parent root = fxmlLoader.load();
			
			mainPane.getChildren().clear();
			mainPane.setCenter(root);
		}

		@FXML
		void loadUpdateClientAdmin(ActionEvent event) throws IOException {
		
		
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Admin_UpdateClient.fxml"));
		
			fxmlLoader.setController(this);
			
			Parent root = fxmlLoader.load();
			
			mainPane.getChildren().clear();
			mainPane.setCenter(root);
		
		}

		@FXML
		void loadEmployeeInteface(ActionEvent event) throws IOException {
		
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Employee_Interface.fxml"));
		
			fxmlLoader.setController(this);
			
			Parent root = fxmlLoader.load();
			
			mainPane.getChildren().clear();
			mainPane.setCenter(root);
		}




		@FXML
		void loadExtendTime(ActionEvent event) throws IOException {
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Client_ExtendTime.fxml"));
		
		fxmlLoader.setController(this);
		
		Parent root = fxmlLoader.load();
		
		mainPane.getChildren().clear();
		mainPane.setCenter(root);
		
		}

		@FXML
		void loadFoods(ActionEvent event) throws IOException {
		
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Client_food.fxml"));
			
			fxmlLoader.setController(this);
			
			Parent root = fxmlLoader.load();
			
			mainPane.getChildren().clear();
			mainPane.setCenter(root);
		}

		@FXML
		void loadMangas(ActionEvent event) throws IOException {
		
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Client_manga.fxml"));
			
			fxmlLoader.setController(this);
			
			Parent root = fxmlLoader.load();
			
			mainPane.getChildren().clear();
			mainPane.setCenter(root);
		}

		

	    @FXML
	    void loadSignUp(ActionEvent event) throws IOException {

	    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Client_SignUp.fxml"));
			
			fxmlLoader.setController(this);
			
			Parent root = fxmlLoader.load();
			
			mainPane.getChildren().clear();
			mainPane.setCenter(root);
	    }
	    
	    
	public GlimmerGUI(Manager manager) {
		this.m1 = new Manager();
	}

	
	
}
