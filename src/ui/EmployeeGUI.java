package ui;

import java.io.IOException;

import customExceptions.EmptyFieldException;
import customExceptions.RepeatedException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import model.Client;
import model.Manager;

public class EmployeeGUI {
	
	@FXML
	private Label clientNameLabel;

	@FXML
	private Label clientGenderLabel;

	@FXML
	private Label clientAgeLabel;

	@FXML
	private Label userIDLabel;

	@FXML
	private Label systemIDLabel;

	@FXML
	private Label idTypeLabel;

	@FXML
	private Label clientPhoneNumberLabel;

	@FXML
	private Label clientEmailLabel;

	@FXML
	private Label clientDebtLabel;

	@FXML
	private Label productLabel1SUP;

	@FXML
	private Label productLabel2SUP;

	@FXML
	private Label productLabel3SUP;

	@FXML
	private Label productLabel4SUP;

	@FXML
	private Label productLabel6SUP;

	@FXML
	private Label productLabel5SUP;

	@FXML
	private TextField productField1SUP;

	@FXML
	private TextField productField2SUP;

	@FXML
	private TextField productField3SUP;

	@FXML
	private TextField productField4SUP;

	@FXML
	private ToggleGroup productBooleanSUP;

	@FXML
	private HBox productRBoxSUP;

	@FXML
	private Button productAddButSUP;
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
	private ChoiceBox<String> iDType;

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
	private ChoiceBox<String> productType;

	@FXML
	private TextField productNameSUP;

