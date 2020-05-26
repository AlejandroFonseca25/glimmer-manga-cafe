package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import customExceptions.LoginException;
import interfaces.Sortable;


public class Manager implements Sortable{

	private int systemClient = 0;
	private int systemEmployee = 0;
	private int systemFood = 0;
	private int systemCandy = 0; 
	private int systemManga = 0;
	private static final String PATH = "data/clients.txt";
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

		for(int i = 0; i<clients.size() && !repeated; i++) {
			if(((clients.get(i).getiD()).equalsIgnoreCase(iD)) || 
					((clients.get(i).getPhone()).equalsIgnoreCase(phone)) || 
					((clients.get(i).getEmail()).equalsIgnoreCase(email))) {

				repeated = true;
			}
		}

		if(!repeated) {
			Client client = new Client(firstName, lastName, iD, iDType, birthdate, gender, 
					phone, email,  password);
			client.setSystemID("C" + systemClient);
			clients.add(client);
			systemClient++;
			Random r = new Random();
			int method = r.nextInt(5);
			switch (method) {
			case 0:
				bubbleSort();
			case 1:
				insertionSort();
			case 2:
				selectionSort();
			case 3:
				sortByFirstName();
			case 4:
				sortByPhone();
			}
			System.out.println(clients.toString());
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
			toAdd.setSystemID("E" + systemEmployee);
			systemEmployee++;
		}

