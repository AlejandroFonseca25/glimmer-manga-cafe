package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

import customExceptions.LoginException;


public class Manager{
	
	private ArrayList<Client> clients;
	private Employee rootEmployee;
	private Room[] rooms;
	private Manga rootManga;
	private Machine[] machines;
	
	
	public Manager() {
		this.clients = new ArrayList<Client>();
		Room a = new Room("A");
		Room b = new Room("B");
		Room c = new Room("C");
		Room d = new Room("D");
		Room e = new Room("E");
		Room f = new Room("F");
		Room g = new Room("G");
		Room h = new Room("H");
		Room i = new Room("I");
		DeluxeRoom j = new DeluxeRoom("J");
		DeluxeRoom k = new DeluxeRoom("K");
		rooms = new Room[] {a,b,c,d,e,f,g,h,i,j,k};
		rootManga = null;
		rootEmployee = null;
		CandyMachine cm = new CandyMachine();
		FoodMachine fm = new FoodMachine();
		machines = new Machine[] {fm,cm};
	}

	public boolean addClient(String firstName, String lastName, String iD, String iDType, LocalDate birthdate, 
			String phone, String email, String password, String gender) {
		boolean repeated = false;		
		
		for(int i = 0; i<clients.size(); i++) {
			if(((clients.get(i).getiD()).equals(iD)) || ((clients.get(i).getPhone()).equals(phone)) || ((clients.get(i).getEmail()).equals(email))) {
				repeated = true;
			}
		}
		
		if(!repeated) {
			clients.add(new Client(firstName, lastName, iD, iDType, birthdate, gender, phone, email,  password));
		}

		return repeated;
	}

	public boolean addEmployee(String firstName, String lastName, String iD, String iDType, LocalDate birthdate, 
			String phone, String email, String password, String gender, String charge) {
		boolean repeated = false;
		
		repeated = searchRepeatedEmployee (iD, phone, email, rootEmployee);
		
		Employee toAdd = new Employee(firstName, lastName, iD, iDType, birthdate, gender, charge, phone, email, password);
		
		if(!repeated) {
			if (rootEmployee == null) {
				rootEmployee = toAdd;
				System.out.println("hi");
			}
			else {
				addEmployeeRecursive(toAdd, rootEmployee);
			}
		}

		return repeated;
	}

	private boolean searchRepeatedEmployee (String iD, String phone, String email, Employee actual) {
		boolean found = false;
		if (actual != null) {
			if (actual.getID().equals(iD)) {
				found = true;
			}
			else if (Integer.parseInt(iD) < Integer.parseInt(actual.getID())) {
				if (actual.getLeft()!=null) {
					found = searchRepeatedEmployee (iD, phone, email, actual.getLeft());
				}
			}
			else if (Integer.parseInt(iD) < Integer.parseInt(actual.getID())) {
				if (actual.getRight() != null) {
					found = searchRepeatedEmployee (iD, phone, email, actual.getRight());
				}
			}
		}
		return found;
	}
	
	private void addEmployeeRecursive (Employee toAdd, Employee actual) {
		//Left
		if (Integer.parseInt(toAdd.getID()) < Integer.parseInt(actual.getID())) {
			if (actual.getLeft() == null) {
				actual.setLeft(toAdd);
				actual.getLeft().setFather(actual);
			}
			else {
				addEmployeeRecursive (toAdd, actual.getLeft());
			}
		}
		//Right
		else {
			if (actual.getRight() == null) {
				actual.setRight(toAdd);
				actual.getRight().setFather(actual);
			}
			else {
				addEmployeeRecursive (toAdd, actual.getRight());
			}					
		}
	}

