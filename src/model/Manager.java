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
import java.time.LocalDateTime;
import java.util.ArrayList;

import customExceptions.LoginException;


public class Manager{
	
	private int systemClient = 0;
	private int systemEmployee = 0;
	private int systemFood = 0;
	private int systemCandy = 0; 
	private int systemManga = 0;
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
		
		init();
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
			Client client = new Client(firstName, lastName, iD, iDType, birthdate, gender, 
					phone, email,  password);
			client.setSystemID("C" + systemClient);
			clients.add(client);
			systemClient++;
			
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
			}
			else {
				addEmployeeRecursive(toAdd, rootEmployee);
			}
			toAdd.setEmployeeID("E" + systemEmployee);
			systemEmployee++;
		}

		return repeated;
	}
	
	public void rentRoom(String room, String time, String userName) {

		Room toSelect = null; 

		for(int i = 0; i < rooms.length; i++) {
			if(rooms[i].getName().equalsIgnoreCase(room)) {
				toSelect = rooms[i];
				break;

			}

		}

		String a = Character.toString(time.charAt(0));		
		Long b = Long.parseLong(a);
		LocalDateTime hours = LocalDateTime.now();
		hours = hours.plusHours(b);

		Client x = null;
		for (int i = 0; i < clients.size(); i++) {
			if(clients.get(i).getiD().equals(userName)) {
				x = clients.get(i);
			}	
		}

		if(x.getBalance() < 300000 && toSelect.isOccupied() == false && toSelect.isEnabled() == true && toSelect instanceof DeluxeRoom) {
			switch(time) {
			case "3":
				x.setBalance(x.getBalance()+45000);
				break;

			case "6":
				x.setBalance(x.getBalance()+70000);
				break;

			case "12":
				x.setBalance(x.getBalance()+110000);
				break;

			case "24":
				x.setBalance(x.getBalance()+150000);
				break;
			}
		}

		else if(x.getBalance() < 300000 && toSelect.isOccupied() == false && toSelect.isEnabled() == true) {
			switch(time) {
			case "3":
				x.setBalance(x.getBalance()+30000);
				break;

			case "6":
				x.setBalance(x.getBalance()+45000);
				break;

			case "12":
				x.setBalance(x.getBalance()+70000);
				break;

			case "24":
				x.setBalance(x.getBalance()+110000);
				break;
			}


			toSelect.setOccupant(x);
			toSelect.setTime(hours);
			toSelect.setOccupied(true);	
		}

		//TODO Lanzar algo cuando el balance excede 300.000 o Está ocupado el cuarto o No esta habilitado (aunque supongo que el admin simplemente quita el boton)
	}

	
	public Room getRoom(String name) {
		
		for (int i = 0; i < rooms.length; i++) {
			if(rooms[i].getName().equals(name)) {
				
				return rooms[i];
			}
			
		}
		
		return null;
		
	}
	
	
	public boolean addFood(String name, String brand, int quantity, int price, boolean gluten, double grams) {
	
		FoodMachine fm = (FoodMachine)machines[0];
	
		FoodType a = fm.getFirstFood();
		boolean repeated = false;
	
	
	
		while(a.getNext() != fm.getFirstFood() && repeated) {
	
			if(a.getName().equalsIgnoreCase(name)) {
				repeated = true;
			}
		}
	
		if(!repeated) {
			Food food = new Food(name, brand, quantity, price, gluten, grams);
			if(fm.getFirstFood() == null) {
				fm.setFirstFood(food);
				fm.getFirstFood().setNext(fm.getFirstFood());
				fm.getFirstFood().setPrev(fm.getFirstFood());
			}
	
			else {
	
				FoodType current = fm.getFirstFood();
	
				while(current.getNext() != fm.getFirstFood()) {
					current = current.getNext();
				}
	
				current.setNext(food);
				current.getNext().setNext(fm.getFirstFood());
				current.getNext().setPrev(current);
				fm.getFirstFood().setPrev(current.getNext());
			}
			food.setSystemID("F"+systemFood);
			systemFood++;
		}
		
		return repeated;
	}

	public boolean addDrink(String name, String brand, int quantity, int price,  boolean carbonated, double milliliters) {
	
		FoodMachine fm = (FoodMachine)machines[0];
	
		FoodType a = fm.getFirstFood();
		boolean repeated = false;
	
	
		while(a.getNext() != fm.getFirstFood() && repeated) {
	
			if(a.getName().equalsIgnoreCase(name)) {
				repeated = true;
			}
		}
	
		if(!repeated) {
			Drink drink = new Drink(name, brand, quantity, price, carbonated, milliliters);
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
	
				current.setNext(drink);
				current.getNext().setNext(fm.getFirstFood());
				current.getNext().setPrev(current);
				fm.getFirstFood().setPrev(current.getNext());
			}
			drink.setSystemID("D" + systemFood);
			systemFood++;
		}
		
		return repeated;
	}

	public boolean addSoftCandy(String name, String brand, int quantity, String sugarQuantity, int price, boolean milk) {
		
		CandyMachine cm = (CandyMachine) machines[1];
	
		Candy a = cm.getFirstCandy();
		boolean repeated = false;
	
	
	
		while(a.getNext() != cm.getFirstCandy() && repeated) {
	
			if(a.getName().equalsIgnoreCase(name)) {
				repeated = true;
			}
		}
	
		if(!repeated) {
			SoftCandy sc = new SoftCandy(name, brand, quantity, sugarQuantity, price, milk);
			if(cm.getFirstCandy() == null) {
				cm.setFirstCandy(sc);
				cm.getFirstCandy().setNext(cm.getFirstCandy());
				cm.getFirstCandy().setPrev(cm.getFirstCandy());
			}
	
			else {
	
				Candy current = cm.getFirstCandy();
	
				while(current.getNext() != cm.getFirstCandy()) {
					current = current.getNext();
				}
	
				current.setNext(sc);
				current.getNext().setNext(cm.getFirstCandy());
				current.getNext().setPrev(current);
				cm.getFirstCandy().setPrev(current.getNext());
			}
			sc.setSystemID("K" + systemCandy);
			systemCandy++;
		}
		
		return repeated;
		
	}

	public boolean addHardCandy(String name, String brand, int quantity, String sugarQuantity, int price, boolean acid) {
		
		CandyMachine cm = (CandyMachine) machines[1];
	
		Candy a = cm.getFirstCandy();
		boolean repeated = false;
	
	
	
		while(a.getNext() != cm.getFirstCandy() && repeated) {
	
			if(a.getName().equalsIgnoreCase(name)) {
				repeated = true;
			}
		}
	
		if(!repeated) {
			HardCandy hc = new HardCandy(name, brand, quantity, sugarQuantity, price, acid);
			if(cm.getFirstCandy() == null) {
				cm.setFirstCandy(hc);
				cm.getFirstCandy().setNext(cm.getFirstCandy());
				cm.getFirstCandy().setPrev(cm.getFirstCandy());
			}
	
			else {
	
				Candy current = cm.getFirstCandy();
	
				while(current.getNext() != cm.getFirstCandy()) {
					current = current.getNext();
				}
	
				current.setNext(hc);
				current.getNext().setNext(cm.getFirstCandy());
				current.getNext().setPrev(current);
				cm.getFirstCandy().setPrev(current.getNext());
			}
			hc.setSystemID("K" + systemCandy);
			systemCandy++;
		}
		
		return repeated;
	}
	
	public boolean addManga(String name, String publishingDate, String genre, char bookshelf) {
		boolean repeated = false;
		
		LocalDate pd = LocalDate.parse(publishingDate);
		repeated = searchRepeatedManga (name, pd, rootManga);
		
		Manga toAdd = new Manga(name, publishingDate, genre, bookshelf);
		toAdd.setSystemId("M"+systemManga);
		systemManga++;
		if(!repeated) {
			if (rootManga == null) {
				rootManga = toAdd;
			}
			else {
				addMangaRecursive(toAdd, rootManga);
			}
		}
		
		return repeated;
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

	public boolean searchEmployeeLogin(String iD, String password) {
		
		return searchEmployeeLoginRecursive(iD, password, rootEmployee);
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
			else if (Integer.parseInt(iD) > Integer.parseInt(actual.getID())) {
				if (actual.getRight() != null) {
					found = searchRepeatedEmployee (iD, phone, email, actual.getRight());
				}
			}
		}
		return found;
	}
	
	private boolean searchRepeatedManga (String name, LocalDate pubDate, Manga actual) {
		boolean found = false;
		if (actual != null) {
			if (actual.getName().equals(name)) {
				found = true;
			}
			else if (pubDate.compareTo(LocalDate.parse(actual.getPublishingDate())) < 0) {
				if (actual.getLeft()!=null) {
					found = searchRepeatedManga (name, pubDate, actual.getLeft());
				}
			}
			else if (pubDate.compareTo(LocalDate.parse(actual.getPublishingDate())) > 0) {
				if (actual.getRight()!=null) {
					found = searchRepeatedManga (name, pubDate, actual.getRight());
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
	
	private void addMangaRecursive (Manga toAdd, Manga actual) {
		//Left
		if (LocalDate.parse(toAdd.getPublishingDate()).compareTo
				(LocalDate.parse(actual.getPublishingDate())) <= 0) {
			if (actual.getLeft() == null) {
				actual.setLeft(toAdd);
				actual.getLeft().setFather(actual);
			}
			
			else {
				addMangaRecursive (toAdd, actual.getLeft());
			}
		}
		//Right
		else {
			if (actual.getRight() == null) {
				actual.setRight(toAdd);
				actual.getRight().setFather(actual);
			}
			else {
				addMangaRecursive (toAdd, actual.getRight());
			}					
		}
	}

	private boolean searchEmployeeLoginRecursive(String iD, String password, Employee actual) {
		
		boolean found = false;
		if (actual != null) {
			if (actual.getID().equals(iD) && actual.getPassword().equals(password)) {
				found = true;
			}
			
			else if (Integer.parseInt(iD) < Integer.parseInt(actual.getID())) {
				if (actual.getLeft()!=null) {
					found = searchEmployeeLoginRecursive (iD, password, actual.getLeft());
				}
			}
			
			else if (Integer.parseInt(iD) > Integer.parseInt(actual.getID())) {
				if (actual.getRight() != null) {
					found = searchEmployeeLoginRecursive (iD, password, actual.getRight());
				}
			}
		}
		return found;
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
			double balance = clients.get(i).getBalance();
			String status = clients.get(i).getStatus();
			String systemID = clients.get(i).getSystemID();
			String manga = "";
			for (int j = 0; j < clients.get(i).getMangas().length; j++) {
				if (clients.get(i).getMangas()[j] != null) {
					manga += clients.get(i).getMangas()[j].getName() + ";";
				}
			}
			
			pw.println(fName+";"+lName+";"+id+";"+idt+";"+birth+";"+gender+";"+phone+";"+email+";"+
			pass+";"+balance+";"+status+";"+systemID+";"+manga);
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

	public void init () {
		LocalDate lc = LocalDate.of(1998,1,17);
		clients.add(new Client("Alex","Dumphy","1016387643","Identity Card",lc,"Female",
				"2039574831","alex@yahoo.com","science100"));
		lc = LocalDate.of(1970,5,23);
		clients.add(new Client("Claire","Dumphy","1256432363","Citizen ID",lc,"Female",
				"2497865210","claire@hotmail.com","phil250"));
		lc = LocalDate.of(1967,4,3);
		clients.add(new Client("Phil","Dumphy","1096387122","Citizen ID",lc,"Male",
				"2659970237","phil@NYrealstate.com","claire701"));
		lc = LocalDate.of(1993,12,10);
		clients.add(new Client("Hayley","Dumphy","1176537865","Citizen ID",lc,"Female",
				"26943286954","haley@gmail.com","dylan123"));
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

	public void pay(String useriD, int amountToPay) {
		
		for(int i = 0; i < clients.size(); i++) {
			if(clients.get(i).getiD().equals(useriD)) {
				clients.get(i).setBalance(clients.get(i).getBalance() - amountToPay);
				break;
			}
			
		}
		
	}
	
}
