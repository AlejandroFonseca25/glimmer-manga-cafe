package model;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class Employee implements Serializable{
	
	private String firstName;
	private String lastName;
	private String iD;
	private String iDType;
	private LocalDate birthdate;
	private String gender;
	private String charge;
	private String phone;
	private String systemID;
	private String email;
	private String password;
	private String employeeID;
	private Employee father;
	private Employee left;
	private Employee right;
	
	public Employee(String firstName, String lastName, String iD, String iDType, LocalDate birthdate, String gender,
			String charge, String phone, String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.iD = iD;
		this.iDType = iDType;
		this.birthdate = birthdate;
		this.gender = gender;
		this.charge = charge;
		this.phone = phone;
		systemID = null;
		this.email = email;
		this.password = password;
		employeeID = null;
		left = null;
		right = null;
		father = null;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public String getID() {
		return iD;
	}

	public String getiDType() {
		return iDType;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public String getGender() {
		return gender;
	}

	public String getCharge() {
		return charge;
	}

	public String getPhone() {
		return phone;
	}

	public String getSystemID() {
		return systemID;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public Employee getLeft() {
		return left;
	}

	public Employee getRight() {
		return right;
	}

	public String getiD() {
		return iD;
	}

	public Employee getFather() {
		return father;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setID(String iD) {
		this.iD = iD;
	}

	public void setiDType(String iDType) {
		this.iDType = iDType;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setCharge(String charge) {
		this.charge = charge;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setSystemID(String systemID) {
		this.systemID = systemID;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public void setLeft(Employee left) {
		this.left = left;
	}

	public void setRight(Employee right) {
		this.right = right;
	}

	public void setiD(String iD) {
		this.iD = iD;
	}

	public void setFather(Employee father) {
		this.father = father;
	}
}