	public void saveAll() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data/rooms.txt"));
		oos.writeObject(rooms);
		oos.close();
		oos = new ObjectOutputStream(new FileOutputStream("data/employees.txt"));
		oos.writeObject(rootEmployee);
		oos.close();
		oos = new ObjectOutputStream(new FileOutputStream("data/mangas.txt"));
		oos.writeObject(rootManga);
		oos.close();
		oos = new ObjectOutputStream(new FileOutputStream("data/machines.txt"));
		oos.writeObject(machines);
		oos.close();
		PrintWriter pw = new PrintWriter(new FileWriter("data/clients.txt"));
		for (int i = 0 ; i < clients.size() ; i++) {
			String fName = clients.get(i).getFirstName();
			String lName = clients.get(i).getLastName();
			String id = clients.get(i).getiD();
			String idt = clients.get(i).getiDType();
			String birth = clients.get(i).getBirthdate().toString();
			String gender = clients.get(i).getGender();
			String phone = clients.get(i).getPhone();
			String email = clients.get(i).getEmail();
			String pass = clients.get(i).getPassword();
			pw.println(fName+";"+lName+";"+id+";"+idt+";"+birth+";"+gender+";"+phone+";"+email+";"+pass);
		}
		pw.close();
	}
	
	public void loadAll()  throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data/rooms.txt")); 
		rooms = (Room[]) ois.readObject();	
		ois.close();
		ois = new ObjectInputStream(new FileInputStream("data/employees.txt")); 
		rootEmployee = (Employee) ois.readObject();
		ois.close();
		ois = new ObjectInputStream(new FileInputStream("data/mangas.txt")); 
		rootManga = (Manga) ois.readObject();
		ois.close();
		ois = new ObjectInputStream(new FileInputStream("data/machines.txt")); 
		machines = (Machine[]) ois.readObject();
		ois.close();
	}

	
	
	public ArrayList<Client> getClients() {
		return clients;
	}

	public Employee getRootEmployee() {
		return rootEmployee;
	}

	public Room[] getRooms() {
		return rooms;
	}

	public Manga getRootManga() {
		return rootManga;
	}

	public Machine[] getMachines() {
		return machines;
	}

	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}

	public void setRootEmployee(Employee headEmployee) {
		this.rootEmployee = headEmployee;
	}

	public void setRooms(Room[] rooms) {
		this.rooms = rooms;
	}

	public void setRootManga(Manga rootManga) {
		this.rootManga = rootManga;
	}

	public void setMachines(Machine[] machines) {
		this.machines = machines;
	}

	public boolean checkValues(String posId, String posPassword) throws LoginException {
		boolean valid = false;
		
		for(int i = 0; i<clients.size(); i++) {
			
			if(clients.get(i).getiD().equals(posId)) {
				Client temp = clients.get(i);
				if(temp.getPassword().equals(posPassword)) {
					valid = true;
				}

			}
		}
				
		return valid;
	}
	
	
	
	public void addFood(String name, String brand, int quantity, int price, boolean gluten, double grams) {

		FoodMachine fm = (FoodMachine)machines[0];

		FoodType a = fm.getFirstFood();
		boolean validInput = true;



		while(a.getNext() != fm.getFirstFood() && validInput) {

			if(a.getName().equalsIgnoreCase(name)) {
				validInput = false;
			}
		}

		if(validInput) {
			if(fm.getFirstFood() == null) {
				fm.setFirstFood(new Food(name, brand, quantity, price, gluten, grams));
				fm.getFirstFood().setNext(fm.getFirstFood());
				fm.getFirstFood().setPrev(fm.getFirstFood());
			}

			else {

				FoodType current = fm.getFirstFood();

				while(current.getNext() != fm.getFirstFood()) {
					current = current.getNext();
				}

				current.setNext(new Food(name, brand, quantity, price, gluten, grams));
				current.getNext().setNext(fm.getFirstFood());
				current.getNext().setPrev(current);
				fm.getFirstFood().setPrev(current.getNext());
			}
		}

	}

	
	public void addDrink(String name, String brand, int quantity, int price,  boolean carbonated, double milliliters) {

		FoodMachine fm = (FoodMachine)machines[0];

		FoodType a = fm.getFirstFood();
		boolean validInput = true;


		while(a.getNext() != fm.getFirstFood() && validInput) {

			if(a.getName().equalsIgnoreCase(name)) {
				validInput = false;
			}


		}

		if(validInput) {
			if(fm.getFirstFood() == null) {
				fm.setFirstFood(new Drink(name, brand, quantity, price, carbonated, milliliters));
				fm.getFirstFood().setNext(fm.getFirstFood());
				fm.getFirstFood().setPrev(fm.getFirstFood());
			}

			else {

				FoodType current = fm.getFirstFood();

				while(current.getNext() != fm.getFirstFood()) {
					current = current.getNext();
				}

				current.setNext(new Drink(name, brand, quantity, price, carbonated, milliliters));
				current.getNext().setNext(fm.getFirstFood());
				current.getNext().setPrev(current);
				fm.getFirstFood().setPrev(current.getNext());

			}

		}
	}

}
