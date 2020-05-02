package model;

import java.time.LocalDate;

public class Client {
	
	private String name;
	private String lastName;
	private String iD;
	private String iDType;
	private LocalDate age;
	private String gender;
	private String phone;
	private String email;

	public Client(String name, String lastName, String iD, String iDType, LocalDate age, String gender, String phone,
			String email, String password) {
		
		this.setName(name);
		this.setLastName(lastName);
		this.setiD(iD);
		this.setiDType(iDType);
		this.setAge(age);
		this.setGender(gender);
		this.setPhone(phone);
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getiD() {
		return iD;
	}

	public void setiD(String iD) {
		this.iD = iD;
	}

	public String getiDType() {
		return iDType;
	}

	public void setiDType(String iDType) {
		this.iDType = iDType;
	}

	public LocalDate getAge() {
		return age;
	}

	public void setAge(LocalDate age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