		return repeated;
	}

	public boolean addFood(String name, String brand, int quantity, int price, boolean gluten, double grams) {

		FoodMachine fm = (FoodMachine)machines[0];

		FoodType a = fm.getFirstFood();
		boolean repeated = false;


		Food food = new Food(name, brand, quantity, price, gluten, grams);

		if(fm.getFirstFood() == null) {
			fm.setFirstFood(food);
			fm.getFirstFood().setNext(fm.getFirstFood());
			fm.getFirstFood().setPrev(fm.getFirstFood());
		}

		while(a.getNext() != fm.getFirstFood() && repeated) {

			if(a.getName().equalsIgnoreCase(name)) {
				repeated = true;
			}
		}

		if(!repeated) {

			FoodType current = fm.getFirstFood();

			while(current.getNext() != fm.getFirstFood()) {
				current = current.getNext();
			}

			current.setNext(food);
			current.getNext().setNext(fm.getFirstFood());
			current.getNext().setPrev(current);
			fm.getFirstFood().setPrev(current.getNext());

			food.setSystemID("F"+systemFood);
			systemFood++;
		}

		return repeated;
	}

	public boolean addDrink(String name, String brand, int quantity, int price,  boolean carbonated, double milliliters) {

		FoodMachine fm = (FoodMachine)machines[0];

		FoodType a = fm.getFirstFood();
		boolean repeated = false;

		Drink drink = new Drink(name, brand, quantity, price, carbonated, milliliters);
		if(fm.getFirstFood() == null) {
			fm.setFirstFood(new Drink(name, brand, quantity, price, carbonated, milliliters));
			fm.getFirstFood().setNext(fm.getFirstFood());
			fm.getFirstFood().setPrev(fm.getFirstFood());
		}

		else{

			while(a.getNext() != fm.getFirstFood() && repeated) {

				if(a.getName().equalsIgnoreCase(name)) {
					repeated = true;
				}
			}


			if(!repeated) {
				FoodType current = fm.getFirstFood();

				while(current.getNext() != fm.getFirstFood()) {
					current = current.getNext();
				}

				current.setNext(drink);
				current.getNext().setNext(fm.getFirstFood());
				current.getNext().setPrev(current);
				fm.getFirstFood().setPrev(current.getNext());

				drink.setSystemID("D" + systemFood);
				systemFood++;
			}
		}

		return repeated;
	}

	public boolean addSoftCandy(String name, String brand, int quantity, String sugarQuantity, 
			int price, boolean milk) {

		CandyMachine cm = (CandyMachine) machines[1];

		Candy a = cm.getFirstCandy();
		boolean repeated = false;

		SoftCandy sc = new SoftCandy(name, brand, quantity, sugarQuantity, price, milk);

		if(cm.getFirstCandy() == null) {
			cm.setFirstCandy(sc);
			cm.getFirstCandy().setNext(cm.getFirstCandy());
			cm.getFirstCandy().setPrev(cm.getFirstCandy());
		}

		else {
			while(a.getNext() != cm.getFirstCandy() && repeated) {
				if(a.getName().equalsIgnoreCase(name)) {
					repeated = true;
				}
			}

			if(!repeated) {
				Candy current = cm.getFirstCandy();

				while(current.getNext() != cm.getFirstCandy()) {
					current = current.getNext();
				}

				current.setNext(sc);
				current.getNext().setNext(cm.getFirstCandy());
				current.getNext().setPrev(current);
				cm.getFirstCandy().setPrev(current.getNext());

				sc.setSystemID("K" + systemCandy);
				systemCandy++;
			}
		}
		return repeated;
	}

	public boolean addHardCandy(String name, String brand, int quantity, String sugarQuantity, int price, boolean acid) {

		CandyMachine cm = (CandyMachine) machines[1];

		Candy a = cm.getFirstCandy();
		boolean repeated = false;
		HardCandy hc = new HardCandy(name, brand, quantity, sugarQuantity, price, acid);


		if(cm.getFirstCandy() == null) {
			cm.setFirstCandy(hc);
			cm.getFirstCandy().setNext(cm.getFirstCandy());
			cm.getFirstCandy().setPrev(cm.getFirstCandy());
		}


		else {
			while(a.getNext() != cm.getFirstCandy() && repeated) {


				if(a.getName().equalsIgnoreCase(name)) {
					repeated = true;
				}
			}

			if(!repeated) {



				Candy current = cm.getFirstCandy();

				while(current.getNext() != cm.getFirstCandy()) {
					current = current.getNext();
				}

				current.setNext(hc);
				current.getNext().setNext(cm.getFirstCandy());
				current.getNext().setPrev(current);
				cm.getFirstCandy().setPrev(current.getNext());

				hc.setSystemID("K" + systemCandy);
				systemCandy++;
			}


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

		if(x.getBalance() > -300000 && toSelect.isOccupied() == false && toSelect.isEnabled() == true && toSelect instanceof DeluxeRoom) {
			switch(time) {
			case "3":
				x.setBalance(x.getBalance()-45000);
				break;

			case "6":
				x.setBalance(x.getBalance()-70000);
				break;

			case "12":
				x.setBalance(x.getBalance()-110000);
				break;

			case "24":
				x.setBalance(x.getBalance()-150000);
				break;
			}
		}

		else if(x.getBalance() > -300000 && toSelect.isOccupied() == false && toSelect.isEnabled() == true) {
			switch(time) {
			case "3":
				x.setBalance(x.getBalance()-30000);
				break;

			case "6":
				x.setBalance(x.getBalance()-45000);
				break;

			case "12":
				x.setBalance(x.getBalance()-70000);
				break;

			case "24":
				x.setBalance(x.getBalance()-110000);
				break;
			}


			toSelect.setOccupant(x);
			toSelect.setTime(hours);
			toSelect.setOccupied(true);	
		}

		//TODO Lanzar algo cuando el balance excede 300.000 o Está ocupado el cuarto o No esta habilitado (aunque supongo que el admin simplemente quita el boton)
	}


	public void pay(String useriD, int amountToPay) {
		boolean paid = false;
		for(int i = 0; i < clients.size() && !paid; i++) {
			if(clients.get(i).getiD().equals(useriD)) {
				clients.get(i).setBalance(clients.get(i).getBalance() + amountToPay);
				paid = true;
			}
		}	
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

	public Client searchClientForInformation (String iD) {
		bubbleSort();
		Client client = null;
		int first = 0;
		int last = clients.size() - 1;
		int middle = (first + last) / 2;
		while (first <= last) {
			
			if (Integer.parseInt(clients.get(middle).getiD()) < Integer.parseInt(iD)) {
				first = middle + 1;
			} else if (Integer.parseInt(clients.get(middle).getiD()) == Integer.parseInt(iD)) {
				client = clients.get(middle);
				break;
			} else {
				last = middle - 1;
			}
			middle = (first + last) / 2;
		}
		return client;
	}
	
	public boolean updateRoom (String iD, boolean change) {
		boolean somethingHappened = false;
		int roomASCII = (int) iD.charAt(0);
		int first = 0;
		int last = rooms.length - 1;
		int middle = (first + last) / 2;
		while (first <= last) {
			
			int actualRoomASCII = (int) rooms[middle].getName().charAt(0);
			if (actualRoomASCII < roomASCII) {
				first = middle + 1;
			} else if (actualRoomASCII == roomASCII) {
				rooms[middle].setEnabled(change);
				somethingHappened = true;
				break;
			} else {
				last = middle - 1;
			}
			middle = (first + last) / 2;
		}
		return somethingHappened;
	}
	
	public Employee searchEmployeeForManagement(String iD, Employee actual) {
		Employee employee = null;
		if (actual != null) {
			if (actual.getID().equals(iD)) {
				employee = actual;
			}
			else if (Integer.parseInt(iD) < Integer.parseInt(actual.getID())) {
				if (actual.getLeft()!=null) {
					employee = searchEmployeeForManagement(iD, actual.getLeft());
				}
			}
			else if (Integer.parseInt(iD) > Integer.parseInt(actual.getID())) {
				if (actual.getRight() != null) {
					employee = searchEmployeeForManagement(iD, actual.getRight());
				}
			}
		}
		return employee;
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

	private Manga searchMangaForLoad (Manga actual, String mangaName) {
		Manga toReturn = null;

		if (actual.getLeft() != null) {
			toReturn = searchMangaForLoad(actual.getLeft(), mangaName);  
		}

		if (actual.getRight() != null) {
			toReturn = searchMangaForLoad(actual.getRight(), mangaName);  
		}

		if (mangaName.equals(actual.getName())) {
			toReturn = actual;
		}
		return toReturn;
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
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(PATH)));
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

			bw.write(fName+";"+lName+";"+id+";"+idt+";"+birth+";"+gender+";"+phone+";"+email+";"+
					pass+";"+balance+";"+status+";"+systemID+";"+manga);
			bw.newLine();
		}
		bw.close();
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

		BufferedReader br = new BufferedReader(new FileReader(new File ("data/clients.txt")));
		String client = br.readLine();

		while (client != null) {
			String[] a = client.split(";");
			LocalDate ld = LocalDate.parse(a[4]);
			Client temp = new Client(a[0], a[1], a[2], a[3], ld, a[5], a[6], a[7], a[8]);
			temp.setBalance(Double.parseDouble(a[9]));
			temp.setStatus(a[10]);
			temp.setSystemID(a[11]);

			int j = 0;
			for (int i = 12; i < a.length; i++) {
				Manga manga = searchMangaForLoad(rootManga, a[i]);
				temp.getMangas()[j] = manga;
				j++;
			}
			clients.add(temp);
			client = br.readLine();
		}
		br.close();
	}

	public void init () {
		//Clients
		LocalDate lc = LocalDate.of(1998,1,17);
		addClient("Alex", "Dumphy", "1016387643", "Identity Card", lc, "2039574831",
				"alex@yahoo.com","science100", "Female");

		lc = LocalDate.of(1970,5,23);	
		addClient("Claire", "Dumphy", "1256432363", "Citizen ID", lc, "2497865210", 
				"claire@hotmail.com", "phil250", "Female");

		lc = LocalDate.of(1967,4,3);		
		addClient("Phil","Dumphy","1096387122","Citizen ID",lc, "2659970237", 
				"phil@NYrealstate.com", "claire701", "Male");

		lc = LocalDate.of(1993,12,10);
		addClient("Hayley","Dumphy","1176537865","Citizen ID",lc, "2694328695",
				"haley@gmail.com","dylan123", "Female");

		lc = LocalDate.of(2001,8,25);
		addClient("Larry","Marcelo","123","Foreigner ID",lc, "0011335599", 
				"larry@marcelo.com", "123", "Male");

		//Employees
		lc = LocalDate.of(1978,8,1);
		addEmployee("Monika", "Weiss", "1005133788", "Foreigner ID", lc, "3448512391", 
				"monika@GSG9.com", "iq200", "Female", "IT Maintenance");
		lc = LocalDate.of(1980,4,20);
		addEmployee("Erik", "Thorn", "1004276954", "Foreigner ID", lc, "7071547649", 
				"erik@theunit.com", "maverick13", "Male", "General Fixes");
		lc = LocalDate.of(1981,4,2);
		addEmployee("Seamus", "Cowden", "1006228417", "Foreigner ID", lc, "3159673209", 
				"seamus@SAS.com", "sledge888", "Male", "Remodelator");
		lc = LocalDate.of(2001, 8, 25);
		addEmployee("Alejandro", "Fonseca", "123", "Citizen ID", lc, "3187653153", 
				"alejandrof@gmail.com", "234", "Male", "Cashier");
		//Food & Drink
		addDrink("Coca Cola", "Coca Cola Company", 15, 2500, true, 250);
		addFood("Chocoramo", "Ramo", 10, 1300, true, 65);
		addDrink("Mr. Tea", "Postobon S.A", 15, 2500, false, 250);
		//Candies
		addSoftCandy("Bubbaloo", "Adams", 50, "5", 300, false);
		addHardCandy("Bon Bon Bum", "Colombina", 40, "10", 500, true);
		addSoftCandy("Bianchi", "Super", 50, "3,3", 300, false);
		//Mangas
		addManga("Nidoume No Jinsei Wo Isekai De", "2016-11-13", "Isekai", 'A');
		addManga("Bakemonogatari", "2006-11-01", "Mistery", 'B');
		addManga("Jojo's Bizarre Adventure: Stell Ball Run", "2004-01-19", "Seinen", 'C');
		addManga("Mob Psycho 100", "2012-04-18", "Action", 'D');
		addManga("Uzumaki", "1998-01-13", "Horror", 'D');
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
	
	public Room getRoom(String name) {
		Room room = null;
		for (int i = 0; i < rooms.length; i++) {
			if (rooms[i].getName().equalsIgnoreCase(name)) {
				room = rooms[i];
			}
		}
		return room;
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

	@Override
	public void bubbleSort() {
		for (int i = 0 ; i < clients.size() - 1; i++) {
			for (int j = 0 ; j < clients.size() - i - 1; j++) {
				if (Integer.parseInt(clients.get(i).getiD()) > Integer.parseInt(clients.get(j+1).getiD())) 
				{ 
					Client temp = clients.get(j); 
					clients.set(j, clients.get(j+1));
					clients.set(j+1, temp); 
				}
			}
		}
	}

	@Override
	public void selectionSort() {
        for (int i = 0; i < clients.size() - 1; i++) 
        { 
            int minimum = i; 
            for (int j = i + 1; j < clients.size(); j++) 
                if (Integer.parseInt(clients.get(j).getiD()) < 
                		Integer.parseInt(clients.get(minimum).getiD())) {
                    minimum = j; 
                }

            
            Client temp = clients.get(minimum); 
            clients.set(minimum, clients.get(i));
            clients.set(i, temp);
        } 
	}

	@Override
	public void insertionSort() {
        for (int i = 1; i < clients.size(); ++i) { 
        	int key = Integer.parseInt(clients.get(i).getiD());
        	Client keyClient = clients.get(i);
            int j = i - 1; 
  
            while (j >= 0 && Integer.parseInt(clients.get(j).getiD()) > key) { 
                clients.set(j + 1, clients.get(j));
                j = j - 1; 
            } 
            clients.set(j + 1, keyClient);
        } 
	}
	
	public void sortByFirstName() {
		
		Collections.sort(clients);
	}
	
	public void sortByPhone() {
		Comparator<Client> c = new Comparator<Client>(){

			@Override
			public int compare(Client c1, Client c2) {
				int dif = 0;
				
				if (c1.getPhone().compareTo(c2.getPhone()) <= 0) {
					dif = -1;
				}
				else if (c1.getPhone().compareTo(c2.getPhone()) > 0){
					dif = 1;
				}
				return dif;
			}
			
		};
		Collections.sort(clients, c);
	}
}