    @FXML
    private TextField clientIDSearch;

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
					clientEmailSelfADD.getText().equals("") 
					|| clientIdTypeADD.getValue() == null 
					|| clientIDADD.getText().equals("") || 
					clientPhoneADD.getText().equals("") || clientPasswordADD.getText().equals("")) {

				throw new EmptyFieldException();
			}

			RadioButton selectedRadioButtonGender = (RadioButton) clientGenderADD.getSelectedToggle();

			boolean repeated = m1.addClient(clientFirstNameADD.getText(),
					clientLastNameADD.getText(),
					clientIDADD.getText(), 
					clientIdTypeADD.getValue(), 
					clientAgeADD.getValue(), 
					clientPhoneADD.getText(),
					clientEmailSelfADD.getText(), 
					clientPasswordADD.getText(),
					selectedRadioButtonGender.getText());

			if (repeated) {
				throw new RepeatedException();
			}
			else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Success");
				alert.setHeaderText(null);
				alert.setContentText("Client added successfully!");
				alert.showAndWait();
			}
		}catch(EmptyFieldException | RepeatedException e) {

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
    void searchClient(ActionEvent event) {
    	
    	Client a = m1.searchClientForInformation(clientIDSearch.getText());
    	
    	clientNameLabel.setText(a.getFirstName() + " " + a.getLastName());
    	clientGenderLabel.setText(a.getGender());
    	clientAgeLabel.setText(a.getBirthdate().toString());
    	userIDLabel.setText(a.getiD());
    	systemIDLabel.setText(a.getSystemID());
    	idTypeLabel.setText(a.getiDType());
    	clientPhoneNumberLabel.setText(a.getPhone());
    	clientEmailLabel.setText(a.getEmail());
    	clientDebtLabel.setText(String.valueOf(a.getBalance()));

    }

	@FXML
	public void pay(ActionEvent event) {

		try {
			m1.pay(userIDPAY.getText(), Integer.parseInt(amountToPay.getText()));
		}catch(NumberFormatException e) {
			Alert a = new Alert(AlertType.ERROR, "Input is not a number");
			a.show();

		}

	}

	@FXML
	public void updateClientEmployee(ActionEvent event) {

	}


	public void checkBox() {
		if (productType.getValue().equals("Food")){
			productLabel2SUP.setText("Brand:");
			productLabel3SUP.setText("Quantity:");
			productLabel4SUP.setText("Price:");
			productLabel5SUP.setText("Grams:");
			productLabel6SUP.setText("Gluten:");
		}
		else if (productType.getValue().equals("Drink")) {
			productLabel2SUP.setText("Brand:");
			productLabel3SUP.setText("Quantity:");
			productLabel4SUP.setText("Price:");
			productLabel5SUP.setText("Milliliters:");
			productLabel6SUP.setText("Carbonated:");
		}

		else if(productType.getValue().equals("Soft Candy")) {
			productLabel2SUP.setText("Brand:");
			productLabel3SUP.setText("Quantity:");
			productLabel5SUP.setText("Sugar Quantity:");
			productLabel4SUP.setText("Price:");
			productLabel6SUP.setText("Milk:");
		}

		else if(productType.getValue().equals("Hard Candy")) {

			productLabel2SUP.setText("Brand:");
			productLabel3SUP.setText("Quantity:");
			productLabel5SUP.setText("Sugar Quantity:");
			productLabel4SUP.setText("Price:");
			productLabel6SUP.setText("Acid:");
		}

		else if (productType.getValue().equals("Manga")) {
			productLabel2SUP.setText("P. Date (YYYY-MM-DD):");
			productLabel3SUP.setText("Genre:");
			productLabel4SUP.setText("Bookshelf (1 letter):");
			productLabel1SUP.setVisible(true);
			productLabel2SUP.setVisible(true);
			productLabel3SUP.setVisible(true);
			productLabel4SUP.setVisible(true);
			productLabel5SUP.setVisible(false);
			productLabel6SUP.setVisible(false);
			productNameSUP.setVisible(true);
			productField1SUP.setVisible(true);
			productField2SUP.setVisible(true);
			productField3SUP.setVisible(true);
			productField4SUP.setVisible(false);
			productRBoxSUP.setVisible(false);
		}

		if (!productType.getValue().equals("Manga")) {
			productLabel1SUP.setVisible(true);
			productLabel2SUP.setVisible(true);
			productLabel3SUP.setVisible(true);
			productLabel4SUP.setVisible(true);
			productLabel5SUP.setVisible(true);
			productLabel6SUP.setVisible(true);
			productNameSUP.setVisible(true);
			productField1SUP.setVisible(true);
			productField2SUP.setVisible(true);
			productField3SUP.setVisible(true);
			productField4SUP.setVisible(true);
			productRBoxSUP.setVisible(true);
		}
		productAddButSUP.setDisable(false);
	}

	@FXML
	public void addProduct(ActionEvent event) {
		try {
			boolean repeated = false;
			//Empty fields
			if (productNameSUP.getText().equals("") || productField1SUP.getText().equals("") || 
					productField2SUP.getText().equals("") || productField3SUP.getText().equals("")){

				if (!productType.getValue().equals("Manga")) {
					if (productField4SUP.getText().equals("")) {
						throw new EmptyFieldException();
					}
				}
				else {
					throw new EmptyFieldException();
				}
			}

			if(productType.getValue().equals("Food")) {
				int quantity = Integer.parseInt(productField2SUP.getText());
				int price = Integer.parseInt(productField3SUP.getText());
				double grams = Double.parseDouble(productField4SUP.getText());
				RadioButton radioGluten = (RadioButton) productBooleanSUP.getSelectedToggle();
				boolean gluten = false;
				if (radioGluten.getText().equals("Yes")) {
					gluten = true;
				}

				repeated = m1.addFood(productNameSUP.getText(), productField1SUP.getText(), quantity, 
						price, gluten, grams);
			}

			if(productType.getValue().equals("Drink")) {					

				int quantity = Integer.parseInt(productField2SUP.getText());
				int price = Integer.parseInt(productField3SUP.getText());
				double milliliters = Double.parseDouble(productField4SUP.getText());
				RadioButton carbonated = (RadioButton) productBooleanSUP.getSelectedToggle();
				boolean a = false;
				if (carbonated.getText().equals("Yes")) {
					a = true;
				}


				repeated = m1.addDrink(productNameSUP.getText(), productField1SUP.getText(), quantity, 
						price, a, milliliters);

			}

			if(productType.getValue().equals("Soft Candy")) {


				int quantity = Integer.parseInt(productField2SUP.getText());
				int price = Integer.parseInt(productField3SUP.getText());
				String sugarQuantity = productField4SUP.getText();
				RadioButton carbonated = (RadioButton) productBooleanSUP.getSelectedToggle();
				boolean a = false;
				if (carbonated.getText().equals("Yes")) {
					a = true;
				}


				repeated = m1.addSoftCandy(productNameSUP.getText(), productField1SUP.getText(), 
						quantity, sugarQuantity, price, a);
			}

			if(productType.getValue().equals("Hard Candy")) {
				int quantity = Integer.parseInt(productField2SUP.getText());
				int price = Integer.parseInt(productField3SUP.getText());
				String sugarQuantity = productField4SUP.getText();
				RadioButton carbonated = (RadioButton) productBooleanSUP.getSelectedToggle();
				boolean a = false;
				if (carbonated.getText().equals("Yes")) {
					a = true;
				}


				repeated = m1.addHardCandy(productNameSUP.getText(), productField1SUP.getText(), 
						quantity, sugarQuantity, price, a);

			}

			if(productType.getValue().equals("Manga")) {

				if (productField3SUP.getText().length() > 1 || 
						productField1SUP.getText().matches("[a-zA-Z]+") ||
						productField1SUP.getText().charAt(4) != '-' ||
						productField1SUP.getText().charAt(7) != '-') {
					throw new IllegalArgumentException();
				}

				repeated = m1.addManga(productNameSUP.getText(), productField1SUP.getText(), 
						productField2SUP.getText(), 
						productField3SUP.getText().charAt(0));
			}

			if (repeated) {
				throw new RepeatedException();
			}
			else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Success");
				alert.setHeaderText(null);
				alert.setContentText("Product added successfully!");
				alert.showAndWait();
			}
		} catch (EmptyFieldException | RepeatedException e) {
			Alert a = new Alert(AlertType.ERROR, e.getMessage());
			a.showAndWait();
		} catch (IllegalArgumentException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Invalid input");
			alert.setContentText("A field has an invalid type of data. Try again.");

			alert.showAndWait();
		}
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
		productType.getItems().addAll("Food","Drink","Soft Candy","Hard Candy", "Manga");
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

	public ChoiceBox<String> getProductType() {
		return productType;
	}

}
