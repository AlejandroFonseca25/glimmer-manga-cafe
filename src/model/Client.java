package model;

import java.time.LocalDate;

public class Client {
	
	private String firstName;
	private String lastName;
	private String iD;
	private String iDType;
	private LocalDate birthdate;
	private String gender;
	private String phone;
	private String systemID;
	private String email;
	private String password;
	private String status;
	private double balance;
	private Manga[] mangas;

	public Client(String firstName, String lastName, String iD, String iDType, LocalDate birthdate,
			String gender, String phone, String email,  String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.iD = iD;
		this.iDType = iDType;
		this.birthdate = birthdate;
		this.gender = gender;
		this.phone = phone;
		systemID = null;
		this.email = email;
		this.password = password;
		status = "Active";
		balance = 0;
		mangas = new Manga[5];
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getiD() {
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

	public String getPhone() {
		return phone;
	}

	public String getPassword() {
		return password;
	}

	public String getSystemID() {
		return systemID;
	}

	public String getEmail() {
		return email;
	}

	public String getStatus() {
		return status;
	}

	public double getBalance() {
		return balance;
	}
	
	public Manga[] getMangas() {
		return mangas;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setiD(String iD) {
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

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setSystemID(String systemID) {
		this.systemID = systemID;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void setMangas(Manga[] mangas) {
		this.mangas = mangas;
	}
}
